package com.saurabh.blog.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Users")
public class User {
    @Id
    @SequenceGenerator(name = "Random_Sequence", initialValue = 1001, allocationSize = 30)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Random_Sequence")
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Gender")
    private Integer gender;

    @Column(name ="Bio")
    private String bio;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String role;

    @Column(name = "Post_Count")
    private int postCount=0;

}
