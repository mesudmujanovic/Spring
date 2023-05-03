package com.example.demo.Service.impl;

import com.example.demo.Entity.Post;
import com.example.demo.Repository.PostRepo;
import com.example.demo.Service.PostService;
import com.example.demo.models.dto.PostDto;
import com.example.demo.models.mappers.PostDtoMapper;
import com.example.demo.models.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public PostDto savePost(PostDto postDto) {
        // Pretvaranje postDto u Post preko PostMappera
        Post post = PostMapper.INSTANCE.apply(postDto);
        //Cuvanje Post u bazu podataka
        Post postSave = postRepo.save(post);
        //Dohvatanje postSave iz baze i pretvaranje u PostDtoMapper
        return PostDtoMapper.INSTANCE.apply(postSave);
    }

    @Override
    public List<PostDto> getAllPosts() {
        //metoda findAll() vraca listu Post(Entity) svih pronadjenih postova
        //onda preko stream().map(post->) uzimamo svaki pojedinacni Post iz baze
        //zatim se primenjuje metoda INSTANCE.aplly na PostDtoMapper koji vraca dto
        //
        return postRepo.findAll().stream().map(post->PostDtoMapper
                .INSTANCE.apply(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        return PostDtoMapper.INSTANCE.apply(post);
    }

    @Override
    public PostDto deletePost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        postRepo.deleteById(id);
        return PostDtoMapper.INSTANCE.apply(post);
    }

    @Override
    public PostDto getPost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return PostDtoMapper.INSTANCE.apply(post);
    }
}
