package com.demo.skillmatch.service;
import com.demo.skillmatch.model.JobPosting;
import com.demo.skillmatch.repository.JobPostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;

    public List<JobPosting> findAll() {
        return jobPostingRepository.findAll();
    }

    public JobPosting save(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }}