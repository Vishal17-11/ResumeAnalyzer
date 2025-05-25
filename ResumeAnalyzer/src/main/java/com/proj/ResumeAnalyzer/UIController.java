package com.proj.ResumeAnalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/resumes")
public class UIController{

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/")
    private String showUploadPage(){
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadResume(
            @RequestParam("file") MultipartFile file,
            @RequestParam("jobDescription") String jobDescription,
            Model model) throws Exception {

        Resume resume = resumeService.savAnalyzeResume(file, jobDescription);

        model.addAttribute("score", resume.getScore());
        return "match-score";
    }
}
