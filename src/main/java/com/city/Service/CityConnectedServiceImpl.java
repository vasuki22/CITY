package com.city.Service;


import com.city.Controller.CityController;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CityConnectedServiceImpl implements CityConnectedService {
    public static final Logger LOGGER = Logger.getLogger(CityController.class.getName());

    protected String cityFilePath = "../city/src/main/resources/city.txt";

    @Override
    public String isConnectedCity(String origin, String destination) throws IOException, FileNotFoundException {
        String isConnected = "no";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(cityFilePath));
            String row;
            String[] cities = null;
            while ((row = bufferedReader.readLine()) != null) {
                cities = row.split(",");
                if (cities[0].equalsIgnoreCase(origin) && cities[1].equalsIgnoreCase(destination)) {
                    isConnected = "yes";
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "City.txt is not found");
            throw e;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error in file reading");
            throw e;
        }
        return isConnected;
    }
}
