package ru.didcvee.diaryserviceconsumer.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class BeanConfig {

    @SneakyThrows
    @Bean
    public XML consumerXML() {
        return new XMLDocument(
//                new File("C:\\Users\\Didcvee\\Documents\\jwt-apigateway-security-main\\diary-service-consumer\\src\\main\\resources\\kafka\\consumer.xml")
                getClass().getResourceAsStream("/kafka/consumer.xml")
                        .readAllBytes() // для докера
        );
    }

}
