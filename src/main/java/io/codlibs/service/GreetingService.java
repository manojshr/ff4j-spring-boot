package io.codlibs.service;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import static io.codlibs.config.FF4JConfig.HELLO_FEATURE;

@Service
public class GreetingService {

    @Autowired
    private FF4j ff4j;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            while (true) {
                if (ff4j.check(HELLO_FEATURE)) {
                    System.out.println("Hello FF4J");
                } else {
                    System.out.println("Hello World");
                }
                Thread.sleep(5000);
            }
        };
    }
}
