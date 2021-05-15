package com.example.demo_rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/")
    public String testOrder(@RequestBody Test test) {

        template.convertAndSend(Config.EXCHANGE, Config.ROUTING_KEY, test);
        return "Success !!";
    }

}
