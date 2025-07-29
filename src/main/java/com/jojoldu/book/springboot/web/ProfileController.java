/*
package com.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty()? "default" : profiles.get(0);


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("active profiles: " + Arrays.toString(env.getActiveProfiles()));

        return profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);

    }
}
*/
package com.jojoldu.book.springboot.web;

import org.springframework.http.ResponseEntity;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProfileController {
    private final Environment env;
    public ProfileController(Environment env) {
        this.env = env;
    }

    @GetMapping("/profile")
    public ResponseEntity<String> profile() { // 반환 타입을 ResponseEntity<String>으로 변경
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty()? "default" : profiles.get(0);

        // 이 부분이 실행되면 로그에 찍히도록 System.out.println 추가 (임시)
        System.out.println("DEBUG: ProfileController.profile() method called!");
        System.out.println("DEBUG: Active profiles: " + Arrays.toString(env.getActiveProfiles()));


        String resultProfile = profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);

        return ResponseEntity.ok(resultProfile); // HTTP 200 OK와 함께 결과 문자열 반환
    }
}