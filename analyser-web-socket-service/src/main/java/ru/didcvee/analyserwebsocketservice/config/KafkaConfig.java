package ru.didcvee.analyserwebsocketservice.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.yaml.snakeyaml.Yaml;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String servers;
    @Value("${topics}")
    private List<String> topics;

    @Bean
    public Map<String, Object> receiverProperties() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getResourceAsStream("/kafka/consumer.yml");
        Map<String, Map<String,Object>> data = yaml.load(inputStream);

        System.out.println(data.get("consumer").get("groupId"));

        Map<String, Object> props = new HashMap<>(5);
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers
        );
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG, data.get("consumer").get("groupId").toString()
        );
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, data.get("consumer").get("keyDeserializer").toString()
        );
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, data.get("consumer").get("valueDeserializer").toString()
        );
        props.put(
                "spring.json.trusted.packages", data.get("consumer").get("trustedPackages").toString()
        );

        return props;
    }

    @Bean
    public ReceiverOptions<String, Object> receiverOptions() {
        ReceiverOptions<String, Object> receiverOptions = ReceiverOptions.create(receiverProperties());
        return receiverOptions.subscription(topics)
                .addAssignListener(partition -> {
                    System.out.println("assigned: "+partition);
                })
                .addRevokeListener(partition -> {
                    System.out.println("revoked: "+partition);
                });
    }

    @Bean
    public KafkaReceiver<String, Object> receiver(ReceiverOptions<String, Object> receiverOptions) {
        return KafkaReceiver.create(receiverOptions);
    }
}
