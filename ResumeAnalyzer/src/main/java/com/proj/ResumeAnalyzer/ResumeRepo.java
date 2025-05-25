package com.proj.ResumeAnalyzer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResumeRepo  extends JpaRepository<Resume, UUID> {


}
