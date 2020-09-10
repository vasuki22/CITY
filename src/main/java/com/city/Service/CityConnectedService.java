package com.city.Service;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public interface CityConnectedService {
    public String isConnectedCity(String origin, String destination) throws IOException;
}
