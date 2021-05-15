package com.example.demo_rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    Repo repo;
    @Autowired
    ExRepo erepo;
    @RabbitListener(queues = Config.QUEUE)
    public void consumeMessageFromQueue(Test test) {
        MyEntity myEntity=new MyEntity();
        if (!erepo.existsByName(test.getExample())){
            myEntity.setAge(test.getAge());
            myEntity.setName(test.getName());
            Example example=new Example();
            example.setName(test.getExample());
            erepo.save(example);

            myEntity.setExample(example);
            repo.save(myEntity);
        }else {
            myEntity.setName(test.getName());
            myEntity.setAge(test.getAge());
            Example example=erepo.findByName(test.getExample());
            myEntity.setExample(example);
            repo.save(myEntity);
        }


    }
}
