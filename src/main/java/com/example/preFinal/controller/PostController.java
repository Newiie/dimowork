package com.example.preFinal.controller;

import com.example.preFinal.PostRepository;
import com.example.preFinal.model.Post;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getALlPosts() {
        return repo.findAll();
    }

    @PostMapping("/post")
    public boolean addPost(@RequestBody Post post) {
        try {
            repo.save(post);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @DeleteMapping("/posts/{id}")
    public boolean deletePost(@PathVariable String id) {
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/reply")
    public boolean addReply(
            @RequestParam("user_id") int userId,
            @RequestParam("post_id") int postId,
            @RequestParam("reply") String replyText) {

        try {

            Post originalPost = repo.findById(Integer.toString(postId)).orElse(null);

            if (originalPost != null) {
                originalPost.addReply(replyText);
                repo.save(originalPost);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
