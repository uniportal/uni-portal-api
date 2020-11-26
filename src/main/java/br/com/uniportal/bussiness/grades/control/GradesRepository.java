package br.com.uniportal.bussiness.grades.control;

import br.com.uniportal.bussiness.grades.entity.Grade;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class GradesRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    public Boolean insertGrade(Grade grade) {
        this.mongoTemplate.save(grade, "Grades");
        return true;
    }
    
    public Grade getUsersGradesByDocument(String document) {
        var query = new Query().addCriteria(Criteria.where("userDocument").is(document));
        
        return mongoTemplate.findOne(query, Grade.class, "Grades"); 
    }
}