package com.durga.springboot_blog_rest_api.service;

import com.durga.springboot_blog_rest_api.DTO.PostDto;
import java.util.List;

public interface PostService {
    PostDto createPostDto(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    PostDto updatePostById(PostDto postDto, Long id);

    void deletePostById(Long id);

}
