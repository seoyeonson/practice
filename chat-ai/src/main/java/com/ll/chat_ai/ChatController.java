package com.ll.chat_ai;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aiChat")
public class ChatController {
//    private final OpenAiChatModel openAiChatModel;
//
//    public ChatController(OpenAiChatModel openAiChatModel) {
//        this.openAiChatModel = openAiChatModel;
//    }
//
//    @GetMapping("/ai")
//    public Map<String, String> chat(@RequestBody String message) {
//        Map<String, String> responses = new HashMap<>();
//        String openAiResponse = openAiChatModel.call(message);
//        responses.put("openAI - ChatGPT 3.5 응답", openAiResponse);
//
//        return responses;
//    }
}
