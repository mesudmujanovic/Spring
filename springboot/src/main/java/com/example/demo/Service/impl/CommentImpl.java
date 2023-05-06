package com.example.demo.Service.impl;


import com.example.demo.Entity.Comment;
import com.example.demo.Repository.CommentRepo;
import com.example.demo.Repository.PostRepo;
import com.example.demo.Service.CommentService;
import com.example.demo.Service.PostService;
import com.example.demo.models.dto.CommentDto;
import com.example.demo.models.mappers.CommentDtoMapper;
import com.example.demo.models.mappers.CommentMapper;
import com.example.demo.models.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentImpl implements CommentService {
    public CommentImpl(CommentRepo commentRepo, PostRepo postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    @Autowired
    public PostService postService;
    private CommentRepo commentRepo;
    private PostRepo postRepo;

    @Override
    public CommentDto saveComment(Long postId, CommentDto commentDto) {
        Comment comment = CommentMapper.INSTANCE.apply(commentDto);
        comment.setPost(PostMapper.INSTANCE.apply(postService.getPost(postId)));
        Comment saveComment = commentRepo.save(comment);
        return CommentDtoMapper.INSTANCE.apply(saveComment);
    }

}
