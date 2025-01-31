-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2025 at 08:25 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blood`
--

-- --------------------------------------------------------

--
-- Table structure for table `confirm_request`
--

CREATE TABLE `confirm_request` (
  `id` int(255) NOT NULL,
  `donor_id` int(255) NOT NULL,
  `request_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `confirm_request`
--

INSERT INTO `confirm_request` (`id`, `donor_id`, `request_id`) VALUES
(3, 4, 5),
(4, 4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `donor_registration`
--

CREATE TABLE `donor_registration` (
  `id` int(255) NOT NULL,
  `d_username` varchar(255) NOT NULL,
  `d_blood_group` varchar(255) NOT NULL,
  `d_mobile` varchar(255) NOT NULL,
  `d_current_age` int(255) NOT NULL,
  `d_gender` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `donor_registration`
--

INSERT INTO `donor_registration` (`id`, `d_username`, `d_blood_group`, `d_mobile`, `d_current_age`, `d_gender`) VALUES
(3, 'Abir', 'O+', '123456', 56, 'Male'),
(4, 'Nila', 'B+', '123', 23, 'Female'),
(5, 'Hati', 'B+', '019557505', 27, 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` int(255) NOT NULL,
  `blood` varchar(255) NOT NULL,
  `quantity` int(255) NOT NULL,
  `hospital` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `date` varchar(200) NOT NULL,
  `disease` varchar(200) NOT NULL,
  `status` varchar(11) NOT NULL DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`id`, `blood`, `quantity`, `hospital`, `contact`, `date`, `disease`, `status`) VALUES
(1, 'O+', 1, 'Dhaka Medical', '01986557505', '2024-12-26', 'Dengue', 'pending'),
(2, 'A+', 20, 'Ahsania Cancer Hospital', '01912916170', '2025-01-03', 'Lung Cancer', 'pending'),
(3, 'B+', 1, 'Tahmia Hospital', '456', '2025-01-03', 'Blood Cancer', 'pending'),
(4, 'B+', 1, 'Rashid Hospital', '789', '2025-01-11', 'Breast Cancer', 'Approved'),
(5, 'B+', 2, 'Ahsania Mission', '42313', '2025-02-12', 'AIDS', 'Approved');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `confirm_request`
--
ALTER TABLE `confirm_request`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donor_registration`
--
ALTER TABLE `donor_registration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `confirm_request`
--
ALTER TABLE `confirm_request`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `donor_registration`
--
ALTER TABLE `donor_registration`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
