package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class HelloController {

    @GetMapping("/hello/fruit")
    public String getHelloFruit(Model model) {
        List<String> fruitBasket = new ArrayList<>();
        fruitBasket.add("Mango");
        fruitBasket.add("Apple");
        fruitBasket.add("Pineapple");
        fruitBasket.add("Orange");
        fruitBasket.add("Papaya");
        model.addAttribute("fruitBasket", fruitBasket);
        return "fruit";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/increment/{number}")
    @ResponseBody
    public String increment(@PathVariable int number) {
        return "The number " + number + " plus 1 is " + (number + 1);
    }

    //Another way to map paths
    @RequestMapping(path = "/decrement/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String decrement(@PathVariable int number) {
        return "The number " + number + " minus 1 is " + (number - 1);
    }
}