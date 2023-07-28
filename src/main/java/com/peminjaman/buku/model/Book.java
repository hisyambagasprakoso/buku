package com.peminjaman.buku.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "book")
public class Book {
 
    public Book(Book book1) {
    }

    @Id
    @NonNull
    @Column(unique = true, length = 5)
    private String id;

    @Column(nullable = false, unique = true, length = 100)
    private String judul;

    @Column(nullable = false, length = 50)
    private String pengarang;

    @Column(nullable = false, length = 50)
    private String penerbit;

    @Column(nullable = false, name = "tanggal_terbit", length = 11)
    private String tanggal_terbit;

    @Column(nullable = false, length = 11)
    private Integer tebal_buku;

    @Column(nullable = false, length = 1)
    private int status;

    @Column(nullable = false)
    private String peminjam = "";

    @Column(nullable = true, name = "tanggal_pinjam", length = 11)
    private String tanggal_pinjam;

    @Column(nullable = true ,name = "tanggal_kembali", length = 11)
    private String tanggal_kembali;

}
