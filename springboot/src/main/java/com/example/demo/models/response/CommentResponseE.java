package com.example.demo.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseE {

    public Long id;
    public String email;
    public String name;
    public String body;

}
