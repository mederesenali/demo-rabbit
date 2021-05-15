package com.example.demo_rabbitmq.model;


import ch.qos.logback.classic.boolex.GEventEvaluator;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    Set<Student> likes;
}
