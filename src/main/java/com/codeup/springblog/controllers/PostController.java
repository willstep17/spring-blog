package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.DogRepo;
import com.codeup.springblog.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private PostRepo postDao;

    public PostController(PostRepo postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts/edit/{id}")
    public String getPostsEdit(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/update")
    public String updatePost(@RequestParam long id, @RequestParam String title, @RequestParam String body) {
        Post post = postDao.findPostById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
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
