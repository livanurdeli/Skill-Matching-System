package com.demo.skillmatch.controller;

import com.demo.skillmatch.model.JobPosting;
import com.demo.skillmatch.model.User;
import com.demo.skillmatch.service.JobPostingService;
import com.demo.skillmatch.service.MatchingService;
import com.demo.skillmatch.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final JobPostingService jobPostingService;
    private final MatchingService matchingService;
    private final UserService userService;

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        User sessionUser = (User) session.getAttribute("loggedUser");
        if (sessionUser == null) return "redirect:/login";

        User loggedUser = userService.findByIdOrNull(sessionUser.getId());
        if (loggedUser == null) return "redirect:/login";

        List<JobPosting> jobs = jobPostingService.findAll();

        Map<JobPosting, Double> jobMatchMap = new LinkedHashMap<>();
        for (JobPosting job : jobs) {
            double score = matchingService.calculateMatch(loggedUser, job);
            jobMatchMap.put(job, score);
        }

        model.addAttribute("user", loggedUser);
        model.addAttribute("jobMatchMap", jobMatchMap);

        return "home";
    }
}