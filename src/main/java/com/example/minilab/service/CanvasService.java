package com.example.minilab.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.example.minilab.domain.Course;
import com.example.minilab.domain.Assignment;

@Service
public class CanvasService {
    private final WebClient canvasWebClient;

    public CanvasService(WebClient canvasWebClient) {
        this.canvasWebClient = canvasWebClient;
    }

        public Course getCourse(Integer courseId) {
        return canvasWebClient.get()
            .uri("/courses/" + courseId)
            .retrieve()
            .bodyToMono(Course.class)
            .block();
    }


    public List<Course> getCourses() {
        return canvasWebClient.get()
            .uri("/users/self/courses?enrollment_state=active&include[]=term")
            .retrieve()
            .bodyToFlux(Course.class)
            .filter(c -> c.getName() != null && !c.getName().equalsIgnoreCase("null"))
            .filter(c -> c.getEndDate() == null || c.getEndDate().isAfter(java.time.LocalDateTime.now()))
            .collectList()
            .block();
    }

        public List<Assignment> getAssignments(Integer courseId) {
        return canvasWebClient.get()
            .uri("/courses/" + courseId + "/assignments")
            .retrieve()
            .bodyToFlux(Assignment.class)
            .onErrorResume(e -> reactor.core.publisher.Flux.empty())
            .collectList()
            .block();
    }

    public Assignment getAssignment(Integer courseId) {
        return getAssignments(courseId).stream().findFirst().orElse(null);
    }

}
