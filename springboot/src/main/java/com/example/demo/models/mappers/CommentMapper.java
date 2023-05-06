package com.example.demo.models.mappers;

import com.example.demo.Entity.Comment;
import com.example.demo.Intergration.DTOMapper;
import com.example.demo.models.dto.CommentDto;

public enum CommentMapper implements DTOMapper<Comment,CommentDto> {
    INSTANCE;

    @Override
    public Comment apply(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        return comment;
    }

}
