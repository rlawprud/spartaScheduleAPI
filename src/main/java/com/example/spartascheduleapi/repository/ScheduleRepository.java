package com.example.spartascheduleapi.repository;

import com.example.spartascheduleapi.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

// todo = 레포지토리입니다. DB와 연결되는 부분
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
