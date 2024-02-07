package com.fci.gpa.model;

import lombok.Data;

import java.util.List;

@Data
public class CGPARequest {
    List<CumulativeGPA> semestersGPA;
}
