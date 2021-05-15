package com.example.demo_rabbitmq;

import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository<MyEntity,Integer> {

}
