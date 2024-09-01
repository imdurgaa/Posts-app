package com.durga.springboot_blog_rest_api.service;


import com.durga.springboot_blog_rest_api.DTO.PostDto;
import com.durga.springboot_blog_rest_api.entity.Post;


public interface PostService {
    PostDto createPostDto(PostDto postDto);

}
