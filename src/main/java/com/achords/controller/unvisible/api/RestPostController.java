package com.achords.controller.unvisible.api;

import com.achords.model.dto.post.PostDTO;
import com.achords.service.post.PostService;
import com.achords.utils.exceptions.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class RestPostController {

    private final PostService postService;

    @GetMapping("/page/{pageNo}")
    public ResponseEntity<List<PostDTO>> getAll(@PathVariable Integer pageNo) {
        try{
            return ResponseEntity.ok(postService.findPaginated(pageNo));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(postService.findDtoById(id));
        }catch (PostNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
