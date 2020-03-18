package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Dog;
import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostRepo extends JpaRepository<Post, Long> {
    Post findPostById(long id);
}