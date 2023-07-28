package com.peminjaman.buku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.peminjaman.buku.model.Book;
import com.peminjaman.buku.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }
    
    @GetMapping
    ResponseEntity<?> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    ResponseEntity<?> getBooksByStatus(@PathVariable int status){
        if(status==1 || status==0){
            return new ResponseEntity<>(bookService.getBookStatus(status), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("BAD REQUEST",HttpStatus.BAD_REQUEST);
        }  
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getDetailBook(@PathVariable String id){
        return new ResponseEntity<>(bookService.detailBook(id), HttpStatus.OK);
    }

    @PutMapping("/data/{id}")
    ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK);
    }

    @PutMapping("/status/{id}")
    ResponseEntity<?> updateStatus(@PathVariable String id, @RequestBody Book book){
        return new ResponseEntity<>(bookService.updateStatus(id, book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
