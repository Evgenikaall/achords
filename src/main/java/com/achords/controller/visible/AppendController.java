package com.achords.controller.visible;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppendController {

    @GetMapping("/add_new")
    public String appendPage(){
        return "add_new";
    }
}
