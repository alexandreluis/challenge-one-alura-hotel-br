-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2023 at 10:21 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `alurahotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospedes`
--

CREATE TABLE `hospedes` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `nacionalidade` varchar(50) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `id_reserva` int(11)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hospedes`
--

INSERT INTO `hospedes` (`id`, `nome`, `sobrenome`, `data_nascimento`, `nacionalidade`, `telefone`, `id_reserva`) VALUES
(1, 'valter3', 'dimosas', '2000-12-21', 'brasileiro', '5132595859', 13),
(2, 'valter4', 'jomas', '2000-07-21', 'argentino', '5632568859', 15),
(4, 'Helen', 'Camargo', '2003-11-14', 'alemão', '(11) 192454847', 16),
(5, 'Otiz', 'Saldanha', '1996-06-29', 'guatemalteco', '(51) 748591526', 17),
(6, 'Alcapone', 'Alura mais', '1990-08-08', 'gambiano', '51 32454578', 18);

-- --------------------------------------------------------



-- --------------------------------------------------------

--
-- Table structure for table `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `data_entrada` date NOT NULL,
  `data_saida` date NOT NULL,
  `valor` double NOT NULL,
  `forma_pagamento` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservas`
--

INSERT INTO `reservas` (`id`, `data_entrada`, `data_saida`, `valor`, `forma_pagamento`) VALUES
(13, '2023-08-29', '2023-08-31', 80, 'DEBITO'),
(15, '2024-03-15', '2026-08-26', 8940, 'BOLETO'),
(16, '2023-11-16', '2023-11-30', 140, 'CREDITO'),
(17, '2023-08-23', '2023-08-26', 30, 'DEBITO'),
(18, '2023-08-29', '2023-09-13', 150, 'DEBITO');


CREATE TABLE logins
(
    id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(255) NOT NULL,
    pass TEXT NOT NULL
);


INSERT INTO `logins` (`id`, `login`, `pass`) VALUES (NULL, 'admin', '$2a$12$fZ1ECkTTRM0Z3T3y1cNgteG58na2OBPNQQapqwVIaDefiTU4IhN8u'); 

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospedes`
--
ALTER TABLE `hospedes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_reserva` (`id_reserva`);



--
-- Indexes for table `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hospedes`
--
ALTER TABLE `hospedes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;



--
-- AUTO_INCREMENT for table `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hospedes`
--
ALTER TABLE `hospedes`
  ADD CONSTRAINT `hospedes_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
