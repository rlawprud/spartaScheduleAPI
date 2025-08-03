package com.example.spartascheduleapi.entity;

import com.example.spartascheduleapi.dto.SchedulePatchDto;
import com.example.spartascheduleapi.dto.ScheduleRequestDto;
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

    // 작성자
    private String writer;

    // 일정 제목
    private String title;

    // 일정 내용
    private String content;

    // 암호
    private String password;

    // 생성일
    private LocalDateTime createdAt;

    // 수정일
    private LocalDateTime modifiedAt;

    // 생성자 입니다.
    public Schedule(ScheduleRequestDto dto) {
        this.writer = dto.getWriter();
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.password = dto.getPassword();
    }

    // 생성되었을 때 생성일/수정일을 초기화하는 구문입니다.
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    // 수정되었을 때 수정일을 초기화하는 구문입니다.
    @PreUpdate
    public void onUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }

    // 업데이트하는 메서드입니다.
    // null 값이 포함될 수 있기 때문에, if 를 사용하여 값을 분류하고 적용합니다.
    public void update(SchedulePatchDto dto) {

        // 수정을 위해 입력된 일정 제목이 null 값이 아닐 경우 이 객체의 title 을 입력된 제목으로 수정합니다.
        if (dto.getTitle() != null) {
            this.title = dto.getTitle();
        }

        // 수정을 위해 입력된 작성자가 null 값이 아닐 경우 이 객체의 작성자를 입력된 값으로 수정합니다.
        if (dto.getWriter() != null) {
            this.writer = dto.getWriter();
        }
        // @PreUpdate 가 있기 때문에, 업데이트 날짜는 수정하지 않아도 됩니다.
    }
}
