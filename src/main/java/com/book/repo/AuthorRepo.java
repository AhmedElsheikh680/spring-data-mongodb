package com.book.repo;

import com.book.document.Author;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo  extends BaseRepo<Author, String>{

//    @Query("{email:  '?0'}")
//    Author findAuthorByEmail(String email);

    @Query(value = "{email:  '?0'}", fields = "{'name': 1, 'email': 1}")
    Author findAuthorByEmail(String email);
}
