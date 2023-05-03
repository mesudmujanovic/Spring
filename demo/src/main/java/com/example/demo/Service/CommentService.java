package com.example.demo.Service;

import com.example.demo.models.dto.CommentDto;

public interface CommentService {

public CommentDto saveComment(Long postId,CommentDto commentDto);
}
