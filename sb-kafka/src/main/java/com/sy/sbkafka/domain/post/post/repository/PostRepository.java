package com.sy.sbkafka.domain.post.post.repository;

import com.sy.sbkafka.domain.post.post.entitiy.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
