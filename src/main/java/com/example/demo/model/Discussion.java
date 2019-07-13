package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String theme;
    private String description;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comment;

}
