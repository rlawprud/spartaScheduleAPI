package com.example.spartascheduleapi.controller;

import com.example.spartascheduleapi.dto.SchedulePatchDto;
import com.example.spartascheduleapi.dto.ScheduleRequestDto;
import com.example.spartascheduleapi.dto.ScheduleResponseDto;
import com.example.spartascheduleapi.entity.Schedule;
import com.example.spartascheduleapi.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO("컨트롤러 부분입니다. 즉, 보여지는 부분 요청을 받고 응답하는 부분")
@RestController
public class ScheduleController {

    // Service와 연결해줍니다.
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 특정 일정만 열람하는 메서드입니다.
    // 읽어들인 값을 id 라고 부르고, 이 id(Long)를 기준으로 일정을 불러옵니다.
        @GetMapping("/schedule/{scheduleId}")
    public ScheduleResponseDto getSchedule(@PathVariable Long scheduleId) {
        return scheduleService.getSchedule(scheduleId);
    }

    // "/schedule" 요청이 들어왔을 때 실행하는 구문입니다. 전체 조회를 실행합니다.
    @GetMapping("/schedule")
    public List<ScheduleResponseDto> getAllSchedule() {
        return scheduleService.getAllSchedule();
    }

    // "/schedule/post" 요청이 들어왔을 때 실행하는 구문입니다.
    // 입력한 데이터를 dto로 만들어 서비스로 넘겨줍니다.
    @PostMapping("/schedule/post")
    public void insertSchedule(@RequestBody ScheduleRequestDto dto) {
        scheduleService.insertSchedule(dto);
    }

    // "/schedule/patch/{id}" 요청이 들어왔을 때 실행하는 구문입니다.
    // ...patch/ 뒤에 오는 값을 Long 값으로 받아들입니다.
    // 또한, 입력된 값을 dto에 저장하여 서비스로 넘겨줍니다.
    @PatchMapping("/schedule/patch/{id}")
    public void updateSchedule(@PathVariable Long id, @RequestBody SchedulePatchDto dto) {
        scheduleService.updateSchedule(id, dto);
    }

}
