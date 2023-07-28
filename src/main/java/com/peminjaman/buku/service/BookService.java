package com.peminjaman.buku.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peminjaman.buku.model.Book;

@Service
public interface BookService {
    List<Book> getAllBooks();
    List<Book> getBookStatus(int status);
    Book detailBook(String id);
    void saveBook(Book book);
    Book updateBook(String id, Book book);
    Book updateStatus(String id, Book book);
    void deleteBook(String id);
    
}
