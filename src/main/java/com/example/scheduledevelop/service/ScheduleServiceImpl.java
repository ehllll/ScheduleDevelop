package com.example.scheduledevelop.service;



import com.example.scheduledevelop.dto.RequestDto;
import com.example.scheduledevelop.dto.ResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.repository.ScheduleJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleJpaRepository scheduleJpaRepository;

    public ScheduleServiceImpl(ScheduleJpaRepository repository){
        this.scheduleJpaRepository = repository;
    }

    @Override
    public void save(RequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);
        scheduleJpaRepository.save(schedule);
    }

    @Override
    public List<ResponseDto> getAll() {
        List<ResponseDto> responseDtoList = new ArrayList<>();

        List<Schedule> scheduleList = scheduleJpaRepository.findAll();
        for(Schedule schedule : scheduleList) {
            ResponseDto responseDto = new ResponseDto(schedule);
            responseDtoList.add(responseDto);
        }
        return responseDtoList;
    }

    @Override
    public ResponseDto getById(Long id) {
        Schedule schedule = scheduleJpaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Schedule")
        );

        ResponseDto responseDto = new ResponseDto(schedule);
        return  responseDto;
    }

    @Override
    public void update(Long id, RequestDto requestDto) {
        Schedule schedule = scheduleJpaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Schedule")
        );
        schedule.update(requestDto);
        scheduleJpaRepository.save(schedule);
    }

    @Override
    public void delete(Long id) {
        Schedule schedule = scheduleJpaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Schedule")
        );
        scheduleJpaRepository.delete(schedule);
    }
}



