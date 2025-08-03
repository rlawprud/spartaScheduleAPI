package com.example.spartascheduleapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 새로운 일정 생성을 위해 사용되는 dto입니다.
@Getter
@RequiredArgsConstructor
public class ScheduleRequestDto {

    // id는 자동으로 생성되고, 생성일/수정일 또한 자동으로 초기화됩니다.
    // 따라서 입력이 필요한 필드는 이 넷입니다.
    private String writer;      // 작성자

    private String password;    // 암호

    private String title;       // 일정 제목

    private String content;     // 일정 내용

}
