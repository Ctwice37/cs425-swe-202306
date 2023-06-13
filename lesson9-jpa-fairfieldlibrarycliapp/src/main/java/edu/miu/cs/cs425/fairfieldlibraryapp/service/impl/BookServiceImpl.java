package edu.miu.cs.cs425.fairfieldlibraryapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Book;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.BookRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book addNewBook(Book newBook) {
        return bookRepository.save(newBook);
    }
}
