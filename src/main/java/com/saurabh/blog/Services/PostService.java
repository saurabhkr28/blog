package com.saurabh.blog.Services;

import com.saurabh.blog.Models.Post;
import com.saurabh.blog.Models.User;
import com.saurabh.blog.Pojo.PostData;
import com.saurabh.blog.Pojo.UserData;
import com.saurabh.blog.Repositories.PostRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostData savePost(PostData postData){
        Post post = convertToModel(postData);
        Post newPost = postRepository.save(post);
        return convertToData(newPost);
    }

    public PostData getPostById(int id){
        Post post = postRepository.findById(id).orElse(new Post());
        PostData postData = convertToData(post);
        return postData;

    }

    public List<PostData> getAllPostForUser(int userId){
        List<Post> posts = postRepository.findByUserId(userId);
        return posts.stream().map(this::convertToData).collect(Collectors.toList());
    }

    public PostData convertToData(Post post){
        PostData postData = new PostData();
        BeanUtils.copyProperties(post,postData);
        return postData;
    }

    public Post convertToModel(PostData postData){
        Post post = new Post();
        BeanUtils.copyProperties(postData,post);
        return post;
    }
}
