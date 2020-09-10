package com.city;

import com.city.Controller.CityController;
import com.city.Service.CityConnectedService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(classes = CityConfiguration.class)
class CityControllerTest {

    @Autowired
    private CityController cityController;

    @Autowired
    private CityConnectedService cityConnectedService;


    @Test
    public void when_calling_validateCity_with_valid_origin_and_designation_then_return_yes() {
        String response= cityController.validateConnection("Boston", "NewYork");
        Assert.assertEquals("yes", response);
    }

    @Test
    public void when_calling_validateCity_with_invalid_origin_or_designation_then_return_no() {
        String response= cityController.validateConnection("invalidOrigin", "NewYork");
        Assert.assertEquals("no", response);
    }

    @Test
    public void when_calling_validateCity_with_null_value_for_origin_or_designation_then_return_no() {
        String response= cityController.validateConnection("Boston", null);
        Assert.assertEquals("no", response);
    }

    @Test
    public void when_calling_validateCity_with_empty_value_for_origin_or_designation_then_return_no() {
        String response= cityController.validateConnection("Boston", "");
        Assert.assertEquals("no", response);
    }


}
