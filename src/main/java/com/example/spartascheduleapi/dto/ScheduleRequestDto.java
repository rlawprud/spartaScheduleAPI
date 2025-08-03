package com.example.spartascheduleapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleRequestDto {
    private String writer;
    private String password;
    private String title;
    private String content;
}
