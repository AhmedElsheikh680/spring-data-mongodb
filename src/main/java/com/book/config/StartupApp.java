package com.book.config;

import com.book.document.Author;
import com.book.repo.AuthorRepo;
import com.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApp implements CommandLineRunner {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public void run(String... args) throws Exception {

        //Adding some data if is empty
        if(authorRepo.findAll().isEmpty()) {
            Author author = new Author();
            author.setName("Ahmed");
            author.setEmail("a@a.com");
            author.setPhone("111111111111");

            Author author2 = new Author();
            author2.setName("Mohamed");
            author2.setEmail("m@m.com");
            author2.setPhone("22222222222222");

            Author author3 = new Author();
            author3.setName("Samy");
            author3.setEmail("s@s.com");
            author3.setPhone("333333333333");

            authorRepo.insert(Arrays.asList(author, author2, author3));


        }















    }
}
