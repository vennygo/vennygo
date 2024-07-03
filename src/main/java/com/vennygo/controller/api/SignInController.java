package com.vennygo.controller.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sign-in")
@RequiredArgsConstructor
@Tag(name = "sign-in")
public class SignInController {



}
