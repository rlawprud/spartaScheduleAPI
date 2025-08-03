package com.example.spartascheduleapi.service;

import com.example.spartascheduleapi.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    public final ScheduleRepository scheduleRepository;
}
