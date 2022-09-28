package com.book.service;

import com.book.document.Author;
import com.book.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends BaseService<Author, String> {

    @Autowired
    private AuthorRepo authorRepo;

    public Author update(Author author) {
       Author author1 = findById(author.getId());
       author1.setName(author.getName());
       author1.setEmail(author.getEmail());
       author1.setPhone(author.getPhone());

       return super.update(author1);
    }

}
