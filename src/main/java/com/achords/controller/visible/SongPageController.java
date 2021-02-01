package com.achords.controller.visible;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;

@Controller
@RequestMapping("/post")
public class SongPageController {

    @GetMapping("/{id}")
    public String songPage(@PathVariable Integer id, Model model){
        model.addAttribute(id);
        return "login";
    }


}
