package com.vennygo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Page");
        model.addAttribute("introduction", "Venny");
        model.addAttribute("name", "고은혜");
        model.addAttribute("nickname", "venny");
        model.addAttribute("birthday", "94.12.16");
        model.addAttribute("email", "eunhea2186@gmail.com");
        return "about";
    }

    @GetMapping("/header")
    public String header() {
        return "fragments/header";
    }

    @GetMapping("/footer")
    public String footer() {
        return "fragments/footer";
    }

    @GetMapping("/layout")
    public String layout() {
        return "layouts/layout";
    }
}
