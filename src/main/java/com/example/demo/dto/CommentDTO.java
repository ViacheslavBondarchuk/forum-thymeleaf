package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CommentDTO {
    private long id;
    @NotBlank
    @Length(max = 300)
    private String text;
}
