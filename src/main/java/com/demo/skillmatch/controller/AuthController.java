package com.demo.skillmatch.controller;
import com.demo.skillmatch.model.Skill;
import com.demo.skillmatch.model.User;
import com.demo.skillmatch.service.SkillService;
import com.demo.skillmatch.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final SkillService skillService;

    // Login sayfası
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Login işlemi
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        return userService.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .map(u -> {
                    session.setAttribute("loggedUser", u);
                    return "redirect:/home";
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Email veya şifre hatalı!");
                    return "login";
                });
    }

    // Register sayfası
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("skills", skillService.findAll());
        return "register";
    }

    // Register işlemi
    @PostMapping("/register")
    public String register(@ModelAttribute User user,
                           @RequestParam List<Long> skillIds,
                           Model model) {

        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Bu email zaten kayıtlı!");
            model.addAttribute("skills", skillService.findAll());
            return "register";
        }

        List<Skill> selectedSkills = skillIds.stream()
                .map(id -> skillService.findAll().stream()
                        .filter(s -> s.getId().equals(id))
                        .findFirst().orElseThrow())
                .toList();

        user.setSkills(selectedSkills);
        userService.save(user);

        return "redirect:/login";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
