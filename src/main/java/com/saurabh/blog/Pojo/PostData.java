package com.saurabh.blog.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saurabh.blog.Models.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostData {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
}
