package com.ll.chat2412.chat;

import com.ll.chat2412.chat.dto.MessageResponse;
import com.ll.chat2412.chat.dto.MessagesRequest;
import com.ll.chat2412.chat.dto.WriteMessageRequest;
import com.ll.chat2412.chat.dto.WriteMessageResponse;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessages = new ArrayList<>();

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<WriteMessageResponse> writeMessage(@RequestBody WriteMessageRequest writeMessageRequest) {

        ChatMessage cm = new ChatMessage(writeMessageRequest.getAuthorName(), writeMessageRequest.getContent());
        chatMessages.add(cm);

        return new RsData<>("200", "메세지가 작성되었습니다.", new WriteMessageResponse(cm));
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<MessageResponse> messages(MessagesRequest messagesRequest) {
        List<ChatMessage> messages = chatMessages;
        List<ChatMessage> result = new ArrayList<>();
        int index = -1;

        // stream을 사용하면
        // 계층형으로 코드를 작성할 수 있다.
        // 데이터가 오염될 가능성이 적다.
        if(messagesRequest.fromId() != null){
            // 해당 번호의 채팅메세지가 전체 리스트에서의 배열 인덱스 번호를 구한다.
            // 없다면 -1
            index = IntStream.range(0, messages.size()).filter(i -> messages.get(i).getId() == messagesRequest.fromId()).findFirst().orElse(-1);

            // 만약에 index가 있다면, 0번부터 index번 까지 제거한 리스트를 만든다.
            result = messages.subList(index+1, messages.size());
        } else {
            result = messages;
        }
        return new RsData<>("200", "메세지가 조회되었습니다.", new MessageResponse(result, chatMessages.size()));
    }
}
