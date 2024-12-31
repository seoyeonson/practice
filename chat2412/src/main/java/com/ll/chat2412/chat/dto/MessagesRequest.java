package com.ll.chat2412.chat.dto;

public record MessagesRequest (Long fromId) {
    // long 과 Long 사용의 차이
    // Long 을 사용할 경우 null 을 허용할 수 있다.
}
