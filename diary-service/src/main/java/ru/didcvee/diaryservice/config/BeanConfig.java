package ru.didcvee.diaryservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class BeanConfig {
    @Autowired
    private ResourceLoader resourceLoader;
    @Bean
    @SneakyThrows
    public XML producerXML() {
        return new XMLDocument(
//                new File("C:\\Users\\Didcvee\\Documents\\jwt-apigateway-security-main\\diary-service\\src\\main\\resources\\kafka\\producer.xml")
                getClass().getResourceAsStream("/kafka/producer.xml")
                        .readAllBytes() // для докера

        );
    }


}
