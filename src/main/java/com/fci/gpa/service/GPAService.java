package com.fci.gpa.service;

import com.fci.gpa.model.CourseGrade;
import com.fci.gpa.model.CumulativeGPA;

import java.util.List;

public interface GPAService {
    double calcGPA(List<CourseGrade> grades);
    double calcCGPA(List<CumulativeGPA> GPAs);
    String convertGPA(double gpa);
}
