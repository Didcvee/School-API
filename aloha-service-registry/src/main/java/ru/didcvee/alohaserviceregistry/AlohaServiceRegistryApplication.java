package ru.didcvee.alohaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AlohaServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlohaServiceRegistryApplication.class, args);
    }

}
