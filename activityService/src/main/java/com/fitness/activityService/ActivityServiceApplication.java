package com.fitness.activityService;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ActivityServiceApplication {
    @Autowired
    private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ActivityServiceApplication.class, args);
	}

    @PostConstruct
    public void checkDB() {
        System.out.println("Connected DB = " +
                mongoTemplate.getDb().getName());
    }

}
