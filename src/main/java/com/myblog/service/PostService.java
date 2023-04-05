package com.myblog.service;

import com.myblog.payload.PostDto;
import com.myblog.payload.PostResponse;

public interface PostService {


    PostDto createPost(PostDto postDto);


   PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);


    void deletePostById(long id);
}
