package com.example.demo.dto;

import com.example.demo.model.Discussion;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CommentDTO {
    private long id;
    @NotBlank(message = "Not be empty")
    private String text;

    private Discussion discussion;
}
