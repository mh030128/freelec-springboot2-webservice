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
            // 임시로 추가:
            */
/*System.out.println("DEBUG: /profile request received and processing...");
            return "SUCCESS: Profile API response!"; // 임시로 간단한 문자열 반환*//*

        }
    }
*/

package com.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity; // ResponseEntity 임포트 추가
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final Environment env;

    @GetMapping("/profile")
    public ResponseEntity<String> profile() { // 반환 타입을 ResponseEntity<String>으로 변경
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty()? "default" : profiles.get(0);

        // System.out.println 대신 Logger 사용 (권장)
        // private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
        // logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        // logger.info("active profiles: " + Arrays.toString(env.getActiveProfiles()));

        String resultProfile = profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);

        // 응답 상태 코드와 함께 명시적으로 반환
        return ResponseEntity.ok(resultProfile); // HTTP 200 OK와 함께 결과 문자열 반환
    }
}