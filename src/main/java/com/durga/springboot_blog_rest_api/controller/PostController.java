package com.durga.springboot_blog_rest_api.controller;

import com.durga.springboot_blog_rest_api.DTO.PostDto;
import com.durga.springboot_blog_rest_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostDto> createPostDto(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPostDto(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findByPostId(@PathVariable Long id) {


        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatedPostById(@RequestBody PostDto postDto, @PathVariable Long id) {
        PostDto postResponseDto = postService.updatePostById(postDto, id);
        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletById(@PathVariable Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }


}
