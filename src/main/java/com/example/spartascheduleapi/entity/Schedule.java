package com.example.spartascheduleapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    //일정의 ID 입니다. 자동적으로 생성-> 할당 되며, 해당 테이블의 기본 키입니다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String writer;
    private String title;
    private String content;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
