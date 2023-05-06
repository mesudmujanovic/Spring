package com.example.demo.models.mappers;

import com.example.demo.Entity.Comment;
import com.example.demo.Intergration.DTOMapper;
import com.example.demo.models.dto.CommentDto;

public enum CommentDtoMapper implements DTOMapper<CommentDto, Comment> {
    INSTANCE;
    @Override
    public CommentDto apply(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setBody(comment.getBody());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        return commentDto;
    }
}
