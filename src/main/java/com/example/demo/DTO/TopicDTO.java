package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TopicDTO {
    private long id;
    @NotBlank
    private String theme;
    @NotBlank
    @Length(max = 300)
    private String problem;
}
