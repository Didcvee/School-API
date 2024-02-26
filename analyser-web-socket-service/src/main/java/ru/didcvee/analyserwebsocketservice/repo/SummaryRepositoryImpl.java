package ru.didcvee.analyserwebsocketservice.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import ru.didcvee.analyserwebsocketservice.config.RedisSchema;
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
