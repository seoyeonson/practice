package com.practice.board.domain.user.service;

import com.practice.board.domain.user.entity.SiteUser;
import com.practice.board.domain.user.repository.UserRepository;
import com.practice.board.global.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password) {
        // 유저 비밀번호를 보안을 위한 암호화
        // 하지만 객체를 직접 생성하는 방식보다는
        // BCryptPasswordEncoder를 bean으로 등록하여 사용하는게 좋다.
        // 암호화 방식을 변경하면 BCryptPasswordEncoder를 사용한 모든 프로그램을 일일이 찾아다니며 수정해야 하기 때문
        // SecurityConfig.java에 빈으로 추가하여 관리
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        SiteUser user = SiteUser.builder()
                    .username(username)
                    .email(email)
                    .password(passwordEncoder.encode(password)
                ).build();

        userRepository.save(user);
        return user;
    }
    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = userRepository.findByUsername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
}
