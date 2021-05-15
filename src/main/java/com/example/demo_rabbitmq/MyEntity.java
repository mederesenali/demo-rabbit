package com.example.demo_rabbitmq;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;

    @ManyToOne
    Example example;
}
