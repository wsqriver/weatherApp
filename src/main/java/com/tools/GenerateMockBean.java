package com.tools;

import com.city.bean.City;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenerateMockBean {

    @Bean
    @ConfigurationProperties(prefix = "city1")
    public City city1() {
        return new City();
    }
    @Bean
    @ConfigurationProperties(prefix = "city2")
    public City city2() {
        return new City();
    }
    @Bean
    @ConfigurationProperties(prefix = "city3")
    public City city3() {
        return new City();
    }
}
