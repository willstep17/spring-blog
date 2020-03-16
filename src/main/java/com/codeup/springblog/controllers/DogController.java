package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.Dog;
import com.codeup.springblog.repositories.AdRepo;
import com.codeup.springblog.repositories.DogRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DogController {

    private DogRepo dogDao;

    public DogController(DogRepo dogDao) {
        this.dogDao = dogDao;
    }

    @GetMapping("/dogs")
    @ResponseBody
    public List<Dog> getAllAds() {
        return dogDao.findAll();
    }

}