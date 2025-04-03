package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ResponseDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdQAt;
    private LocalDateTime modifiedAt;

    public ResponseDto(Schedule schedule) {
        this(schedule.getId(), schedule.getTitle(), schedule.getWriter(), schedule.getContent());
    }

    public ResponseDto(Long id, String title, String writer, String content){
        this.id =id;
        this.title=title;
        this.writer=writer;
        this.content=content;
        this.createdQAt=getCreatedQAt();
        this.modifiedAt=getModifiedAt();
    }
}
