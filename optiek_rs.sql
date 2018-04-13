-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2017 at 05:01 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `optiek_rs`
--

-- --------------------------------------------------------

--
-- Table structure for table `aankopen`
--

CREATE TABLE `aankopen` (
  `id` int(10) NOT NULL,
  `klant_id` int(10) NOT NULL,
  `product_id` int(10) NOT NULL,
  `datum` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aankopen`
--

INSERT INTO `aankopen` (`id`, `klant_id`, `product_id`, `datum`) VALUES
(1, 5, 1, '2017-11-22');

-- --------------------------------------------------------

--
-- Table structure for table `klanten`
--

CREATE TABLE `klanten` (
  `id` int(11) NOT NULL,
  `voornaam` varchar(250) NOT NULL,
  `achternaam` varchar(250) NOT NULL,
  `id_nummer` varchar(60) NOT NULL,
  `geboorte_datum` date NOT NULL,
  `geslacht` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `klanten`
--

INSERT INTO `klanten` (`id`, `voornaam`, `achternaam`, `id_nummer`, `geboorte_datum`, `geslacht`) VALUES
(5, 'tim', 'tomrr', '', '2017-11-23', 'r'),
(6, 'agoe', 'degu', '9', '2017-11-17', 'o'),
(7, 'virwhs', 'ramdin', '13', '2017-11-09', 'o'),
(8, 'Shayant', 'Sital', '456738290', '2017-12-02', 'M');

-- --------------------------------------------------------

--
-- Table structure for table `oogmeting`
--

CREATE TABLE `oogmeting` (
  `id` int(11) NOT NULL,
  `klant_id` int(11) NOT NULL,
  `breekkracht` varchar(255) NOT NULL,
  `brekingshoek` varchar(255) NOT NULL,
  `sterkte` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oogmeting`
--

INSERT INTO `oogmeting` (`id`, `klant_id`, `breekkracht`, `brekingshoek`, `sterkte`) VALUES
(1, 5, '10', '10', '10');

-- --------------------------------------------------------

--
-- Table structure for table `producten`
--

CREATE TABLE `producten` (
  `id` int(255) NOT NULL,
  `type` enum('Glazen','zonnebril','lenzen','kinderbril') NOT NULL,
  `merk` varchar(255) NOT NULL,
  `qty` int(200) NOT NULL,
  `naam` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producten`
--

INSERT INTO `producten` (`id`, `type`, `merk`, `qty`, `naam`) VALUES
(1, 'Glazen', 'gucci ', 12, 'gang'),
(2, 'Glazen', 'LV', 6, 'qwerty'),
(3, 'Glazen', 'Kenneth Cole', 2, 'Bril'),
(4, 'Glazen', 'An', 5, 'Bril'),
(5, 'Glazen', 'Kenneth Cole', 20, 'Bril');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aankopen`
--
ALTER TABLE `aankopen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `klant_id` (`klant_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `klanten`
--
ALTER TABLE `klanten`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oogmeting`
--
ALTER TABLE `oogmeting`
  ADD PRIMARY KEY (`id`),
  ADD KEY `klant_id` (`klant_id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `producten`
--
ALTER TABLE `producten`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aankopen`
--
ALTER TABLE `aankopen`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `klanten`
--
ALTER TABLE `klanten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `oogmeting`
--
ALTER TABLE `oogmeting`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `producten`
--
ALTER TABLE `producten`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `aankopen`
--
ALTER TABLE `aankopen`
  ADD CONSTRAINT `aankopen_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `producten` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aankopen_ibfk_2` FOREIGN KEY (`klant_id`) REFERENCES `klanten` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `oogmeting`
--
ALTER TABLE `oogmeting`
  ADD CONSTRAINT `oogmeting_ibfk_1` FOREIGN KEY (`klant_id`) REFERENCES `klanten` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
