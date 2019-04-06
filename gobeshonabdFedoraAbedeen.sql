-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 17, 2017 at 04:35 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gobeshonabd`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `article_id` int(11) NOT NULL,
  `article_subject` varchar(500) NOT NULL,
  `article_up_vote` int(11) DEFAULT NULL,
  `article_down_vote` int(11) DEFAULT NULL,
  `article_date` varchar(255) DEFAULT NULL,
  `article_content` varchar(50000) NOT NULL,
  `article_type` varchar(100) NOT NULL,
  `user_id_article_by_User` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`article_id`, `article_subject`, `article_up_vote`, `article_down_vote`, `article_date`, `article_content`, `article_type`, `user_id_article_by_User`) VALUES
(1, 'jhjkjhjk', 3, 4, '2017/06/17 00:35:03', 'nkjhkjhjk', 'jhjkhkh', 2),
(2, 'thesis', 0, 0, '2017/06/17 00:35:03', 'using mobile cloud in smart cities', 'Varsity work', 1),
(3, 'ssdfdsf', 0, 0, '2017/06/19 09:15:45', 'dsfdsfdf', 'sdfdsf', 1),
(4, 'test', 0, 0, '2017/06/19 09:15:45', 'test', 'test', 1),
(13, 'test green', 0, 0, '2017/06/19 16:00:56', 'test rtcile', 'tes', 5),
(14, 'sdfsdf', 0, 0, '2017/06/19 16:51:37', 'sdfsdfs', 'dfsdf', 5),
(15, 'sdfs', 0, 0, 'Article post Date', 'sdfsdfdf', 'sdfsdfsdf', 5),
(16, 'test', 0, 0, 'Article post Date', 'test', 'sdfsdf', 1),
(17, 'sdfsdf', 0, 0, '2017/06/20 09:50:54', 'sdfdsf', 'sdfdsf', 6),
(18, 'fsfds', 0, 0, '2017/06/20 09:50:54', 'sdfdsf', 'sfsdf', 6),
(19, 'fdsfsdffs', 0, 0, '2017/06/20 13:06:41', 'sdfsdf', 'sfsdf', 6),
(20, 'GSN Project of Final Year Student-Summer 2017', 0, 0, '2017/07/13 17:38:53', 'GSN is new dimension of social networking. It helps to share knowledge over the globe.', 'Social Networks', 7);

-- --------------------------------------------------------

--
-- Table structure for table `articles_comments`
--

CREATE TABLE `articles_comments` (
  `comment_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `comment_date` varchar(255) DEFAULT NULL,
  `comment_up_vote` int(11) DEFAULT NULL,
  `comment_down_vote` int(11) DEFAULT NULL,
  `comment_content` varchar(2000) NOT NULL,
  `article_id_comment` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles_comments`
--

INSERT INTO `articles_comments` (`comment_id`, `user_id`, `comment_date`, `comment_up_vote`, `comment_down_vote`, `comment_content`, `article_id_comment`) VALUES
(7, 2, '2017/06/18 05:05:09', 0, 0, 'test', 1),
(8, 2, '2017/06/18 05:05:09', 0, 0, 'test', 1),
(9, 1, '2017/06/18 07:04:29', 0, 0, 'test2', 1),
(10, 1, '2017/06/18 07:04:29', 0, 0, 'mycm', 2),
(11, 1, '2017/06/18 07:04:29', 0, 0, 'lklkl', 2),
(12, 1, '2017/06/18 07:04:29', 0, 0, 'flsjfkds', 2),
(13, 1, '2017/06/18 07:04:29', 0, 0, 'test', 2),
(14, 1, '2017/06/18 08:07:32', 0, 0, 'fsdf', 1),
(15, 1, '2017/06/18 08:07:32', 0, 0, 'jhjh', 1),
(16, 1, '2017/06/18 08:07:32', 0, 0, 'jhjh', 1),
(17, 1, '2017/06/19 16:54:24', 0, 0, 'hi', 16),
(18, 1, '2017/06/19 16:54:24', 0, 0, 'klsdfj', 16),
(19, 1, '2017/06/19 16:54:24', 0, 0, 'sdfdsf', 16),
(20, 1, '2017/06/19 16:54:24', 0, 0, 'sdfsdf', 16),
(21, 1, '2017/06/19 16:54:24', 0, 0, 'sfsdfsdf', 16),
(22, 1, '2017/06/20 00:53:28', 0, 0, 'kjk', 16),
(23, 1, '2017/06/20 00:53:28', 0, 0, 'kjk', 16),
(24, 1, '2017/06/20 00:53:28', 0, 0, 'l', 16),
(25, 1, '2017/06/20 00:53:28', 0, 0, 'jkjk', 16),
(26, 1, '2017/06/20 00:53:28', 0, 0, 'jkjk', 16),
(27, 1, '2017/06/20 00:53:28', 0, 0, 'sdfsd', 16),
(28, 1, '2017/06/20 00:53:28', 0, 0, 'fsdfds', 16),
(29, 1, '2017/06/20 00:53:28', 0, 0, 'test', 3),
(30, 1, '2017/06/20 00:53:28', 0, 0, 'jkhj', 2),
(31, 5, '2017/06/20 09:50:54', 0, 0, 'trtrt', 15),
(32, 1, '2017/07/17 09:52:45', 0, 0, 'na kahe bose achi', 20);

-- --------------------------------------------------------

--
-- Table structure for table `articles_comments_votes`
--

CREATE TABLE `articles_comments_votes` (
  `Articles_comments_votes_vote_id` int(11) NOT NULL,
  `vote_user_id` int(11) DEFAULT NULL,
  `vote_articles_comments_id` int(11) DEFAULT NULL,
  `vote_date` varchar(255) DEFAULT NULL,
  `vote_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles_comments_votes`
--

INSERT INTO `articles_comments_votes` (`Articles_comments_votes_vote_id`, `vote_user_id`, `vote_articles_comments_id`, `vote_date`, `vote_value`) VALUES
(1, 2, 7, 'hnjm,', 0),
(2, 3, 7, 'sdf', 0);

-- --------------------------------------------------------

--
-- Table structure for table `articles_votes`
--

CREATE TABLE `articles_votes` (
  `articles_vote_id` int(11) NOT NULL,
  `vote_user_id` int(11) DEFAULT NULL,
  `vote_article_id` int(11) DEFAULT NULL,
  `vote_date` varchar(255) DEFAULT NULL,
  `vote_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles_votes`
--

INSERT INTO `articles_votes` (`articles_vote_id`, `vote_user_id`, `vote_article_id`, `vote_date`, `vote_value`) VALUES
(2, 1, 1, 'Mon Jul 17 12:19:47 BDT 2017', 1),
(3, 1, 1, 'Mon Jul 17 12:23:43 BDT 2017', 1),
(4, 1, 1, 'Mon Jul 17 12:23:43 BDT 2017', 1),
(5, 1, 1, 'Mon Jul 17 12:30:41 BDT 2017', -1),
(6, 1, 1, 'Mon Jul 17 16:16:20 BDT 2017', -1);

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL,
  `message_date` varchar(255) DEFAULT NULL,
  `message_sender_id` int(11) NOT NULL,
  `message_receiver_id` int(11) NOT NULL,
  `message` varchar(5000) NOT NULL,
  `read_status` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`message_id`, `message_date`, `message_sender_id`, `message_receiver_id`, `message`, `read_status`, `subject`) VALUES
(1, '2017/06/21 10:21:17', 5, 1, 'sfdsdfdsf', 0, 'subject'),
(2, '2017/06/21 16:25:14', 5, 1, 'fsdfsdf', 0, 'subject'),
(3, '2017/07/03 10:57:55', 5, 1, 'test message', 1, 'subject'),
(4, '2017/07/03 10:57:55', 6, 5, 'petis...', 1, 'subject'),
(5, '2017/07/17 10:16:15', 1, 2, 'hi', 0, 'heoo');

-- --------------------------------------------------------

--
-- Table structure for table `message_block`
--

CREATE TABLE `message_block` (
  `message_block_id` int(11) NOT NULL,
  `user_who_will_block` int(11) DEFAULT NULL,
  `user_who_will_be_blocked` int(11) DEFAULT NULL,
  `date_of_block` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `message_exception`
--

CREATE TABLE `message_exception` (
  `message_exception_id` int(11) NOT NULL,
  `user_who_will_make_exception` int(11) DEFAULT NULL,
  `user_who_will_be_made_exception` int(11) DEFAULT NULL,
  `date_making_exception` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question_and_answer`
