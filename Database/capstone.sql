-- phpMyAdmin SQL Dump
-- version 4.0.6deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 24, 2014 at 03:03 PM
-- Server version: 5.5.35-0ubuntu0.13.10.2
-- PHP Version: 5.5.3-1ubuntu2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `capstone`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(40) NOT NULL,
  `authority` varchar(40) NOT NULL,
  `auth_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`auth_id`),
  UNIQUE KEY `auth_id` (`auth_id`),
  KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`, `auth_id`) VALUES
('test', 'ROLE_ADMIN', 1),
('test', 'ROLE_USER', 2),
('test2', 'ROLE_USER', 3),
('username', 'ROLE_USER', 4),
('user', 'ROLE_USER', 5);

-- --------------------------------------------------------

--
-- Table structure for table `building`
--

CREATE TABLE IF NOT EXISTS `building` (
  `building_id` int(11) NOT NULL AUTO_INCREMENT,
  `building_name` varchar(25) NOT NULL,
  `internet` decimal(10,0) NOT NULL,
  `water` decimal(10,0) NOT NULL,
  `trash` decimal(10,0) NOT NULL,
  `electric` decimal(10,0) NOT NULL,
  `gas` decimal(10,0) NOT NULL,
  `total_util` decimal(10,0) NOT NULL,
  `total_sqft` decimal(10,0) NOT NULL,
  `base_rent` decimal(10,0) NOT NULL,
  `renter_insurance` decimal(10,0) NOT NULL,
  PRIMARY KEY (`building_id`),
  UNIQUE KEY `building_name` (`building_name`),
  KEY `building_id` (`building_id`),
  KEY `building_name_2` (`building_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`building_id`, `building_name`, `internet`, `water`, `trash`, `electric`, `gas`, `total_util`, `total_sqft`, `base_rent`, `renter_insurance`) VALUES
(1, 'Cutlas Corp', 40, 20, 15, 25, 10, 0, 500, 350, 75),
(2, 'New Building', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 'Some New Building', 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `building_id` int(11) NOT NULL,
  `room_sqft` decimal(10,0) NOT NULL,
  `room_number` varchar(10) NOT NULL,
  `total_room_rent` decimal(10,0) NOT NULL,
  PRIMARY KEY (`room_id`),
  UNIQUE KEY `room_id` (`room_id`),
  KEY `building_id` (`building_id`),
  KEY `building_id_2` (`building_id`),
  KEY `building_id_3` (`building_id`),
  KEY `building_name` (`building_id`),
  KEY `building_name_2` (`building_id`),
  KEY `building_id_4` (`building_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`room_id`, `building_id`, `room_sqft`, `room_number`, `total_room_rent`) VALUES
(1, 1, 20, '132', 700),
(3, 1, 20, '132', 700),
(4, 1, 25, '25F', 450);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `bio` varchar(300) DEFAULT NULL,
  `amount_owed` double(11,0) DEFAULT NULL,
  `expected_monthly_rate` double(11,0) DEFAULT NULL,
  `hobbies` varchar(200) DEFAULT NULL,
  `skills` varchar(200) DEFAULT NULL,
  `items` varchar(200) DEFAULT NULL,
  `permanent_address` varchar(50) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_2` (`username`),
  KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`, `first_name`, `last_name`, `bio`, `amount_owed`, `expected_monthly_rate`, `hobbies`, `skills`, `items`, `permanent_address`, `room_id`) VALUES
(1, 'test', 'password', 1, 'Alex', 'Kaidan', 'Some guy that is trying to get into programming. Loves anything fitness, electronics, flying, or challenging. ', 0, NULL, 'Games', 'Fitness, Nutrition, Sports, Electronics', 'Computer, Pots, Pans', '1446 Annandale Ct Ann Arbor, Mi 48108', 1),
(2, 'test2', 'password', 1, '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(23, 'user', 'user', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_costs`
--

CREATE TABLE IF NOT EXISTS `user_costs` (
  `renters_insurance` int(11) DEFAULT NULL,
  `utilities` int(11) DEFAULT NULL,
  `base_rent` int(11) DEFAULT NULL,
  `internet` int(11) DEFAULT NULL,
  `water` int(11) DEFAULT NULL,
  `trash` int(11) DEFAULT NULL,
  `electric` int(11) DEFAULT NULL,
  `gas` int(11) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_costs`
--

INSERT INTO `user_costs` (`renters_insurance`, `utilities`, `base_rent`, `internet`, `water`, `trash`, `electric`, `gas`, `username`) VALUES
(10, 20, 150, 25, 20, 45, 15, 20, 'test');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`building_id`) REFERENCES `building` (`building_id`) ON DELETE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
