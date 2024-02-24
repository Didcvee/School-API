package ru.didcvee.diaryserviceconsumer.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Bean
    public FlywayConfig flyway(MongoTemplate mongoTemplate) {
        Flyway flyway = Flyway.configure()
                .dataSource(new)
                .locations("db/migration")
                .load();
        flyway.setCallbacks(new MongoFlywayCallback());
        flyway.migrate();
        return flyway;
    }
}
