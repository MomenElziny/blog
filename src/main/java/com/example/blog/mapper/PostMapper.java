
package com.example.blog.mapper;

import java.util.stream.Collectors;

import com.example.blog.dto.PostDto;
import com.example.blog.model.Post;

public class PostMapper {

 // Post entity -> Post DTO
    public static PostDto mapToPostDto(Post post)
    {
        return PostDto.builder().
                id(post.getId()).
                title(post.getTitle()).
                url(post.getUrl()).
                content(post.getContent()).
                shortDescription(post.getShortDescription()).
                createdOn(post.getCreatedOn()).
                updatedOn(post.getUpdatedOn()).
                comments(post.getComments().stream().
                        map((comment)->CommentMapper.mapToDto(comment)).
                        collect(Collectors.toSet()))
                .build();
    }
    // Post DTO -> Post entity
    public static Post mapToPost(PostDto postDto)
    {
        return Post.builder().
                id(postDto.getId()).
                title(postDto.getTitle()).
                url(postDto.getUrl()).
                content(postDto.getContent()).
                shortDescription(postDto.getShortDescription()).
                createdOn(postDto.getCreatedOn()).
                updatedOn(postDto.getUpdatedOn()).build();
    }

}
