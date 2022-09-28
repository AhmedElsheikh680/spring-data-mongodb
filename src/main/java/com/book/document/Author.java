package com.book.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Document(collection = "author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author extends BaseDocument<String> {

    @NotEmpty
    private String name;

    @Email
    private String email;

    private String phone;
}
