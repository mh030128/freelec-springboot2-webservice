package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void functionTestLombok() {

        // given
        String name = "test01";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        /*
    assertThat
     - assertj라는 테스트 검증 라이브러리의 검증 메서드.
     - 검증하고 싶은 대상을 메서드 인자로 받음.
     - 메서드 체이닝이 지원되어 isEqualTo와 같이 메서드를 이어서 사용 가능.

    isEqualTo
     - assertj의 동등 비교 메서드.
     - assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공.
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
