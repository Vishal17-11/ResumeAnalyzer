package com.proj.ResumeAnalyzer;



import org.springframework.web.multipart.MultipartFile;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepo resumeRepo;

    public Resume savAnalyzeResume(MultipartFile file, String jobDescription) throws Exception {

    String resumeTxt = new Tika().parseToString(file.getInputStream());

    int score = JDmatcher.calculteScore(jobDescription, resumeTxt);

    Resume resume = new Resume();
    resume.setFilename(file.getOriginalFilename());
    resume.setScore(score);
    resume.setJobDescription(jobDescription);
    return resumeRepo.save(resume);








    }
    public List<Resume> getALL(){
        return resumeRepo.findAll();
    }
}
