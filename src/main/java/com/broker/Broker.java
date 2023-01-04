package com.broker;

import com.broker.api.BrokerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = BrokerController.class)
public class Broker {

    public static void main(String[] args) {
        SpringApplication.run(Broker.class, args);
    }
}
