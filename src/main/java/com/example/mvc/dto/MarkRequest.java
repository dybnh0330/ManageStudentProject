package com.example.mvc.dto;

import lombok.Data;

@Data
public class MarkRequest {

    private double mark;
    private Long studentID;
    private Long subjectID;
}
