package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepo;
import com.codeup.springblog.repositories.UserRepo;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepo postDao;
    private UserRepo userDao;

    @Autowired
    private EmailService emailService;

    public PostController(PostRepo postDao, UserRepo userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String getLanding() {
        return "posts/landing";
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model) {
        model.addAttribute("posts", postDao.getOne(id));
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String getCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postNewPost(@ModelAttribute Post post) {
        post.setUser(userDao.getOne(1L));
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String getPostsEdit(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        Post p = postDao.getOne(id);
        p.setTitle(post.getTitle());
        p.setBody(post.getBody());
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        postDao.deleteById(id);
        return "redirect:/posts";
    }

}
