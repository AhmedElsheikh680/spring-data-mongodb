package com.book.service;

import com.book.document.BaseDocument;
import com.book.repo.BaseRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public class BaseService<T extends BaseDocument<ID>, ID> {

    @Autowired
    private BaseRepo<T, ID> baseRepo;

    public T findById(ID id) {
        return baseRepo.findById(id).get();
    }

    public List<T> findAll() {
        return baseRepo.findAll();
    }

    public T insert(T t ){
        if (t.getId() !=null) {
            throw new RuntimeException();
        }
        return baseRepo.insert(t);
    }

    public List<T> insertAll(List<T> t) {
        return baseRepo.saveAll(t);
    }

    public T update(T t) {
       return baseRepo.save(t);    }

    public void deleteById(ID id) {
         baseRepo.deleteById(id);
    }
}
