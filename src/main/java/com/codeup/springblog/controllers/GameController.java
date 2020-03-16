package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {

    @GetMapping("/roll-dice/{guess}")
    public String getDice(@PathVariable int guess, Model model) {
        String message;
        int diceRoll = (int) Math.ceil(Math.random() * 6);
        if (guess == diceRoll) {
            message = "You guessed the random number!";
        } else {
            message = "Sorry, try again!";
        }
        model.addAttribute("message", message);
        model.addAttribute("guess", guess);
        model.addAttribute("diceRoll", diceRoll);
        return "dice";
    }
}
