package edu.ada.service.library.service.impl;
import edu.ada.service.library.BookNotFoundException;
import edu.ada.service.library.model.dto.BookModel;
import edu.ada.service.library.model.dto.CommentModel;
import edu.ada.service.library.model.entity.BookEntity;
import edu.ada.service.library.model.entity.CommentEntity;
import edu.ada.service.library.repository.BookRepository;
import edu.ada.service.library.service.BookService;
import edu.ada.service.library.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "BookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CommentService commentService;

    @Override
    public ArrayList<String> listCategory() {
        return bookRepository.findCategories();
    }

    @Override
    public ArrayList<String> listBooks() {
        return bookRepository.findBookTitles();
    }

    @Override
    public ArrayList<String> listPickedUpBooks() {
        return bookRepository.findPickedUpBooks();
    }

    @Override
    public ArrayList<String> listMetaData() {
        return bookRepository.findMetaData();
    }

    @Override
    public void pickup(String username, String title) {
        bookRepository.pickupBook(username, title);
    }

    @Override
    public void dropoff(String title) {
        bookRepository.dropoffBook(title);
    }

    @Override
    public BookEntity searchByCategory(String category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public BookEntity searchByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    @Override
    public BookEntity searchByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public BookModel fetchById(Long id) throws BookNotFoundException {
        Optional<BookEntity> book = bookRepository.findById(id);
        if (book.isEmpty()) throw new BookNotFoundException();

        BookModel bookModel = new BookModel(book.get());

        bookModel.setComments((commentService.getCommentByBookExtId(id)));
        return bookModel;

    }
}