--

CREATE TABLE `question_and_answer` (
  `question_id` int(11) NOT NULL,
  `question_date` varchar(255) DEFAULT NULL,
  `quesion_up_Vote` int(11) DEFAULT NULL,
  `quesion_down_vote` int(11) DEFAULT NULL,
  `question` varchar(500) NOT NULL,
  `question_description` varchar(5000) NOT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  `userid_question_asked_byuser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question_and_answer`
--

INSERT INTO `question_and_answer` (`question_id`, `question_date`, `quesion_up_Vote`, `quesion_down_vote`, `question`, `question_description`, `answer_id`, `question_type`, `userid_question_asked_byuser`) VALUES
(1, '2017/06/17 00:35:03', 0, 0, 'ihkkjhkj', 'knklnknkln', 0, 'kjkjkjnkj', 2),
(11, '2017/06/19 09:15:45', 0, 0, 'sdfdsf', 'sdfdsf', 0, 'sdfsdf', 1),
(12, '2017/06/19 09:15:45', 0, 0, 'dsfdf', 'sdfsdf', 0, 'sdfsdf', 1),
(13, '2017/06/19 09:15:45', 0, 0, 'sdf', 'sdfs', 0, 'sdf', 1),
(14, '2017/06/19 09:15:45', 0, 0, 'sdf', 'sdfdf', 0, 'sdfsdf', 1),
(15, '2017/06/19 09:15:45', 0, 0, 'sdfdsf', 'sdfsdf', 0, 'sdfdsf', 1),
(16, '2017/06/19 09:15:45', 0, 0, 'fsdfsdf', 'sdfsdfds', 0, 'sdfsdf', 1),
(17, '2017/06/20 09:50:54', 0, 0, 'sdfsdfs', 'dfsdfsd', 0, 'fsdf', 6),
(18, '2017/06/20 09:50:54', 0, 0, 'sfdfs', 'sdfsdf', 0, 'sdfdsf', 6),
(19, '2017/06/20 09:50:54', 0, 0, 'sfdfs', 'sdfsdf', 0, 'sdfdsf', 6),
(20, '2017/06/20 13:06:41', 0, 0, 'sdfsdf', 'sdfsdf', 0, 'sdfsdf', 6);

-- --------------------------------------------------------

--
-- Table structure for table `question_and_answer_comment`
--

CREATE TABLE `question_and_answer_comment` (
  `question_comment_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `question_comment_date` varchar(255) DEFAULT NULL,
  `question_comment_up_vote` int(11) DEFAULT NULL,
  `question_comment_down_vote` int(11) DEFAULT NULL,
  `question_comment_content` varchar(5000) NOT NULL,
  `is_it_answer` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question_and_answer_comment`
--

INSERT INTO `question_and_answer_comment` (`question_comment_id`, `user_id`, `question_comment_date`, `question_comment_up_vote`, `question_comment_down_vote`, `question_comment_content`, `is_it_answer`, `question_id`) VALUES
(1, 2, '2017/06/18 05:05:09', 0, 0, 'test', 0, 1),
(2, 2, '2017/06/18 05:05:09', 0, 0, 'test', 0, 1),
(3, 2, '2017/06/18 05:05:09', 0, 0, 'asdasda', 0, 1),
(4, 2, '2017/06/18 05:05:09', 0, 0, 'test', 0, 1),
(5, 2, '2017/06/18 05:05:09', 0, 0, 'test', 0, 1),
(6, 1, '2017/06/18 07:04:29', 0, 0, 'test', 0, 1),
(7, 1, '2017/06/18 07:04:29', 0, 0, 'test4', 0, 1),
(8, 1, '2017/06/18 07:04:29', 0, 0, 'test4', 0, 1),
(9, 1, '2017/06/18 07:04:29', 0, 0, 'test 5', 0, 1),
(10, 1, '2017/06/18 07:04:29', 0, 0, 'test6', 0, 1),
(11, 1, '2017/06/18 07:04:29', 0, 0, 'test 8', 0, 1),
(12, 1, '2017/06/18 07:04:29', 0, 0, 'jhj', 0, 1),
(13, 1, '2017/06/18 07:04:29', 0, 0, 'hello', 0, 1),
(14, 1, '2017/06/18 07:04:29', 0, 0, 'hello', 0, 1),
(15, 1, '2017/06/18 08:07:32', 0, 0, 'sdfdsfsdf', 0, 1),
(16, 1, '2017/06/18 08:07:32', 0, 0, 'ljk', 0, 1),
(17, 1, '2017/06/20 00:53:28', 0, 0, 'sfsfdfds', 0, 15),
(18, 1, '2017/06/20 00:53:28', 0, 0, 'sdfdf', 0, 15);

-- --------------------------------------------------------

--
-- Table structure for table `question_and_answer_votes`
--

CREATE TABLE `question_and_answer_votes` (
  `question_and_answer_vote_id` int(11) NOT NULL,
  `vote_user_id` int(11) DEFAULT NULL,
  `vote_auestion_and_answer_id` int(11) DEFAULT NULL,
  `vote_date` varchar(255) DEFAULT NULL,
  `vote_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question_and_qnswer_comment_votes`
--

CREATE TABLE `question_and_qnswer_comment_votes` (
  `question_and_answer_comment_vote_id` int(11) NOT NULL,
  `vote_user_id` int(11) DEFAULT NULL,
  `vote_question_and_answer_comment_id` int(11) DEFAULT NULL,
  `vote_date` varchar(255) DEFAULT NULL,
  `vote_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `password` varchar(500) DEFAULT NULL,
  `user_first_name` varchar(500) DEFAULT NULL,
  `user_last_name` varchar(500) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `address` varchar(5000) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `educational_qualification` varchar(500) DEFAULT NULL,
  `interested_fields` varchar(1000) DEFAULT NULL,
  `currently_working` varchar(1000) DEFAULT NULL,
  `occupation` varchar(200) DEFAULT NULL,
  `contact_info` varchar(200) DEFAULT NULL,
  `join_date` varchar(255) DEFAULT NULL,
  `religious_view` varchar(100) DEFAULT NULL,
  `nationality` varchar(100) DEFAULT NULL,
  `expriences` varchar(10000) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `communication_interest` int(11) DEFAULT NULL,
  `total_articles` int(11) DEFAULT NULL,
  `total_questions` int(11) DEFAULT NULL,
  `total_answered` int(11) DEFAULT NULL,
  `total_posts` int(11) DEFAULT NULL,
  `total_up_vote` float DEFAULT NULL,
  `total_down_vote` float DEFAULT NULL,
  `total_vote` float DEFAULT NULL,
  `profile_weight` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `password`, `user_first_name`, `user_last_name`, `date_of_birth`, `address`, `gender`, `educational_qualification`, `interested_fields`, `currently_working`, `occupation`, `contact_info`, `join_date`, `religious_view`, `nationality`, `expriences`, `skills`, `enabled`, `communication_interest`, `total_articles`, `total_questions`, `total_answered`, `total_posts`, `total_up_vote`, `total_down_vote`, `total_vote`, `profile_weight`) VALUES
(1, 'testuser', '123456', 'Ajharul', 'Abedin', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Interested Fields', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/17 00:35:03', 'Religious View', 'Nationality', 'Expriences', ' Skills ', 1, 0, 0, 0, 0, 0, 2, 2, 6, 0.333333),
(2, 'tfaisal@gmail.com', '22222222', 'jhon', 'doe', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Interested Fields', 'Currently Working', 'Occupation', 'Contact Info', 'Date of Join', 'Religious View', 'Nationality', 'Expriences', ' Skills ', 1, 0, 0, 0, 0, 0, 1, 0, 1, 1),
(3, 'f@gmail.com', '123456', 'Please Enter first Name', 'Please Enter last Name', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Interested Fields', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/19 14:56:40', 'Religious View', 'Nationality', 'Expriences', ' Skills ', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 'g@gmail.com', '123456', 'Abedeen', 'Khan', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Interested Fields', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/19 14:56:40', 'Religious View', 'Nationality', 'Expriences', ' Skills ', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 'green', '123456', 'green', 'khan', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Interested Fields', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/19 16:00:56', 'Religious View', 'Nationality', 'Expriences', ' Skills ', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 'gub', '123456', 'gub', 'cse', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Interested Fields', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/20 09:50:54', 'Religious View', 'Nationality', 'Expriences', ' Skills ', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, 'biplabcse', '12345', 'Please Enter first Name', 'Please Enter last Name', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Interested Fields', 'Currently Working', 'Occupation', 'Contact Info', '2017/07/13 17:38:53', 'Religious View', 'Nationality', 'Expriences', ' Skills ', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(8, 'biplabptk', '12345', 'Please Enter first Name', 'Please Enter last Name', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Interested Fields', 'Currently Working', 'Occupation', 'Contact Info', '2017/07/13 17:38:53', 'Religious View', 'Nationality', 'Expriences', ' Skills ', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_role_id` int(11) NOT NULL,
  `emailID` varchar(200) DEFAULT NULL,
  `role` varchar(200) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_role_id`, `emailID`, `role`, `username`) VALUES
(1, NULL, 'ADMIN', 'f@gmail.com'),
(2, NULL, 'ADMIN', 'g@gmail.com'),
(3, NULL, 'ADMIN', 'green'),
(4, NULL, 'ADMIN', 'gub'),
(5, NULL, 'ADMIN', 'biplabcse'),
(6, NULL, 'ADMIN', 'biplabptk');

-- --------------------------------------------------------

--
-- Table structure for table `users_security`
--

CREATE TABLE `users_security` (
  `username` varchar(255) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_security`
--

INSERT INTO `users_security` (`username`, `password`, `enabled`) VALUES
('biplabcse', '12345', 1),
('biplabptk', '12345', 1),
('f@gmail.com', '123456', 1),
('g@gmail.com', '123456', 1),
('green', '123456', 1),
('gub', '123456', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`article_id`);

--
-- Indexes for table `articles_comments`
--
ALTER TABLE `articles_comments`
  ADD PRIMARY KEY (`comment_id`);

--
-- Indexes for table `articles_comments_votes`
--
ALTER TABLE `articles_comments_votes`
  ADD PRIMARY KEY (`Articles_comments_votes_vote_id`);

--
-- Indexes for table `articles_votes`
--
ALTER TABLE `articles_votes`
  ADD PRIMARY KEY (`articles_vote_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`message_id`);

--
-- Indexes for table `message_block`
--
ALTER TABLE `message_block`
  ADD PRIMARY KEY (`message_block_id`);

--
-- Indexes for table `message_exception`
--
ALTER TABLE `message_exception`
  ADD PRIMARY KEY (`message_exception_id`);

--
-- Indexes for table `question_and_answer`
--
ALTER TABLE `question_and_answer`
  ADD PRIMARY KEY (`question_id`);

--
-- Indexes for table `question_and_answer_comment`
--
ALTER TABLE `question_and_answer_comment`
  ADD PRIMARY KEY (`question_comment_id`);

--
-- Indexes for table `question_and_answer_votes`
--
ALTER TABLE `question_and_answer_votes`
  ADD PRIMARY KEY (`question_and_answer_vote_id`);

--
-- Indexes for table `question_and_qnswer_comment_votes`
--
ALTER TABLE `question_and_qnswer_comment_votes`
  ADD PRIMARY KEY (`question_and_answer_comment_vote_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`user_role_id`);

--
-- Indexes for table `users_security`
--
ALTER TABLE `users_security`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
