package com.achords.service.post;

import com.achords.model.dto.post.PostDTO;
import com.achords.model.dto.song.SongDTO;
import com.achords.model.entity.post.Post;
import com.achords.repository.postRepo.PostRepo;
import com.achords.utils.converters.PostConverter;
import com.achords.utils.converters.SongConverter;
import com.achords.utils.converters.UserConverter;
import com.achords.utils.exceptions.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;
    private final PostConverter postConverter;

    public List<PostDTO> findPaginated(int pageNo) {
        Pageable paging = PageRequest.of(pageNo, 20, Sort.by("views").descending());
        Page<PostDTO> page = postRepo.findAll(paging).map(postConverter::mapToDTO);
        return page.toList();
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
