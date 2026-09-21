package com.example.minilab.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class RubricCriteria {
    private Integer id;
    private Long points;
    private String description;
    private List<RubricRating> ratings;
}

