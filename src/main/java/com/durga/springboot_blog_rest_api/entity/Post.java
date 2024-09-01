package com.durga.springboot_blog_rest_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @Column(name = "Description",nullable = false, length = 500)
    private String description;
    @Column(name = "Content", nullable = false, length = 500)
    private String content;

}
