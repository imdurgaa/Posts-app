package com.durga.springboot_blog_rest_api.DTO;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String description;
}
