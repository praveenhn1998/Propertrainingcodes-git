package com.myblog.controller;

import com.myblog.payload.PostDto;
import com.myblog.payload.PostResponse;
import com.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }
   //http://localhost:8080/api/posts
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Object>createPost(@Valid @RequestBody PostDto postDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);


    }
   //http://localhost:8080/api/posts?pageNo=0&pageSize=3&sortBy=content&sortDir=asc
    @GetMapping
    public PostResponse getAllPost(@RequestParam(value ="pageNo",defaultValue = "0",required = false) int pageNo,
                                   @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
                                   @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy,
                                   @RequestParam(value = "sortDir",defaultValue = "asc",required = false)String sortDir
    ){

       return  postService.getAllPost(pageNo,pageSize,sortBy,sortDir);

    }
    //http://localhost:8080/api/posts/1
    @GetMapping("/{id}")

    public ResponseEntity<PostDto>getPostById(@PathVariable("id")long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //http://localhost:8080/api/posts/1
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable("id") long id){
        PostDto dto = postService.updatePost(postDto, id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //http://localhost:8080/api/posts/1
    @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")

    public  ResponseEntity<String> deletePostById(@PathVariable("id")long id){
      postService.deletePostById(id);
      return new ResponseEntity<>("post entity deleted!!!",HttpStatus.OK);
  }


    }





