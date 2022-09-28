package com.book.repo;

import com.book.document.BaseDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<T extends BaseDocument<ID>, ID> extends MongoRepository<T, ID> {
}
