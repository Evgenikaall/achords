package com.achords.controller.unvisible.api;

import com.achords.model.dto.post.PostDTO;
import com.achords.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/{pageNo}/{pageSize}")
    public List<PostDTO> getAll(@PathVariable Integer pageNo, @PathVariable Integer pageSize){
        return postService.findPaginated(pageNo,pageSize);
    }


}
