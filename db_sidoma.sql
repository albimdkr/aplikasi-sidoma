-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2022 at 09:36 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sidoma`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_kegiatan`
--

CREATE TABLE `data_kegiatan` (
  `no_kegiatan` int(11) NOT NULL,
  `nama_kegiatan` varchar(200) NOT NULL,
  `tanggal_kegiatan` date NOT NULL,
  `lokasi` varchar(200) NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `kuota_pendonor` int(11) NOT NULL,
  `jumlah_petugas` int(11) NOT NULL,
  `perijinan_ketua` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_kegiatan`
--

INSERT INTO `data_kegiatan` (`no_kegiatan`, `nama_kegiatan`, `tanggal_kegiatan`, `lokasi`, `keterangan`, `kuota_pendonor`, `jumlah_petugas`, `perijinan_ketua`) VALUES
(5, 'Peringatan HUT RI ke 77', '2022-08-17', 'Gor Koni Desa Cikaro Kec. Majalaya Kab. Bandung', 'Dalam rangka memperingati HUT RI ke 77, PDDM akan bekerjsama dengan pemerintaha Kec. Majalaya serta bersama pihak rumah sakit Ebah Untuk melaksanakan Donor Darah.', 77, 30, 'Mengizinkan'),
(8, 'Save Blood', '2022-07-23', 'Gedung Balai Desa Majalaya Kec. Majalaya', 'Kegiatan ini turut bekerjsama dengan kitabisa.com', 200, 150, 'Mengizinkan');

-- --------------------------------------------------------

--
-- Table structure for table `data_keuangankeluar`
--

CREATE TABLE `data_keuangankeluar` (
  `no_uang` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `bulan` varchar(20) NOT NULL,
  `tahun` varchar(20) NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `uang_keluar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_keuangankeluar`
--

INSERT INTO `data_keuangankeluar` (`no_uang`, `tanggal`, `bulan`, `tahun`, `keterangan`, `uang_keluar`) VALUES
(3, '2022-07-19', '07', '2022', 'ATK', 20000),
(4, '2022-08-09', '08', '2022', 'Logistik', 40000),
(5, '2022-08-18', '08', '2022', 'Anggaran Proposal', 30000),
(6, '2022-09-19', '09', '2022', 'Maintance Web', 100000),
(7, '2022-12-27', '07', '2022', 'Kuota Petugas', 300000);

-- --------------------------------------------------------

--
-- Table structure for table `data_keuanganmasuk`
--

CREATE TABLE `data_keuanganmasuk` (
  `no_uang` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `bulan` varchar(20) NOT NULL,
  `tahun` varchar(20) NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `uang_masuk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_keuanganmasuk`
--

INSERT INTO `data_keuanganmasuk` (`no_uang`, `tanggal`, `bulan`, `tahun`, `keterangan`, `uang_masuk`) VALUES
(8, '2022-07-19', '07', '2022', 'Donatur', 50000),
(9, '2022-07-19', '08', '2022', 'Donatur', 30000),
(10, '2022-07-20', '07', '2022', 'Donatur KH Teks', 90000),
(11, '2022-10-19', '10', '2022', 'Donatur Jialeu', 50000),
(12, '2022-07-27', '07', '2022', 'Donasi dari bang haji gofur', 100000),
(13, '2022-08-23', '08', '2022', 'Donatur Kitabisa.com', 200000),
(14, '2022-12-21', '12', '2022', 'Donatur Haji Albi', 300000);

-- --------------------------------------------------------

--
-- Table structure for table `data_pasien`
--

CREATE TABLE `data_pasien` (
  `tanggal_daftar` date NOT NULL,
  `no_pasien` int(11) NOT NULL,
  `id_darah` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `no_telp` varchar(100) NOT NULL,
  `gmail` varchar(100) NOT NULL,
  `golongan_darah` varchar(10) NOT NULL,
  `jumlah_labu` int(11) NOT NULL,
  `usia` int(11) NOT NULL,
  `berat_badan` varchar(100) NOT NULL,
  `alamat` varchar(300) NOT NULL,
  `kondisi` varchar(10) NOT NULL,
  `penyakit` varchar(200) NOT NULL,
  `total_menerima_labu` int(11) NOT NULL,
  `tanggal_terakhir_transfusi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_pasien`
--

INSERT INTO `data_pasien` (`tanggal_daftar`, `no_pasien`, `id_darah`, `nama`, `jenis_kelamin`, `tanggal_lahir`, `no_telp`, `gmail`, `golongan_darah`, `jumlah_labu`, `usia`, `berat_badan`, `alamat`, `kondisi`, `penyakit`, `total_menerima_labu`, `tanggal_terakhir_transfusi`) VALUES
('2022-07-06', 1, 1, 'Kaviansyah Nugraha', 'Laki-Laki', '2004-11-01', '0854887883993', 'Kavi23gmail.com', 'O+', 1, 17, '43 Kg', 'KP. Bojong Reungas', 'Normal', 'Thalasemia', 1, '2022-07-06'),
('2022-07-18', 2, 1, 'Rusli Subagja', 'Perempuan', '2022-07-06', '0938848884884', 'rusli12@gmial.com', 'O+', 1, 17, '43 Kg', 'Kp. Leuwidulang Desa Majalaya', 'Normal', 'Thalasemia', 20, '2022-07-30'),
('2022-07-19', 3, 4, 'Rizki Nugaraha', 'Perempuan', '2006-12-09', '09388883993', 'rizki@gmail.com', 'AB+', 1, 17, '65 Kg', 'Jl. anyar Majalaya', 'Drop', 'Thalasemia', 6, '2022-07-15');

--
-- Triggers `data_pasien`
--
DELIMITER $$
CREATE TRIGGER `darah_keluar` AFTER INSERT ON `data_pasien` FOR EACH ROW BEGIN
UPDATE stok_darah SET stok = stok -NEW.Jumlah_labu WHERE id_darah = NEW.id_darah;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_kurang_darah` AFTER UPDATE ON `data_pasien` FOR EACH ROW BEGIN
UPDATE stok_darah SET stok = stok -NEW.Jumlah_labu WHERE id_darah = NEW.id_darah;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `data_pendonor`
--

CREATE TABLE `data_pendonor` (
  `tanggal_daftar` date NOT NULL,
  `no_pendonor` int(11) NOT NULL,
  `id_darah` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `no_telp` varchar(100) NOT NULL,
  `gmail` varchar(100) NOT NULL,
  `golongan_darah` varchar(10) NOT NULL,
  `jumlah_labu` int(11) NOT NULL,
  `usia` int(11) NOT NULL,
  `berat_badan` varchar(100) NOT NULL,
  `alamat` varchar(300) NOT NULL,
  `hemoglobin` varchar(10) NOT NULL,
  `riwayat_penyakit` varchar(200) NOT NULL,
  `total_donor` int(11) NOT NULL,
  `tanggal_terakhir_donor` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_pendonor`
--

INSERT INTO `data_pendonor` (`tanggal_daftar`, `no_pendonor`, `id_darah`, `nama`, `jenis_kelamin`, `tanggal_lahir`, `no_telp`, `gmail`, `golongan_darah`, `jumlah_labu`, `usia`, `berat_badan`, `alamat`, `hemoglobin`, `riwayat_penyakit`, `total_donor`, `tanggal_terakhir_donor`) VALUES
('2022-07-06', 1, 1, 'Husen Nur Alam', 'Laki-Laki', '1997-07-05', '0989993833', 'husenNur12@gmail.com', 'O+', 1, 24, '76 Kg', 'Kp. Bojong Reungas Desa Majasetra Kec. Majalaya Kabupaten Bandung', 'Cukup', '-', 1, '2022-07-06'),
('2022-07-06', 2, 1, 'Syamar Rudin Udi', 'Laki-Laki', '2000-07-31', '0989899388', 'Syam34@gmail.com', 'O+', 1, 23, '56 Kg', 'Kp. Manirancan Desa Majalaya Kec. Majalaya Kab. Bandung', 'Baik', '-', 1, '2022-07-06'),
('2022-07-12', 4, 2, 'Andi Permana', 'Laki-Laki', '2009-07-09', '09898939933', 'andi@gmail.com', 'A+', 1, 19, '56 Kg', 'Kp. Bongas Desa Majasetra Kec. Majalaya Kab. Bandung', 'Baik', '-', 1, '2022-07-12'),
('2022-07-18', 5, 2, 'Albi Mudakar', 'Laki-Laki', '2002-12-26', '0988388488444', 'albinasyabi@gmail.com', 'A+', 1, 19, '67 Kg', 'Kp. Bongas', 'Baik', '-', 8, '2022-06-24'),
('2022-07-19', 6, 4, 'Aldi Ardiansyah', 'Laki-Laki', '2003-09-06', '0938883773', 'aldi@gmail.com', 'AB+', 1, 18, '65 Kg', 'Jl. Manirancan Desa Majasetra Kec. Majalaya', 'Cukup', '-', 2, '2022-10-05');

--
-- Triggers `data_pendonor`
--
DELIMITER $$
CREATE TRIGGER `darah_masuk` AFTER INSERT ON `data_pendonor` FOR EACH ROW BEGIN
UPDATE stok_darah SET stok = stok +NEW.Jumlah_labu WHERE id_darah = NEW.id_darah;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_tambah_darah` AFTER UPDATE ON `data_pendonor` FOR EACH ROW BEGIN
UPDATE stok_darah SET stok = stok +NEW.Jumlah_labu WHERE id_darah = NEW.id_darah;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `data_petugas`
--

CREATE TABLE `data_petugas` (
  `id_petugas` int(11) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `no_telp` int(20) NOT NULL,
  `gmail` varchar(50) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  `tanggal_daftar` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_petugas`
--

INSERT INTO `data_petugas` (`id_petugas`, `nama`, `jenis_kelamin`, `no_telp`, `gmail`, `alamat`, `jabatan`, `tanggal_daftar`) VALUES
(5, 'Deni hamdani', 'Laki-Laki', 987746674, 'denihamdani13@gmail.com', 'Jl. Ebah Desa Cipaku Kec. Majalaya', 'Pembina', '2022-07-19'),
(6, 'ai darojat', 'Perempuan', 99838883, 'aidarojat@gmial.com', 'Kp. Bongas Desa Majasetra', 'Anggota Lapangan', '2022-07-19');

-- --------------------------------------------------------

--
-- Table structure for table `data_user`
--

CREATE TABLE `data_user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `no_telp` varchar(50) NOT NULL,
  `gmail` varchar(50) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `tanggal_daftar` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_user`
--

INSERT INTO `data_user` (`id_user`, `nama`, `no_telp`, `gmail`, `username`, `password`, `role`, `tanggal_daftar`) VALUES
(1, 'Albi Mudakar', '09898989393', 'AlbiNasy@gmail.com', 'albi_', '12345', 'Admin', '2022-06-25'),
(2, 'Aldi Ardianyah', '098989893434', 'Aldi@gmail.com', 'aldi_', '12345', 'Sekretaris', '2022-06-25'),
(3, 'Gina ', '09509405908', 'Gina@gmail.com', 'gina_', '12345', 'Bendahara', '2022-06-30'),
(4, 'Fachri', '098938498983', 'fachri@gmail.com', 'fachri_', '12345', 'Petugas', '2022-06-30'),
(5, 'Risna', '09893894834', 'risna@gmail.com', 'risna_', '12345', 'Petugas', '2022-06-30');

-- --------------------------------------------------------

--
-- Table structure for table `stok_darah`
--

CREATE TABLE `stok_darah` (
  `id_darah` int(11) NOT NULL,
  `golongan_darah` varchar(12) NOT NULL,
  `stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stok_darah`
--

INSERT INTO `stok_darah` (`id_darah`, `golongan_darah`, `stok`) VALUES
(1, 'O+', 1),
(2, 'A+', 2),
(3, 'B+', 0),
(4, 'AB+', 0),
(5, 'O-', 0),
(6, 'A-', 0),
(7, 'A-', 0),
(8, 'RH-NULL-', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_kegiatan`
--
ALTER TABLE `data_kegiatan`
  ADD PRIMARY KEY (`no_kegiatan`);

--
-- Indexes for table `data_keuangankeluar`
--
ALTER TABLE `data_keuangankeluar`
  ADD PRIMARY KEY (`no_uang`);

--
-- Indexes for table `data_keuanganmasuk`
--
ALTER TABLE `data_keuanganmasuk`
  ADD PRIMARY KEY (`no_uang`);

--
-- Indexes for table `data_pasien`
--
ALTER TABLE `data_pasien`
  ADD PRIMARY KEY (`no_pasien`),
  ADD KEY `id_darah` (`id_darah`);

--
-- Indexes for table `data_pendonor`
--
ALTER TABLE `data_pendonor`
  ADD PRIMARY KEY (`no_pendonor`),
  ADD KEY `id_darah` (`id_darah`);

--
-- Indexes for table `data_petugas`
--
ALTER TABLE `data_petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `data_user`
--
ALTER TABLE `data_user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `stok_darah`
--
ALTER TABLE `stok_darah`
  ADD PRIMARY KEY (`id_darah`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_kegiatan`
--
ALTER TABLE `data_kegiatan`
  MODIFY `no_kegiatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `data_keuangankeluar`
--
ALTER TABLE `data_keuangankeluar`
  MODIFY `no_uang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `data_keuanganmasuk`
--
ALTER TABLE `data_keuanganmasuk`
  MODIFY `no_uang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `data_pasien`
--
ALTER TABLE `data_pasien`
  MODIFY `no_pasien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `data_pendonor`
--
ALTER TABLE `data_pendonor`
  MODIFY `no_pendonor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `data_petugas`
--
ALTER TABLE `data_petugas`
  MODIFY `id_petugas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `data_user`
--
ALTER TABLE `data_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `stok_darah`
--
ALTER TABLE `stok_darah`
  MODIFY `id_darah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_pasien`
--
ALTER TABLE `data_pasien`
  ADD CONSTRAINT `data_pasien_ibfk_1` FOREIGN KEY (`id_darah`) REFERENCES `stok_darah` (`id_darah`);

--
-- Constraints for table `data_pendonor`
--
ALTER TABLE `data_pendonor`
  ADD CONSTRAINT `data_pendonor_ibfk_1` FOREIGN KEY (`id_darah`) REFERENCES `stok_darah` (`id_darah`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
