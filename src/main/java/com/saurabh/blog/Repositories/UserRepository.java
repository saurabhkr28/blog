package com.saurabh.blog.Repositories;

import com.saurabh.blog.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
//    long deleteByEmail(String email);

    @Modifying
    @Query("delete from User b where b.email=:email")
    void deleteByEmail(@Param("email") String email);
}
