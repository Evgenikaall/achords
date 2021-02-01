package com.achords.controller.visible;

import com.achords.model.dto.user.UserDetailsImpl;
import com.achords.model.entity.song.Author;
import com.achords.model.entity.song.Genre;
import com.achords.model.entity.user.User;
import com.achords.service.song.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collections;

@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage(Principal principal){
        return "index";
    }
}
