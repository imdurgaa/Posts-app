package com.durga.springboot_blog_rest_api.service.impl;

import com.durga.springboot_blog_rest_api.DTO.PostDto;
import com.durga.springboot_blog_rest_api.entity.Post;
import com.durga.springboot_blog_rest_api.repository.PostRepository;
import com.durga.springboot_blog_rest_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPostDto(PostDto postDto) {


        Post post = new Post();
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setId(postDto.getId());
        Post savedPost = postRepository.save(post);


        PostDto postResponseDto = new PostDto();
        postResponseDto.setId(savedPost.getId());
        postResponseDto.setDescription(savedPost.getDescription());
        postResponseDto.setTitle(savedPost.getTitle());
        postResponseDto.setContent(savedPost.getContent());
        return postResponseDto;

    }
}
