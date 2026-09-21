package com.example.minilab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.example.minilab.domain.Course;
import com.example.minilab.domain.Assignment;
import com.example.minilab.service.CanvasService;

@Controller
public class HomeController {

    @Autowired
    private CanvasService canvasService;


        @GetMapping("/")
    public String home(@RequestParam(value = "term", required = false) String termName, Model model) {
        model.addAttribute("message", "Welcome to Gavin's Canvas");
        model.addAttribute("serverTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        model.addAttribute("framework", "Spring Boot with Thymeleaf");

        List<Course> allCourses = canvasService.getCourses();
        
        // Extract unique terms for the dropdown
        List<String> terms = allCourses.stream()
            .map(c -> c.getTerm() != null ? c.getTerm().getName() : "No Term")
            .distinct()
            .sorted()
            .toList();
        
        // Filter courses by selected term if one is provided
        List<Course> filteredCourses = allCourses;
        if (termName != null && !termName.isEmpty()) {
            filteredCourses = allCourses.stream()
                .filter(c -> c.getTerm() != null && c.getTerm().getName().equals(termName))
                .toList();
        }

        List<Assignment> assignments = new ArrayList<>();
        for (Course course : filteredCourses) {
            if (course.getName() != null) {
                assignments.addAll(canvasService.getAssignments(course.getId()));
            }
        }
        
        model.addAttribute("terms", terms);
        model.addAttribute("selectedTerm", termName);
        model.addAttribute("courses", filteredCourses);
        model.addAttribute("assignments", assignments);
        
        return "home";
    }


        @GetMapping("/assignments/{courseId}")
    public String getAssignment(@PathVariable("courseId") Integer courseId, Model model) {
        Course course = canvasService.getCourse(courseId);
        model.addAttribute("course", course);
        model.addAttribute("assignment", canvasService.getAssignment(courseId));
        return "assignment";
    }

}

