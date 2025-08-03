package com.example.spartascheduleapi.dto;

import com.example.spartascheduleapi.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

// 반환을 위한 객체입니다.
@Getter
public class ScheduleResponseDto {

    // 객체는 일정 ID, 일정 이름, 일정 내용, 작성자, 생성/수정일의 필드를 가집니다.
    // 비밀번호는 반환하지 않습니다. (필터링)
    private final Long scheduleId;

    private final String title;

    private final String content;

    private final String writer;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    // 반환을 위한 객체이므로, 실제 Schedule 을 받아서 필터링합니다.
    // 역시, 비밀번호는 들어가지 않습니다.
    public ScheduleResponseDto(Schedule schedule) {

        // 일정 ID
        this.scheduleId = schedule.getScheduleId();

        // 일정 제목
        this.title = schedule.getTitle();

        // 일정 내용
        this.content = schedule.getContent();

        // 작성자
        this.writer = schedule.getWriter();

        // 생성일, 수정일
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
