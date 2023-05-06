package com.example.demo.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
//ovaj deo prikazujemo korisniku odnosno saljemo Clientu
public class PostResponseE {
    private Long id;
    private String title;
    private String description;
}

