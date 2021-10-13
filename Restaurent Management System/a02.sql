-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2018 at 04:38 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `a02`
--

-- --------------------------------------------------------

--
-- Table structure for table `chef`
--

CREATE TABLE `chef` (
  `userId` varchar(12) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(35) NOT NULL,
  `salary` double(8,2) NOT NULL,
  `status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chef`
--

INSERT INTO `chef` (`userId`, `name`, `address`, `salary`, `status`) VALUES
('f001', 'Chef1', 'Banani', 25000.00, 3),
('f002', 'Chef2', 'Mirpur', 22000.00, 3);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `userId` varchar(12) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(35) NOT NULL,
  `status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`userId`, `name`, `address`, `status`) VALUES
('c001', 'customer1', 'Boshundhora', 1),
('c002', 'Customer2', 'Boshundhora', 1),
('c003', 'customer3', 'kuril', 1);

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `id` varchar(5) NOT NULL,
  `name` varchar(40) NOT NULL,
  `amount` int(10) NOT NULL,
  `price` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`id`, `name`, `amount`, `price`) VALUES
('001', 'Chicken Burger', 45, 160.00),
('002', 'Beef Burger', 50, 200.00),
('003', 'Peperoni Pizza', 30, 1000.00),
('004', 'Cheese Pizza', 30, 800.00),
('005', 'Sandwich', 74, 30.00),
('006', 'Set Menu 01', 30, 200.00),
('007', 'Set Menu 02', 30, 220.00),
('008', 'Coke', 100, 20.00),
('009', 'Coffee', 77, 50.00),
('010', 'Water', 200, 15.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(12) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('c001', 'cc001', 1),
('c002', 'cc002', 1),
('c003', 'cc003', 1),
('f001', 'ff001', 3),
('f002', 'ff002', 3),
('m001', 'mm001', 0),
('m002', 'mm002', 0),
('w001', 'ww001', 2),
('w002', 'ww002', 2);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `userId` varchar(12) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(35) NOT NULL,
  `salary` double(8,2) NOT NULL,
  `status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`userId`, `name`, `address`, `salary`, `status`) VALUES
('m001', 'Manager', 'Dhaka', 30000.00, 0),
('m002', ' Manager2', 'Baridhara', 30000.00, 0);

-- --------------------------------------------------------

--
-- Table structure for table `order food`
--

CREATE TABLE `order food` (
  `id` varchar(12) NOT NULL,
  `food` varchar(30) NOT NULL,
  `quantity` int(12) NOT NULL,
  `price` double(8,2) NOT NULL,
  `total price` double(8,2) NOT NULL,
  `status` varchar(12) NOT NULL,
  `customerId` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order food`
--

INSERT INTO `order food` (`id`, `food`, `quantity`, `price`, `total price`, `status`, `customerId`) VALUES
('2', 'Chicken Burger', 2, 320.00, 650.00, 'done', 'c002'),
('2', 'Sandwich', 6, 180.00, 650.00, 'done', 'c002'),
('2', 'Coffee', 3, 150.00, 650.00, 'done', 'c002'),
('1', 'Chicken Burger', 3, 480.00, 480.00, 'done', 'c002');

-- --------------------------------------------------------

--
-- Table structure for table `waiter`
--

CREATE TABLE `waiter` (
  `userId` varchar(12) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(35) NOT NULL,
  `salary` double(8,2) NOT NULL,
  `status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `waiter`
--

INSERT INTO `waiter` (`userId`, `name`, `address`, `salary`, `status`) VALUES
('w001', 'Waiter1', 'khulna', 15000.00, 2),
('w002', 'Waiter2', 'Comilla', 16000.00, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chef`
--
ALTER TABLE `chef`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `waiter`
--
ALTER TABLE `waiter`
  ADD PRIMARY KEY (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
