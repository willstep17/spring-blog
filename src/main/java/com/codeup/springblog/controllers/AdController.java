package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.AdRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/ads/search/{title}")
    public String searchAd(@PathVariable String title, Model model) {
        model.addAttribute("ad", adDao.findByTitle(title));
        return "ads/search";
    }
}


