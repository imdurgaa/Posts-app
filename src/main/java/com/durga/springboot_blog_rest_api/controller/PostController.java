package com.durga.springboot_blog_rest_api.controller;


import com.durga.springboot_blog_rest_api.DTO.PostDto;
import com.durga.springboot_blog_rest_api.service.PostService;
import com.durga.springboot_blog_rest_api.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostServiceImpl postServiceImpl;

    public PostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto createPostDto(@RequestBody PostDto postDto) {

        return postServiceImpl.createPostDto(postDto);
    }




}
