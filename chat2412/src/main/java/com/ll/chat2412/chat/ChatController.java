package com.ll.chat2412.chat;

import com.ll.chat2412.chat.dto.MessageResponse;
import com.ll.chat2412.chat.dto.WriteMessageRequest;
import com.ll.chat2412.chat.dto.WriteMessageResponse;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessages = new ArrayList<>();

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<WriteMessageResponse> writeMessage(@RequestBody WriteMessageRequest writeMessageRequest) {

        ChatMessage cm = new ChatMessage(writeMessageRequest.getAuthorName(), writeMessageRequest.getContent());
        chatMessages.add(cm);

        return new RsData<>("200", "메세지가 작성되었습니다.", new WriteMessageResponse(chatMessages));
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<MessageResponse> messages() {
        return new RsData<>("200", "메세지가 조회되었습니다.", new MessageResponse(chatMessages));
    }
}
