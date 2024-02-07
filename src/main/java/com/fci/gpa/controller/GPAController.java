package com.fci.gpa.controller;

import com.fci.gpa.model.CGPARequest;
import com.fci.gpa.model.Response;
import com.fci.gpa.model.GradesRequest;
import com.fci.gpa.service.GPAService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GPAController {

    private final GPAService service;

    @PostMapping("/calc-gpa")
    public ResponseEntity<?> calc(@RequestBody GradesRequest g) {
        double gpa = service.calcGPA(g.getCoursesGrade());
        return ResponseEntity.ok(new Response(HttpStatus.OK.value(), gpa, service.convertGPA(gpa)));
    }

    @PostMapping("/calc-cgpa")
    public ResponseEntity<?> calc(@RequestBody CGPARequest g) {
        double gpa = service.calcCGPA(g.getSemestersGPA());
        return ResponseEntity.ok(new Response(HttpStatus.OK.value(), gpa, service.convertGPA(gpa)));
    }

}
