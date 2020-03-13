package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {

    @GetMapping("/roll-dice/${number}")
    public String getDice(@PathVariable int number, Model model) {
        int diceRoll = (int) Math.ceil(Math.random() * 6);
        boolean sameRoll = number == diceRoll;
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("sameRoll", sameRoll);
        return "dice";
    }
}
