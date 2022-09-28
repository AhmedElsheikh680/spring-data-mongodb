package com.book.repo;

import com.book.document.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo  extends BaseRepo<Author, String>{
}
