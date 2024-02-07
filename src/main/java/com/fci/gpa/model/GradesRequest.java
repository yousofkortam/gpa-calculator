package com.fci.gpa.model;

import lombok.Data;

import java.util.List;

@Data
public class GradesRequest {
    List<CourseGrade> coursesGrade;
}