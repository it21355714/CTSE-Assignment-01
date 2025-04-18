package com.example.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    // This bean is used to create a custom MongoTemplate, which is an abstraction layer for working with MongoDB.
    @Bean
    public MongoTemplate mongoTemplate() {
        // MongoDB Atlas URI to connect to the database
        String connectionString = "mongodb+srv://jeno12345:jeno1234@cluster0.a9urfiy.mongodb.net/orderdb?retryWrites=true&w=majority";

        // SimpleMongoClientDatabaseFactory creates a connection to MongoDB using the provided URI and database name
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(connectionString), "orderdb"));
    }
}
