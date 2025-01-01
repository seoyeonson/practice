package com.ll.chat2412.chat;

import com.ll.chat2412.chat.dto.MessageResponse;
import com.ll.chat2412.chat.dto.MessagesRequest;
import com.ll.chat2412.chat.dto.WriteMessageRequest;
import com.ll.chat2412.chat.dto.WriteMessageResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessages = new ArrayList<>();
    private final SseEmitters sseEmitters;

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<WriteMessageResponse> writeMessage(@RequestBody WriteMessageRequest writeMessageRequest) {

        ChatMessage cm = new ChatMessage(writeMessageRequest.getAuthorName(), writeMessageRequest.getContent());
        chatMessages.add(cm);

        sseEmitters.noti("chat__messageAdded");

        return new RsData<>("200", "메세지가 작성되었습니다.", new WriteMessageResponse(cm));
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<MessageResponse> messages(MessagesRequest messagesRequest) {
        List<ChatMessage> messages = chatMessages;

        // stream을 사용하면
        // 계층형으로 코드를 작성할 수 있다.
        // 데이터가 오염될 가능성이 적다.
        if(messagesRequest.fromId() != null){
            // 해당 번호의 채팅메세지가 전체 리스트에서의 배열 인덱스 번호를 구한다.
            // 없다면 -1
            int index = IntStream.range(0, messages.size())
                    .filter(i -> chatMessages.get(i).getId() == messagesRequest.fromId())
                    .findFirst()
                    .orElse(-1);


            // index이후의 채팅메세지들만 리스트로 가져온다.
            if(index != -1){
                messages = messages.subList(index+1, messages.size());
            }
        }

        return new RsData<>("200", "메세지가 조회 성공", new MessageResponse(messages, chatMessages.size()));
    }

    @GetMapping("room")
    public String room(){
        return "chat/room";
    }
}
