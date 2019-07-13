package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class DiscussionDTO {
    private long id;
    @NotBlank(message = "Cannot be empty")
    private String theme;
    @NotBlank(message = "Cannot be empty")
    @Length(min = 10, max = 300, message = "The number of characters must be from 10 to 300")
    private String description;
}
