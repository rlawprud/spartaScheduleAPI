package com.example.spartascheduleapi.repository;

import com.example.spartascheduleapi.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
