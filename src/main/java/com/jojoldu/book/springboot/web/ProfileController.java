package com.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final Environment env;

    /*@GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty()? "default" : profiles.get(0);


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("active profiles: " + Arrays.toString(env.getActiveProfiles()));

        return profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);*/
    @GetMapping("/") // <--- 이 부분을 "/" 로 변경합니다!
    public ResponseEntity<String> profile() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); // System.out.println 대신 log.info 사용
        log.info("DEBUG: Root / request received! From ProfileController.");
        log.info("active profiles: " + Arrays.toString(env.getActiveProfiles()));
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);

        String resultProfile = profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);

        return ResponseEntity.ok("SUCCESS: Root profile is " + resultProfile); // 반환 메시지도 변경

    }
}
