package com.ll.jpa2501.domain.post;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUsername(String username);

    // LockModeType.PESSIMISTIC_READ : 다른 트랜잭션에서 해당 데이터를 읽을 수 없다.
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Post> findWithShareLockById(Long id);

    // LockModeType.PESSIMISTIC_WRITE : 다른 트랜잭션에서 해당 데이터를 읽거나 쓸 수 없다.
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Post> findWithWriteLockById(Long id);
}
