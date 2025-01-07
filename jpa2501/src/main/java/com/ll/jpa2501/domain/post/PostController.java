package com.ll.jpa2501.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public Post showPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/findByUsername/{username}")
    public List<Post> findByUsername(@PathVariable("username") String username) {
        return postService.findByUsername(username);
    }

    @GetMapping("/findWithShareLockById/{id}")
    public Post findWithShareLockById(@PathVariable Long id) {
        return postService.findWithShareLockById(id).orElse(null);
    }

    @GetMapping("/findWithWriteLockById/{id}")
    public Post findWithWriteLockById(@PathVariable Long id) {
        return postService.findWithWriteLockById(id).orElse(null);
    }

}
