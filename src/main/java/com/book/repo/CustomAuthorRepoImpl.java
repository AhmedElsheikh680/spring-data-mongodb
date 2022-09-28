package com.book.repo;

import com.book.document.Author;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;

@Repository
public class CustomAuthorRepoImpl implements CustomAuthorRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void updateEmail(String email, String name, String phone) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update();
        update.set("name", name);
        update.set("phone", phone);

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Author.class);

        if (updateResult ==null) {
            System.out.println("No Documents Updated!!");
        } else {
            System.out.println(updateResult.getModifiedCount() + " Document(s) Updated....");
        }

    }
}
