package com.mir.projectbrainapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "author")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(unique = false, nullable = false)
    private String title;

    @Column(unique = false, nullable = false)
    private String context;

    @Column(unique = false, nullable = false)
    private String content;

    @ManyToOne
    @JsonIgnore
    private Brain author;
}
