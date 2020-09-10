package com.city.Controller;

import com.city.Service.CityConnectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping
public class CityController {
    public static final Logger LOGGER=Logger.getLogger(CityController.class.getName());

    @Autowired
    private CityConnectedService cityConnectedService;

    @GetMapping("/connected")
    public String validateConnection(@RequestParam String origin, String destination){
        String response=null;
        try {
            response = cityConnectedService.isConnectedCity(origin, destination);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
        return response;
    }
}
