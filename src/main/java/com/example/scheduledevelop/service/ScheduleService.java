package com.example.scheduledevelop.service;


import com.example.scheduledevelop.dto.RequestDto;
import com.example.scheduledevelop.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    void save(RequestDto request);

    List<ResponseDto> getAll();
    ResponseDto getById(Long id);
    void update(Long id, RequestDto request);
    void delete(Long id);
}
