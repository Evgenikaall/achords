package com.achords.service.post;

import com.achords.model.dto.post.PostDTO;
import com.achords.model.entity.post.Post;
import com.achords.repository.postRepo.PostRepo;
import com.achords.utils.converters.PostConverter;
import com.achords.utils.exceptions.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;
    private final PostConverter postConverter;

    public List<PostDTO> findAll(){
        return postRepo.findAll().stream().map(postConverter::mapToDTO).collect(Collectors.toList());
    }

    public Post save(Post post) {
        return postRepo.save(post);
    }

    public PostDTO findDtoById(Integer id) throws PostNotFoundException {
        return postConverter.mapToDTO(postRepo.findById(id).orElseThrow(PostNotFoundException::new));
    }

    public Post findById(Integer id) throws PostNotFoundException {
        return postRepo.findById(id).orElseThrow(PostNotFoundException::new);
    }


}
