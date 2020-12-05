package Mongo.mongoEx;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo  extends MongoRepository<User, Long> {

}
