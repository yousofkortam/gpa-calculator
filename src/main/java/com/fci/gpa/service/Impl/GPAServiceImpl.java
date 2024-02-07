package com.fci.gpa.service.Impl;

import com.fci.gpa.exception.GPAException;
import com.fci.gpa.model.CourseGrade;
import com.fci.gpa.model.CumulativeGPA;
import com.fci.gpa.service.GPAService;
import com.fci.gpa.service.GradeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GPAServiceImpl implements GPAService {

    private final GradeConverter gradeConverter;
    @Override
    public double calcGPA(List<CourseGrade> coursesGrades) {
        if (coursesGrades == null || coursesGrades.isEmpty()) {
            throw new GPAException("No grades found", HttpStatus.BAD_REQUEST);
        }
        double sumPoints = 0; int sumHours = 0;
        for (CourseGrade course : coursesGrades) {
            double point = getPoint(course.getGrade());
            sumPoints += (point * course.getCreditHours());
            sumHours += course.getCreditHours();
        }
        return Math.round((sumPoints / sumHours) * 100.0) / 100.0;
    }

    @Override
    public double calcCGPA(List<CumulativeGPA> SemestersGPA) {
        if (SemestersGPA == null || SemestersGPA.isEmpty()){
            throw new GPAException("No GPAs found", HttpStatus.BAD_REQUEST);
        }
        double gpaGradePoints = 0; int sumHours = 0;
        for (CumulativeGPA semester : SemestersGPA) {
            gpaGradePoints += ( semester.getSemesterGPA() * semester.getSemesterCreditHours() );
            sumHours += semester.getSemesterCreditHours();
        }
        return Math.round((gpaGradePoints / sumHours) * 100.0) / 100.0;
    }

    @Override
    public String convertGPA(double gpa) {
        return gradeConverter.getGrade(gpa);
    }

    public double getPoint(int grade) {
        if (grade < 50) {
            return 0;
        }else if (grade < 60) {
            return 2;
        }else if (grade < 65) {
            return 2.2;
        }else if (grade < 70) {
            return 2.4;
        }else if (grade < 75) {
            return 2.7;
        }else if (grade < 80) {
            return 3;
        }else if (grade < 85) {
            return 3.3;
        }else if (grade < 90) {
            return 3.7;
        }
        return 4;
    }
}
