package com.mir.projectbrainapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "ideas")
public class Brain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    // TODO: Changed to passHash when we work on security
    @Column(unique = false, nullable = false)
    private String password;

    // TODO: Whatever info u want
    @Column(unique = false, nullable = true)
    private String firstName;
    @Column(unique = false, nullable = true)
    private String lastName;

    @ManyToMany
    private Set<Brain> followers;

    @OneToMany
    @JsonIgnore
    private Set<Idea> ideas;
}
