package com.book.service;

import com.book.document.Author;
import com.book.repo.AuthorRepo;
import com.book.repo.CustomAuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends BaseService<Author, String> {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private CustomAuthorRepo customAuthorRepo;


    public Author update(Author author) {
       Author author1 = findById(author.getId());
       author1.setName(author.getName());
       author1.setEmail(author.getEmail());
       author1.setPhone(author.getPhone());

       return super.update(author1);
    }

    public void updateEmail(String email, String name, String phone) {
        customAuthorRepo.updateEmail(email, name, phone);
    }

    public Author findAuthorByEmail(String email) {
        return authorRepo.findAuthorByEmail(email);
    }

}
