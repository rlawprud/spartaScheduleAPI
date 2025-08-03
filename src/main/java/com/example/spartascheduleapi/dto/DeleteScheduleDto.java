package com.example.spartascheduleapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeleteScheduleDto {

    // 비밀번호만을 위해 만들어진 dto입니다.
    private String password;

}
