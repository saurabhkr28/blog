package com.saurabh.blog.Controllers;

import com.saurabh.blog.Pojo.PostData;
import com.saurabh.blog.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public PostData savePost(@RequestBody PostData postData){
        return postService.savePost(postData);
    }

    @PostMapping("/Post/{id}")
    public PostData getPostById(@PathVariable int id){
        return postService.getPostById(id);
    }

    public List<PostData> getAllPostsForUser(@PathVariable int userId){
        return postService.getAllPostForUser(userId);
    }
}
