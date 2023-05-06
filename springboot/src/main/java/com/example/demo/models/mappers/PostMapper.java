package com.example.demo.models.mappers;

import com.example.demo.Entity.Post;
import com.example.demo.Intergration.DTOMapper;
import com.example.demo.models.dto.PostDto;

public enum PostMapper implements DTOMapper<Post, PostDto> {
    INSTANCE;

    @Override
    public Post apply(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        return post;
    }
}
