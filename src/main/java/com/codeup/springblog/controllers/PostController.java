package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getPosts(Model model){
        ArrayList<Post> postList = new ArrayList<>();
        postList.add(new Post(2, "Second Post", "askdfhkashdfkjahsdf"));
        postList.add(new Post(3, "Third Post", "some more text..."));

        model.addAttribute("posts", postList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model model) {
        Post post1 = new Post(id, "Europa's First Post", "Remote learning today");
        model.addAttribute("title", post1.getTitle());
        model.addAttribute("body", post1.getBody());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreatePostForm() {
        return "view form for creating posts";
    }

    @PostMapping("/posts/create")
    public String postNewPost() {
        return "create a new post";
    }

}
