package com.achords.controller.visible;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignPageController {

    @GetMapping("/login")
    public String loginPage(){
        return "signup";
    }
}
