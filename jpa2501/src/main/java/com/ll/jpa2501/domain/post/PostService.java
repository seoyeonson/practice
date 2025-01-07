package com.ll.jpa2501.domain.post;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Post not found"));
    }

    @Transactional
    public List<Post> findByUsername(String username) {
        // jpa에서 제공되는 메소드는
        // autocommit이 되어있는 상태에서 실행된다.

        // findByUsername같이 생성한 메소드는
        //autocommit이 되어있는 상태에서 실행되지 않는다.

        // 이런 경우에는 ServiceController에 @Transactional을 붙여주면
        // 함께 autocommit이 되어있는 상태에서 실행된다.

//        postRepository.findById(1L);
//        postRepository.findByUsername(username);
        return postRepository.findByUsername(username);
    }

    @SneakyThrows
    public Optional<Post> findWithShareLockById(Long id) {
        postRepository.findWithShareLockById(id);
        Thread.sleep(10000);
        return postRepository.findWithShareLockById(id);
    }

    public Post create(String subject, String content, String username) {
        return postRepository.save(Post.builder()
                .subject(subject)
                .content(content)
                .username(username)
                .build());
    }

    public Optional<Post> findWithWriteLockById(Long id) {
        return postRepository.findWithWriteLockById(id);
    }
}
