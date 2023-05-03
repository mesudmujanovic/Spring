package com.example.demo.Controler;
import com.example.demo.Service.PostService;
import com.example.demo.models.dto.PostDto;
import com.example.demo.models.request.PostRequestD;
import com.example.demo.models.response.PostResponseE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class PostControler {
    private PostService postService;

    public PostControler(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/save")
  public ResponseEntity<PostResponseE> savePost(@RequestBody PostRequestD postRequestD){
        // slanje postRequestD iz PostDto klase iz fromRequest istance u PostDto tj newPostDto
        PostDto newPostDto = PostDto.fromRequestD(postRequestD);
        PostDto resultDto = postService.savePost(newPostDto);
        //return vraca fromResponse iz ResultDto u PostResponse
       return ResponseEntity.ok(resultDto.fromResponseE());
    }

    @GetMapping("/posts")
    public  ResponseEntity<List<PostResponseE>> getAllPosts(){
        List<PostDto> postdto = postService.getAllPosts();
        // PostDto::fromResponseE  // PostDto-> PostDt0.fromResponse moze i ovako
        return ResponseEntity.ok(postdto.stream().map(PostDto::fromResponseE).collect(Collectors.toList()));
    }

    @GetMapping("posts/{id}")
    public  ResponseEntity<PostResponseE> getPostById(@PathVariable long id){
        return ResponseEntity.ok(postService.getPostById(id).fromResponseE());
    }

    @DeleteMapping("post/{id}")
    public  ResponseEntity<PostResponseE> deletePostById(@PathVariable long id){
        return ResponseEntity.ok(postService.deletePost(id).fromResponseE());
    }
}
