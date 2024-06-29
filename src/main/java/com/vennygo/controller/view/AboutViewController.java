package com.vennygo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutViewController {

    @GetMapping("")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Page");
        model.addAttribute("introduction", "Venny");
        model.addAttribute("name", "고은혜");
        model.addAttribute("nickname", "venny");
        model.addAttribute("birthday", "94.12.16");
        model.addAttribute("email", "eunhea2186@gmail.com");
        return "about";
    }
}
