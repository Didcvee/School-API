package ru.didcvee.analyserwebsocketservice.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import ru.didcvee.analyserwebsocketservice.config.RedisSchema;
import ru.didcvee.analyserwebsocketservice.entity.Grade;
import ru.didcvee.analyserwebsocketservice.entity.Summary;
import ru.didcvee.analyserwebsocketservice.entity.SummaryType;

import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class SummaryRepositoryImpl implements SummaryRepository {
    private final JedisPool jedisPool;

    @Override
    public Optional<Summary> findByGroupName(String groupName,
                                             Set<SummaryType> summaryTypes) {
        try (Jedis jedis = jedisPool.getResource()) {
            if (!jedis.sismember(
                    RedisSchema.groupKeys(),
                    groupName
            )) {
                return Optional.empty();
            }
            if (!summaryTypes.isEmpty()) {
                return getSummary(
                        groupName,
                        summaryTypes,
                        jedis
                );
            } else {
                return getSummary(
                        groupName,
                        Set.of(SummaryType.values()),
                        jedis
                );
            }

        }
    }

    @Override
    public void handle(Grade grade) {
        try (Jedis jedis = jedisPool.getResource()) {
            if(!jedis.sismember(
                    RedisSchema.groupKeys(),
                    grade.getGroupNumber()
            )) {
                jedis.sadd(
                    RedisSchema.groupKeys(),
                        grade.getGroupNumber()
                );
            }

            updateSumAndAvgValue(grade, jedis);
        }
    }
    private void updateSumAndAvgValue(
            Grade grade,
            Jedis jedis
    ) {
        updateSumValue(grade, jedis);
        String key = RedisSchema.groupKey(
          grade.getGroupNumber()
        );
        String counter = jedis.hget(
                key,
                "counter"
        );
        if (counter == null) {
            counter = String.valueOf(
              jedis.hset(
                      key,
                      "counter",
                      String.valueOf(1)
              )
            );
        } else {
            counter = String.valueOf(
                    jedis.hincrBy(
                            key,
                            "counter",
                            1
                    )
            );
        }
        String sum = jedis.hget(
                key,
                SummaryType.SUM.name().toLowerCase()
        );
        jedis.hset(
                key,
                SummaryType.AVG.name().toLowerCase(),
                String.valueOf(
                        Double.parseDouble(sum) / Double.parseDouble(counter)
                )
        );
    }
    private void updateSumValue(Grade grade, Jedis jedis) {
        String key = RedisSchema.groupKey(grade.getGroupNumber());
        String value = jedis.hget(
                key,
                SummaryType.SUM.name().toLowerCase()
        );
        if (value == null) {
            jedis.hset(
                    key,
                    SummaryType.SUM.name().toLowerCase(),
                    String.valueOf(grade.getMark().getValue())
            );
        } else {
            jedis.hincrByFloat(
                    key,
                    SummaryType.SUM.name().toLowerCase(),
                    grade.getMark().getValue()
            );
        }
    }

    private Optional<Summary> getSummary(String groupName,
                                         Set<SummaryType> summaryTypes,
                                         Jedis jedis) {
        Summary summary = new Summary();
        summary.setGroupName(groupName);
        for (SummaryType sType : summaryTypes) {
            Summary.SummaryEntry entry = new Summary.SummaryEntry();
            entry.setType(sType);

            String value = jedis.hget(
                    RedisSchema.groupKey(groupName),
                    sType.name().toLowerCase()
            );
            if (value != null) {
                entry.setValue(Double.parseDouble(value));
            }
            summary.addValue(entry);
        }

        return Optional.of(summary);
    }
}
