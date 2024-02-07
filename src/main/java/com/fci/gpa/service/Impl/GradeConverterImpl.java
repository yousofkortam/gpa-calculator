package com.fci.gpa.service.Impl;

import com.fci.gpa.service.GradeConverter;
import org.springframework.stereotype.Service;

@Service
public class GradeConverterImpl implements GradeConverter {
    @Override
    public String getGrade(double gpa) {
        if (gpa < 2) return "F";
        if (gpa < 2.2) return "D";
        if (gpa < 2.4) return "D+";
        if (gpa < 2.7) return "C";
        if (gpa < 3) return "C+";
        if (gpa < 3.3) return "B";
        if (gpa < 3.7) return "B+";
        if (gpa < 4) return "A";
        return "A+";
    }
}
