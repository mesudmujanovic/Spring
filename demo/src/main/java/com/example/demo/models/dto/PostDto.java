package com.example.demo.models.dto;

import com.example.demo.models.request.PostRequestD;
import com.example.demo.models.response.PostResponseE;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;

    public static PostDto fromRequestD(PostRequestD postRequest){
        PostDto postDto = new PostDto();
        postDto.setTitle(postRequest.getTitle());
        postDto.setDescription(postRequest.getDescription());
        return  postDto;
    }

    public PostResponseE fromResponseE(){
        PostResponseE postResponse = new PostResponseE();
        postResponse.setId(this.getId());
        postResponse.setTitle(this.getTitle());
        postResponse.setDescription(this.getDescription());
        return postResponse;
    }
}
