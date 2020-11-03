package br.com.uniportal.bussiness.users.control;

import br.com.uniportal.bussiness.users.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserRepository {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public User getUserByLogin(String login) {
        var query = new Query().addCriteria(Criteria.where("login").is(login));

        return mongoTemplate.findOne(query, User.class);
    }

}
