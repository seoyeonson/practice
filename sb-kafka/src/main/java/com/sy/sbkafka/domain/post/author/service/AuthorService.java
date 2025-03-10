package com.sy.sbkafka.domain.post.author.service;

import com.sy.sbkafka.domain.post.author.entity.Author;
import com.sy.sbkafka.domain.post.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Optional<Author> findById(long id) {
        return authorRepository.findById(id);
    }
}
