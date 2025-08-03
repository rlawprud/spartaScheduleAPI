package com.example.spartascheduleapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 수정을 위해 사용되는 dto입니다.
@Getter
// null 값이 들어와도 되게끔, @NoArgsConstructor를 사용합니다.
@NoArgsConstructor
public class SchedulePatchDto {

    // 수정이 가능한 작성자, 일정 제목과 함께
    // 일정 수정을 위한 인증수단, 암호가 필요합니다.
    private String writer;

    private String title;

    private String password;

}
