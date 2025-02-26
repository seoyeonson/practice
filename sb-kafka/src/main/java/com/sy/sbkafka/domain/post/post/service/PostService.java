package com.sy.sbkafka.domain.post.post.service;

import com.sy.sbkafka.domain.member.member.entity.Member;
import com.sy.sbkafka.domain.post.author.entity.Author;
import com.sy.sbkafka.domain.post.post.entitiy.Post;
import com.sy.sbkafka.domain.post.post.repository.PostRepository;
import com.sy.sbkafka.global.dto.chat.ChatMessageDto;
import com.sy.sbkafka.global.event.PostCreatedEvent;
import com.sy.sbkafka.global.rsData.RsData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationEventPublisher eventPublisher;
    private final KafkaTemplate<Object, Object> kafkaTemplate;

    @Transactional
    public RsData<Post> write(Author author, String title, String content) {
        author.increasePostsCount();

        Post post = postRepository.save(
                Post.builder()
                        .author(author)
                        .title(title)
                        .content(content)
                        .build()
        );

        eventPublisher.publishEvent(new PostCreatedEvent(this, post));
        kafkaTemplate.send("chat-room-1", new ChatMessageDto(post.getId() + "번 글이 생성되었습니다."));

        return RsData.of(post);
    }

    public Author of(Member member) {
        // getReference()
        // Author 엔티티를 즉시 조회하지 않고 프록시 객체를 반환하여 성능을 최적화
        // 실제로 Author의 필드를 접근할 때만 DB 조회가 발생 (지연 로딩)
        // 불필요한 데이터베이스 쿼리를 방지하고, Author의 ID만 필요한 경우 더 효율적으로 사용할 수 있음
        return entityManager.getReference(Author.class, member.getId()); // Lazy Loading
    }

    public Member of(Author author) {
        return entityManager.getReference(Member.class, author.getId());
    }
}
