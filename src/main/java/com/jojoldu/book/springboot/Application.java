// 앞으로 만들 프로젝트의 메인클래스가 됨.

package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @SpringBootApplicaion으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정 가능.
// @SpringBootApplicaion이 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치해야 함.
// @EnableJpaAuditing  // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*
        SpringApplication.run으로 인해 내장 WAS(Web Application Server)를 실행
         */
        SpringApplication.run(Application.class, args);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>시작");
    }
}
