package com.peminjaman.buku.serviceImpl;

import java.util.*;

import org.hibernate.UnresolvableObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peminjaman.buku.model.Book;
import com.peminjaman.buku.repository.BookRepository;
import com.peminjaman.buku.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(){
        List<Book> allBooks = bookRepository.findAll();
        return allBooks;
    }

    public Book detailBook(String id){
        Book book = bookRepository.findById(id).orElseThrow();
        return book;
    }

    @Override
    public void saveBook(Book book) {
        try {
            Book book1 = bookRepository.findById(book.getId()).orElseThrow();
            List<Book> allBooks = bookRepository.findAll();
            if(allBooks.contains(book1)){
                 System.out.println("Gagal Disimpan, ID Duplikat!");
            }
         } catch (Exception e) {
             bookRepository.save(book);
             System.out.println("Buku Telah Disimpan!");
        }
    }

    @Override
    public Book updateBook(String id, Book book) {
        Book book1 = bookRepository.findById(id).orElseThrow();
        book1.setJudul(book.getJudul());
        book1.setPengarang(book.getPengarang());
        book1.setPenerbit(book.getPenerbit());
        book1.setTanggal_terbit(book.getTanggal_terbit());
        book1.setTebal_buku(book.getTebal_buku());
        bookRepository.save(book1);
        return book;
    }

    @Override
    public Book updateStatus(String id, Book book) {
        Book book1 = bookRepository.findById(id).orElseThrow();
        int status = book.getStatus();
        if(status == 1){
            book1.setStatus(status);
            book1.setPeminjam(book.getPeminjam());
            book1.setTanggal_pinjam(book.getTanggal_pinjam());
            book1.setTanggal_kembali(book.getTanggal_kembali());
            bookRepository.save(book1);
            return book1;
        }else if(status == 0){
            book1.setStatus(status);
            book1.setPeminjam("");
            book1.setTanggal_pinjam(null);
            book1.setTanggal_kembali(null);
            bookRepository.save(book1);
            return book1;
        }else{
            throw new UnresolvableObjectException(Book.class, "Bad Request ");
        }  
    }

    @Override
    public List<Book> getBookStatus(int status) {
        List<Book> book = bookRepository.findByStatus(status);
        return book;
    }

    @Override
    public void deleteBook(String id){
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        System.out.println("ID Buku : "+id+", Telah Berhasil Dihapus!");
    }


}
