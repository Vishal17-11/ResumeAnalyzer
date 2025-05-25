package com.proj.ResumeAnalyzer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/getresume")
    public ResponseEntity<List<Resume>>  getAllResume (){

      return ResponseEntity.ok(resumeService.getALL());
    }
    @GetMapping("/test")
    public String test() {
        return "Backend is working!";

    }



}
