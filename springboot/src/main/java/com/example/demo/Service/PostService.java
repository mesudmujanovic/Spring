package com.example.demo.Service;

import com.example.demo.Entity.Post;
import com.example.demo.models.dto.PostDto;

import java.util.List;

public interface PostService {
    public PostDto savePost(PostDto postDto);

    public List<PostDto> getAllPosts();

    public PostDto getPostById(Long id);

    public  PostDto deletePost(Long id);
    public PostDto getPost(Long id);
}
