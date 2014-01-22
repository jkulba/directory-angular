package us.kulba.directory.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import us.kulba.directory.dao.ContactRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = ContactRepository.class)
public class ApplicationConfig {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        String mongoDbHost = "10.9.152.52";
        int mongoDbPort = 27017;
        Mongo mongo = new Mongo(mongoDbHost, mongoDbPort);
//        UserCredentials userCredentials = new UserCredentials(username, password);
        String databaseName = "directory";
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }

}
