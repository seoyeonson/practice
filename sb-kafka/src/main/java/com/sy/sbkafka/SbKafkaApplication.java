package com.sy.sbkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync // 비동기 실행 활성화
public class SbKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbKafkaApplication.class, args);
    }

}
