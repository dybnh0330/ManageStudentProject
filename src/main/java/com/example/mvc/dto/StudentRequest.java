package com.example.mvc.dto;

import lombok.Data;

@Data
public class StudentRequest {
    private String studentName;
    private String Sex;
    private String birthDay;
    private Long classID;
}
