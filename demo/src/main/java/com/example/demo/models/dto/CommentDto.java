package com.example.demo.models.dto;

import com.example.demo.models.request.CommentRequestD;
import com.example.demo.models.response.CommentResponseE;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String body;
    private String name;
    private String email;

    public  static CommentDto fromCommentRequest(CommentRequestD commentRequestD){
        CommentDto commentDto = new CommentDto();
        commentDto.setBody(commentRequestD.getBody());
        commentDto.setName(commentRequestD.getName());
        commentDto.setEmail(commentRequestD.getEmail());
        return commentDto;
    }

    public CommentResponseE fromCommentResponse(){
        CommentResponseE commentResponseE = new CommentResponseE();
        commentResponseE.setId(this.getId());
        commentResponseE.setBody(this.getBody());
        commentResponseE.setEmail(this.getEmail());
        commentResponseE.setName(this.getName());
        return commentResponseE;
    }
}
