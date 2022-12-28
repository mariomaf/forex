package broker.service;

import broker.api.BrokerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = BrokerController.class)
public class QuoteService {


    public static void main(String[] args) {
        SpringApplication.run(QuoteService.class, args);

    }



}
