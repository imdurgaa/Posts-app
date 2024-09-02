package com.durga.springboot_blog_rest_api.service.impl;

import com.durga.springboot_blog_rest_api.DTO.PostDto;
import com.durga.springboot_blog_rest_api.entity.Post;
import com.durga.springboot_blog_rest_api.exception.ResourceNotFoundException;
import com.durga.springboot_blog_rest_api.repository.PostRepository;
import com.durga.springboot_blog_rest_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPostDto(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepository.save(post);
        PostDto postDtoresponse = mapToDto(savedPost);
        return postDtoresponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(Post -> mapToDto(Post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "Id", id));
        return mapToDto(post);

    }

    @Override
    public PostDto updatePostById(PostDto postDto,Long  id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "Id", id));
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        Post updatedPost = postRepository.save(post);



        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post","Id",id));
        postRepository.deleteById(post);


    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setId(postDto.getId());
        return post;
    }

    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        return postDto;
    }
}
