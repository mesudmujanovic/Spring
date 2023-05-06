package com.example.demo.models.mappers;

import com.example.demo.Entity.Post;
import com.example.demo.Intergration.DTOMapper;
import com.example.demo.models.dto.PostDto;

public enum PostDtoMapper implements DTOMapper<PostDto, Post> {
    INSTANCE;

    @Override
    public PostDto  apply(Post item) {
        PostDto postDto = new PostDto();
        postDto.setId(item.getId());
        postDto.setTitle(item.getTitle());
        postDto.setDescription(item.getDescription());
        return postDto;
    }
}
