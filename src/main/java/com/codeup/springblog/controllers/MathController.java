package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class MathController {

    @GetMapping("/add/{firstNum}/and/{secondNum}")
    @ResponseBody
    public String add(@PathVariable int firstNum, @PathVariable int secondNum) {
        return "" + firstNum + " + " + secondNum + " = " +  (firstNum + secondNum);
    }

    @GetMapping("/subtract/{firstNum}/from/{secondNum}")
    @ResponseBody
    public String subtract(@PathVariable int firstNum, @PathVariable int secondNum) {
        return "" + firstNum + " * " + secondNum + " = " +  (firstNum * secondNum);
    }

    @GetMapping("/multiply/{firstNum}/and/{secondNum}")
    @ResponseBody
    public String multiply(@PathVariable int firstNum, @PathVariable int secondNum) {
        return "" + firstNum + " / " + secondNum + " = " +  (firstNum / secondNum);
    }

    @GetMapping("/divide/{firstNum}/by/{secondNum}")
    @ResponseBody
    public String divide(@PathVariable int firstNum, @PathVariable int secondNum) {
        return "" + firstNum + " / " + secondNum + " = " +  (firstNum / secondNum);
    }
}