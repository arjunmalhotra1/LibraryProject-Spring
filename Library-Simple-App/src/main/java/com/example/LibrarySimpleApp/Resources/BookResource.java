package com.example.LibrarySimpleApp.Resources;
import com.example.LibrarySimpleApp.Exception.BookNotFoundException;
import com.example.LibrarySimpleApp.dto.Book;

import java.util.ArrayList;
import java.util.List;
import com.example.LibrarySimpleApp.dto.BookRepository;
import org.glassfish.jersey.client.authentication.ResponseAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BookResource {

    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    List<Book> findAll()
    {
        List<Book> list=new ArrayList<Book>();
        try {
            list=repository.findAll();
            if (list.size() == 0)
            {
                throw new BookNotFoundException(5);
            }
        }
        catch (BookNotFoundException exc)
        {
            System.out.println(exc);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Book Not found, Please Try again",exc);
        }
        return list;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@RequestBody Book newBook)
    {
        return repository.save(newBook);
    }

}
