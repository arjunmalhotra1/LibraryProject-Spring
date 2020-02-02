package com.example.LibrarySimpleApp.Exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(int id)
    {
        super("Book Id"+id);
    }

}
