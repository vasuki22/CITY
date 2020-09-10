package com.city.Service;

import com.city.CityConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;


@SpringBootTest(classes = CityConfiguration.class)
class CityConnectedServiceImplTest {

    private CityConnectedServiceImpl cityConnectedService = new CityConnectedServiceImpl();

    @Test()
    public void when_passing_invalid_file_path_then_throw_FileNotFoundException(){
        cityConnectedService.cityFilePath ="invalid_file_path";
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            cityConnectedService.isConnectedCity("Boston", "NewYork");
        });
    }

}