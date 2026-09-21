
package com.example.minilab.domain;

import java.util.List;
import java.time.LocalDateTime;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
public class Assignment {
    
    private Integer id;

    private String name;

    private String description;

    @JsonProperty("due_at")
    private LocalDateTime dueDate;

    @JsonProperty("lock_at")
    private LocalDateTime lockDate;

        @JsonProperty("points_possible")
    private Long pointsPossible;

    
        @JsonProperty("course_id")
    private Integer courseId;


        @JsonProperty("html_url")
    private String htmlUrl;


    private List<RubricCriteria> rubric;
}