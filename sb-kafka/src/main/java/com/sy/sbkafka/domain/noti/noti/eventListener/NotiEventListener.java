package com.sy.sbkafka.domain.noti.noti.eventListener;

import com.sy.sbkafka.domain.noti.noti.service.NotiService;
import com.sy.sbkafka.global.dto.chat.ChatMessageDto;
import com.sy.sbkafka.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
// @Transactional
// listenPost()는 @Async로 실행되므로 트랜잭션 적용이 원활하지 않을 가능성이 있음.
//notiService.postCreated() 해당 메서드 내부에서 @Transactional을 선언함.
public class NotiEventListener {
    private final NotiService notiService;

    @EventListener
    @Async
    // 메서드를 별도의 스레드에서 비동기적으로 실행하도록 만듦
    // 응답을 기다리지 않고 다른 작업을 수행할 수 있도록 함
    public void listenPost(PostCreatedEvent event){
        notiService.postCreated(event.getPost());
    }

    @KafkaListener(topics = "chat-room-1", groupId = "1")
    public void consume(ChatMessageDto message){
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "chat-room-1-dlt", groupId = "1")
    public void consumeChatRoom1DLT(byte[] in){
        String message = new String(in);
        System.out.println("Failed message: " + message);
    }
}
