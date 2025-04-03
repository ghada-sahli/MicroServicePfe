package com.esprit.microservice.eurikapfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurikaPfeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurikaPfeApplication.class, args);
    }

}
