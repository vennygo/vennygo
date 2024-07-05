package com.vennygo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign-in")
public class SignInViewController {

    @GetMapping("")
    public String signIn(Model model) {
        return "signIn";
    }
}
