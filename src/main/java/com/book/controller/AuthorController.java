package com.book.controller;


import com.book.document.Author;
import com.book.service.AuthorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

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

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findAuthorByEmail(@PathVariable @Email String email) {
        return ResponseEntity.ok(authorService.findAuthorByEmail(email));
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

    @PutMapping("/custom")
    public ResponseEntity<?> updateEmail(@RequestParam @Email String email,
                                         @RequestParam String name, @RequestParam String phone) {
        authorService.updateEmail(email, name, phone);
        return ResponseEntity.ok(null);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByOId(@PathVariable String id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(null);
    }



















}
