package com.example.scheduledevelop.controller;


import com.example.scheduledevelop.dto.RequestDto;
import com.example.scheduledevelop.dto.ResponseDto;
import com.example.scheduledevelop.service.ScheduleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    private final ScheduleServiceImpl scheduleService;

    public ScheduleController(ScheduleServiceImpl scheduleService) {this.scheduleService = scheduleService;}

    @PostMapping("/api/schedules")
    public ResponseEntity<Void> save(@RequestBody RequestDto request) {
        scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/api/schedules")
    public List<ResponseDto> getAll() {
        return scheduleService.getAll();
    }

    @GetMapping("/api/schedules/{id}")
    public ResponseDto getById(
            @PathVariable Long id
    ) {
        ResponseDto responseDto = scheduleService.getById(id);
        return responseDto;
    }

    @PutMapping("api/schedules/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        scheduleService.update(id, requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("api/schedules/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scheduleService.delete(id);
        return ResponseEntity.noContent().build();
    }


}



