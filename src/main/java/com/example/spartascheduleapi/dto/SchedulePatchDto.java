package com.example.spartascheduleapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SchedulePatchDto {
    private String writer;
    private String title;
    private String content;
    private String password;
}
