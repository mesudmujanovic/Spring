package com.example.demo.Controler;

import com.example.demo.Service.CommentService;
import com.example.demo.models.dto.CommentDto;
import com.example.demo.models.request.CommentRequestD;
import com.example.demo.models.response.CommentResponseE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentControler {
    private CommentService commentService;

    public CommentControler(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentResponseE> save(@PathVariable Long postId, @RequestBody CommentRequestD commentRequestD){
        CommentDto commentDto = CommentDto.fromCommentRequest(commentRequestD);
        CommentDto comentSave = commentService.saveComment(postId,commentDto);
        return ResponseEntity.ok(comentSave.fromCommentResponse());
    }
}
