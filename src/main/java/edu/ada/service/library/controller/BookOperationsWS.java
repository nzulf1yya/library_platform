package edu.ada.service.library.controller;

import edu.ada.service.library.BookNotFoundException;
import org.springframework.http.ResponseEntity;

public interface BookOperationsWS {

    ResponseEntity listCategory();
    ResponseEntity listBooks();
    ResponseEntity listPickedUpBooks();
    ResponseEntity pickUpBook(String title, String token);
    ResponseEntity dropoffBook(String title);
    ResponseEntity searchByCategory(String category);
    ResponseEntity searchByTitle(String title);
    ResponseEntity searchByAuthor(String author);
    ResponseEntity listMetaData();
    ResponseEntity getBookById(int book_id) throws BookNotFoundException;
}
