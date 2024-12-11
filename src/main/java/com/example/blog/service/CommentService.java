package com.example.blog.service;

import java.util.List;

import com.example.blog.dto.CommentDto;
public interface CommentService {
 void createComment(String url, CommentDto commentDto);

    List<CommentDto> findAllComments();

    void deleteComment(Long commentId);
    List<CommentDto> findCommentsByPost();


}
