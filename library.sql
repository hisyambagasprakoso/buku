-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Jul 2023 pada 09.44
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `book`
--

CREATE TABLE `book` (
  `id` varchar(5) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `pengarang` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `tanggal_terbit` date NOT NULL,
  `tebal_buku` int(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  `peminjam` varchar(50) NOT NULL DEFAULT '',
  `tanggal_pinjam` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `book`
--

INSERT INTO `book` (`id`, `judul`, `pengarang`, `penerbit`, `tanggal_terbit`, `tebal_buku`, `status`, `peminjam`, `tanggal_pinjam`, `tanggal_kembali`) VALUES
('A0001', 'Harry Potter dan Sapu Terbang', 'J.K Rowling', 'Gramedia', '1997-06-29', 384, 1, 'Hisyam Bagas P', '2023-07-27', '2023-07-28'),
('A0002', 'Harry Potter dan Batu Bertuah', 'J.K Rowling', 'Gramedia', '1997-06-29', 384, 0, '', NULL, NULL),
('A0003', 'Bumi Manusia', 'Pramoedya Ananta Toer', 'Hasta Mitra', '1984-06-29', 533, 0, '', NULL, NULL),
('A0004', 'Negeri 5 Menara', 'Ahmad Fuadi', 'PT Gramedia Pustaka Utama', '2009-01-29', 416, 1, 'Hisyam Bagas P', '2023-07-27', '2023-07-28'),
('A0005', '50 CM', 'Dhony Dhirgantoro', 'PT Grasindo', '2005-01-21', 382, 0, '', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
