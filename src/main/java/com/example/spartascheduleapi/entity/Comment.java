package com.example.spartascheduleapi.entity;

import java.time.LocalDateTime;

public class Comment {

    private Long commentId;
    private Schedule schedule;
    private String writer;
    private String content;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
