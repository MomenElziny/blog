package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blog.dto.CommentDto;
import com.example.blog.dto.PostDto;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.CommentService;
import com.example.blog.service.PostService;
import com.example.blog.util.SecurityUtils;

import jakarta.validation.Valid;


@Controller
public class CommentController {
    private  CommentService commentService;
    private  PostService postService;
    private  UserRepository userRepository;
    public CommentController(CommentService commentService, PostService postService,UserRepository userRepository) {
        this.commentService = commentService;
        this.postService = postService;
        this.userRepository = userRepository;
    }

    public CommentController() {
    }


    
    @PostMapping("/{postUrl}/comments")
    public String createComment(@PathVariable("postUrl") String postUrl,
                                Model model,
                                @Valid @ModelAttribute("comment") CommentDto commentDto,
                                BindingResult result)
    {
        PostDto postDto = postService.findPostByUrl(postUrl);
        if(result.hasErrors())
        {
            model.addAttribute("post",postDto);
            model.addAttribute("comment",commentDto);
            return "blog/blog_post";
        }
        String userEmail = SecurityUtils.getCurrentUser().getUsername();
         userRepository.findByEmail(userEmail).getId();
        commentService.createComment(postUrl,commentDto);
        return "redirect:/post/"+postUrl;
    }
}
