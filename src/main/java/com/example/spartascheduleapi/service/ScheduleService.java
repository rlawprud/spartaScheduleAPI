package com.example.spartascheduleapi.service;

import com.example.spartascheduleapi.dto.SchedulePatchDto;
import com.example.spartascheduleapi.dto.ScheduleRequestDto;
import com.example.spartascheduleapi.dto.ScheduleResponseDto;
import com.example.spartascheduleapi.entity.Schedule;
import com.example.spartascheduleapi.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// todo = 서비스 입니다. 작동하는 구문
@Service
public class ScheduleService {

    // 레포지트리와 연결해줍니다.
    public final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // id로 조회했을 때 결과를 불러오는 메서드입니다.
    // Long id 를 받아서 반환용 dto를 리턴합니다.
    public ScheduleResponseDto getSchedule(Long scheduleId) {
        // id로 값이 찾아지면 반환용 dto에 객체를 넣은 후 반환합니다.
        // 찾아지지 않을 경우 -> 예외를 던집니다. (Optional)
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정이 없습니다."));
        return new ScheduleResponseDto(schedule);
    }

    // 모든 일정을 리스트 형태로 반환하는 메서드입니다.
    public List<ScheduleResponseDto> getAllSchedule() {
        // schedules 라는 이름의 리스트는 Schedule 객체가 들어가는 리스트로,
        // 모든 객체가 들어갑니다.
        List<Schedule> schedules = scheduleRepository.findAll();
        // ! 이대로 반환할 시 -> 비밀번호가 노출되고 맘.
        // 따라서, List<dto> 형태로 반환할 겁니다.
        List<ScheduleResponseDto> dtoList = new ArrayList<>();
        // 향상된 for문 입니다!
        for (Schedule schedule : schedules) {
            dtoList.add(new ScheduleResponseDto(schedule));
        }
        return dtoList;
    }

    // 새로운 일정을 생성하는 메서드입니다.
    // 필요한 것들(작성자, 비밀번호, 일정 제목, 일정 내용)이 담긴 dto를 사용하여
    // 객체를 만들고, 레포지토리.save(자동 생성 메서드) 를 통해 저장합니다.
    // Repository.save 는 내부적으로 @Transactional을 가지고 있어, 굳이 사용하지 않았습니다.
    public void insertSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto);
        scheduleRepository.save(schedule);
    }

    // 일정을 업데이트하는 메서드입니다.
    @Transactional
    public void updateSchedule(Long scheduleId, SchedulePatchDto dto) {
        // 1. ID가 일치하는 객체 찾기
        // Id를 통해 일정을 찾고, 값이 없을 경우 예외를 던집니다. (Optional)
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정이 없습니다."));
        // 2. 암호가 일치하는지 확인하기
        // 만약에 Id로 찾은 객체의 비밀번호와 입력한 비밀번호가 일치하지 않는다면,
        // 예외를 던집니다.
        if (!schedule.getPassword().equals(dto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        // 3. 수정된 값 저장하기
        // 서비스에서 업데이트까지 관리하는 건 부적절하다고 판단하여
        // 객체에서 업데이트를 진행할 수 있도록 하였습니다.
        schedule.update(dto);
    }
}
