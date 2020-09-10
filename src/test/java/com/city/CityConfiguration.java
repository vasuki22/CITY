package com.city;

import com.city.Controller.CityController;
import com.city.Service.CityConnectedServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityConfiguration {
    @Bean
    public CityController cityController(){return new CityController();}

    @Bean
    public CityConnectedServiceImpl cityConnectedService(){return new CityConnectedServiceImpl();}
}
