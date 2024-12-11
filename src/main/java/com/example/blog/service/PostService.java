package com.example.blog.service;
import java.util.List;

import com.example.blog.dto.PostDto;

public interface PostService {
List<PostDto> findAllPosts();
    void createPost(PostDto postDto);
    PostDto findPostById(Long postId);
    void updatePost(PostDto postDto);
    void deletePost(Long postId);
    PostDto findPostByUrl(String postUrl);
    List<PostDto> searchPost(String query);
    List<PostDto> findPostByUser();
}
