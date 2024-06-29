package com.vennygo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainViewController {

    @GetMapping("")
    public String home() {
        return "redirect:/about";
    }
}