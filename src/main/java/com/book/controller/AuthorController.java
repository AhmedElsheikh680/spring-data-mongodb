package com.book.controller;


import com.book.document.Author;
import com.book.service.AuthorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.insert(author));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.update(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByOId(@PathVariable String id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(null);
    }



















}
