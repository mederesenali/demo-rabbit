package com.example.demo_rabbitmq;

import org.springframework.data.repository.CrudRepository;

public interface ExRepo  extends CrudRepository<Example,Integer> {

    Boolean existsByName(String name);
    Example findByName(String name);
}
