package io.codlibs.config;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.core.FlippingStrategy;
import org.ff4j.strategy.time.ReleaseDateFlipStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.ff4j.strategy.time.ReleaseDateFlipStrategy.DATE_PATTERN;

@Configuration
public class FF4JConfig {

    public static final String HELLO_FEATURE = "hellofeature";

    @Bean
    public FF4j ff4j() {
        FF4j ff4j = new FF4j();
        Feature helloFeature = new Feature(HELLO_FEATURE);
        FlippingStrategy releaseDateFlipStrategy = new ReleaseDateFlipStrategy(getCurrentTimePlusOneMinute());
        helloFeature.setEnable(true);
        helloFeature.setFlippingStrategy(releaseDateFlipStrategy);
        ff4j.createFeature(helloFeature);
        return ff4j;
    }


    private String getCurrentTimePlusOneMinute() {
        LocalDateTime flippingTime = LocalDateTime.now().plusMinutes(1);
        return flippingTime.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
}
