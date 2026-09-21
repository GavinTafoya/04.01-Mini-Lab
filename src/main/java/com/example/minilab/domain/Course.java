
package com.example.minilab.domain;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.LocalDateTime;

@Getter
@Setter
public class Course {
    private Integer id;

    @JsonProperty("name")
    @JsonAlias("originalName")
    private String name;

    @JsonProperty("course_code")
    @JsonAlias("courseCode")
    private String code;

    @JsonProperty("start_at")
    private LocalDateTime startDate;

        @JsonProperty("end_at")
    private LocalDateTime endDate;
    
    private Term term;
    
    private CalendarLink calendar;

    private CourseProgress courseProgress;
}


