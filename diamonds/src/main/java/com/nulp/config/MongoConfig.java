package com.nulp.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories("com.nulp.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    public @Bean
    MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.nulp");
    }

    @Override
    protected String getDatabaseName() {
        return "necklace-db";
    }
}
