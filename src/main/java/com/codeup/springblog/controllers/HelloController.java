package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
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
