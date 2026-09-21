
package com.example.minilab.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CourseProgress {
    private Integer requirementCount;
    private Integer completedCount;
    private String nextRequirementUrl;
    private LocalDateTime completedAt;
}

