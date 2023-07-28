package com.peminjaman.buku.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peminjaman.buku.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByStatus(Integer status);
    Optional<Book> findById(String id);
}
