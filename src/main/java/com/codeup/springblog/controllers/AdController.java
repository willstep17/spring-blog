package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.AdRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdController {

    private AdRepo adDao;

    public AdController(AdRepo adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> getAllAds() {
        return adDao.findAll();
    }

}


    INSERT INTO dogs (age, name, reside_state)
    VALUES
            (2, 'Chuck', 'MI'),
          (5, 'Fred', 'OH'),
          (3, 'Bud', 'TN'),
          (10, 'Bailey', 'AL'),
          (11, 'Lexie', 'MO'),
          (1, 'Snickers', 'AZ'),
          (6, 'Red', 'FL'),
          (8, 'Barney', 'CA'),
          (12, 'Bowser', 'TX');
