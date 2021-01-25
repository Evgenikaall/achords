package com.achords.service.post;

import com.achords.model.dto.post.PostDTO;
import com.achords.model.dto.song.SongDTO;
import com.achords.model.entity.post.Post;
import com.achords.repository.postRepo.PostRepo;
import com.achords.utils.converters.PostConverter;
import com.achords.utils.converters.SongConverter;
import com.achords.utils.converters.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;
    private final PostConverter postConverter;

    public List<PostDTO> findPaginated(int pageNo, int pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<PostDTO> page = postRepo.findAll(paging).map(postConverter::mapToDTO);
        return page.toList();
    }

    public Post save(Post post){
        return postRepo.save(post);
    }


}
