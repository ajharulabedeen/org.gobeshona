-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2017 at 08:56 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

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
  `article_content` varchar(20000) NOT NULL,
  `article_type` varchar(100) NOT NULL,
  `user_id_article_by_User` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`article_id`, `article_subject`, `article_up_vote`, `article_down_vote`, `article_date`, `article_content`, `article_type`, `user_id_article_by_User`) VALUES
(9, 'artcle', 4, 3, 'Article post Date', 'a', 'a', 1),
(10, 'test green', 0, 0, '2017/06/20 00:24:49', 'asdsd', 'asda', 1),
(11, 'Article (grammar)', 0, 0, 'Article post Date', 'From Wikipedia, the free encyclopedia\nFor grammatical articles in English, see English articles.\n"Definite article" redirects here. For the Eddie Izzard comedy DVD, see Definite Article.\n\nThis article needs additional citations for verification. Please help improve this article by adding citations to reliable sources. Unsourced material may be challenged and removed. (July 2008) (Learn how and when to remove this template message)\nAn article (with the linguistic glossing abbreviation art) is a word that is used alongside a noun (as a standalone word or a prefix or suffix) to specify grammatical definiteness of the noun, and in some languages extending to volume or numerical scope.\n\nThe articles in English grammar are the and a/an, and in certain contexts some. "An" and "a" are modern forms of the Old English "an", which in Anglian dialects was the number "one" (compare "on" in Saxon dialects) and survived into Modern Scots as the number "owan". Both "on" (respelled "one" by the Norman language) and "an" survived into Modern English, with "one" used as the number and "an" ("a", before nouns that begin with a consonant sound) as an indefinite article.\n\nIn many languages, articles are a special part of speech which cannot easily be combined[clarification needed] with other parts of speech. In English grammar, articles are frequently considered part of a broader category called determiners, which contains both articles and demonstratives (such as "this" and "that").\n\nIn languages that employ articles, every common noun, with some exceptions, is expressed with a certain definiteness, definite or indefinite, as an attribute (similar to how many languages express every noun with a certain grammatical number—singular or plural—or a grammatical gender). Every noun must be accompanied by the article corresponding to its definiteness, and the lack of an article (considered a zero article) itself specifies a certain definiteness. This is in contrast to other determiners and adjectives, which are typically optional. This obligatory nature of articles makes them among the most common words in many languages; in English, for example, the most frequent word is the.[1]\n\nArticles are usually categorized as either definite or indefinite.[2] A few languages with well-developed systems of articles may distinguish additional subtypes. Within each type, languages may have various forms of each article, due to confirming to grammatical attributes such as gender, number, or case, or else modified as influenced by adjacent sounds as in elision (e.g., French "le" becoming "l''" before a vowel) or epenthesis (e.g., English "a" becoming "an" before a vowel).', 'test', 2),
(12, 'Incremental build model', 0, 0, '2017/07/03 20:19:10', 'A The incremental build model is a method of software development where the product is designed, implemented and tested incrementally (a little more is added each time) until the product is finished. It involves both development and maintenance. The product is defined as finished when it satisfies all of its requirements. This model combines the elements of the waterfall model with the iterative philosophy of prototyping.\n\nThe product is decomposed into a number of components, each of which is designed and built separately (termed as builds). Each component is delivered to the client when it is complete. This allows partial utilization of the product and avoids a long development time. It also avoids a large initial capital outlay and subsequent long waiting period. This model of development also helps ease the traumatic effect of introducing a completely new system all at once. There are, however, several problems with this model.\n\nIncremental model[edit]\nThe incremental model applies the waterfall model incrementally.[1]\n\nThe series of releases is referred to as “increments”, with each increment providing more functionality to the customers. After the first increment, a core product is delivered, which can already be used by the customer. Based on customer feedback, a plan is developed for the next increments, and modifications are made accordingly. This process continues, with increments being delivered until the complete product is delivered. The incremental philosophy is also used in the agile process model (see agile modeling).[1]\n\nThe Incremental model can be applied to DevOps. In DevOps it centers around the idea of minimizing risk and cost of a DevOps adoption whilst building the necessary in-house skillset and momentum.[2]\n\nCharacteristics of Incremental Model\n\nSystem is broken down into many mini development projects.\nPartial systems are built to produce the final system.\nFirst tackled highest priority requirements.\nThe requirement of a portion is frozen once the incremented portion is developed.\nAdvantages[3][4]\n\nAfter each iteration, regression testing should be conducted. During this testing, faulty elements of the software can be quickly identified because few changes are made within any single iteration.\nIt is generally easier to test and debug than other methods of software development because relatively smaller changes are made during each iteration. This allows for more targeted and rigorous testing of each element within the overall product.\nCustomer can respond to features and review the product for any needed or useful changes.\nInitial product delivery is faster and costs less.\nDisadvantages[5]\n\nResulting cost may exceed the cost of the organization.\nAs additional functionality is added to the product, problems may arise related to system architecture which were not evident in earlier prototypes.', 'Software Enginering', 2),
(13, 'বাংলাদেশ', 0, 0, '2017/07/03 20:19:10', 'বাংলাদেশ (এই শব্দ সম্পর্কে শুনুন (সাহায্য·তথ্য)) দক্ষিণ এশিয়ার একটি জনবহুল রাষ্ট্র। বাংলাদেশের সাংবিধানিক নাম গণপ্রজাতন্ত্রী বাংলাদেশ। ভূ-রাজনৈতিক ভাবে বাংলাদেশের পশ্চিম, উত্তর ও পূর্ব সীমান্তে ভারত, দক্ষিণ-পূর্ব সীমান্তে মায়ানমার ও দক্ষিণ উপকূলের দিকে বঙ্গোপসাগর অবস্থিত।[৭] বাংলাদেশের ভূখণ্ড ভৌগোলিকভাবে একটি উর্বর ব-দ্বীপের অংশ বিশেষ। পার্শ্ববর্তী দেশের রাজ্য পশ্চিমবঙ্গ ও ত্রিপুরা-সহ বাংলাদেশ একটি ভৌগোলিকভাবে জাতিগত ও ভাষাগত "বঙ্গ" অঞ্চলটির মানে পূর্ণ করে। "বঙ্গ" ভূখণ্ডের পূর্বাংশ পূর্ব বাংলা নামে পরিচিত ছিল, যা ১৯৭১ খ্রিস্টাব্দে বাংলাদেশ নামে স্বাধীন ও সার্বভৌম দেশ হিসেবে প্রতিষ্ঠা লাভ করে। পৃথিবীতে যে ক''টি রাষ্ট্র জাতিরাষ্ট্র হিসেবে মর্যাদা পায় তার মধ্যে বাংলাদেশ অন্যতম।\n\nবাংলাদেশের বর্তমান সীমান্ত তৈরি হয়েছিল ১৯৪৭ খ্রিস্টাব্দে যখন ব্রিটিশ ঔপনিবেশিক শাসনাবসানে, বঙ্গ (বেঙ্গল প্রেসিডেন্সি) এবং ব্রিটিশ ভারত বিভাজন করা হয়েছিল। বিভাজনের পরে বর্তমান বাংলাদেশের অঞ্চল তখন পূর্ব বাংলা নামে পরিচিত ছিল, যেটি নবগঠিত দেশ পাকিস্তানের পূর্ব অঞ্চল হিসেবে প্রতিষ্ঠিত করা হয়েছিল। পাকিস্তান অধিরাজ্যে থাকাকালীন ‘পূর্ব বাংলা’ থেকে ‘পূর্ব পাকিস্তান’-এ নামটি পরিবর্তিত করা হয়েছিল। শোষণ, বৈষম্য ও নিপীড়নের বিরুদ্ধে সশস্ত্র সংগ্রামের মধ্য দিয়ে ১৯৭১ খ্রিস্টাব্দে বাংলাদেশ একটি স্বাধীন ও সার্বভৌম দেশ হিসাবে প্রতিষ্ঠিত হয়। স্বাধীনতা পরবর্তী সময়ে দারিদ্র্যপীড়িত বাংলাদেশে বিভিন্ন সময় ঘটেছে দুর্ভিক্ষ ও প্রাকৃতিক দুর্যোগ; এছাড়াও প্রলম্বিত রাজনৈতিক অস্থিতিশীলতা ও পুনঃপৌনিক সামরিক অভ্যুত্থান এদেশের সামগ্রিক রাজনৈতিক স্থিতিশীলতা বারংবার ব্যাহত করেছে। গণসংগ্রামের মধ্য দিয়ে ১৯৯১ খ্রিস্টাব্দে গণতান্ত্রিক শাসনব্যবস্থা পুনঃপ্রতিষ্ঠিত হয়েছে যার ধারাবাহিকতা আজ পর্যন্ত। সকল প্রতিকূলতা সত্ত্বেও গত দুই দশকে বাংলাদেশের অর্থনৈতিক প্রগতি ও সমৃদ্ধি সারা বিশ্বে স্বীকৃতি লাভ করেছে।\n\nবিশ্বের সবচেয়ে জনবহুল দেশগুলোর তালিকায় বাংলাদেশের অবস্থান অষ্টম যদিও আয়তনের হিসেবে বাংলাদেশ বিশ্বে ৯৪তম; ফলে বাংলাদেশ বিশ্বের সবচেয়ে ঘনবসতিপূর্ণ দেশগুলোর নবম। মাত্র ৫৬ হাজার বর্গমাইলেরও কম এই ক্ষুদ্রায়তনের দেশটির বর্তমান জনসংখ্যা ১৫.৫৯ কোটির বেশি অর্থাৎ প্রতি বর্গমাইলে জনবসতি ২৪৯৭ জন। [৮]\n\nজনসংখ্যার ৯৮ শতাংশ মানুষের মাতৃভাষা বাংলা; শিক্ষার হার ৬৫ শতাংশ। ২০১২-১৩ অর্থবছরে বাংলাদেশের মোট দেশজ উৎপাদনের (জিডিপি) পরিমাণ ছিল ১১,৯৮,৯২৩ কোটি টাকা (চলতি বাজারমূল্যে) যা ২০১৩-১৪ অর্থবছরে বৃদ্ধি লাভ করে ১৩,৫০,৯২০ কোটি টাকায় উন্নীত হয়। একই সঙ্গে জনগণের মাথাপিছু বার্ষিক আয় পূর্ববর্তী বৎসরের ১,০৪৪ মার্কিন ডলার থেকে বৃদ্ধি পেয়ে ২০১৩-১৪ অর্থবছরে ১,১৯০ মার্কিন ডলারে উন্নীত হয়েছে মর্মে সরকারি প্রাক্কলন করা হয়েছে, টাকার অঙ্কে যার পরিমাণ ৯২,৫১০ টাকা।[৯] দারিদ্রের হার ২৬.২০ শতাংশ, অতিদরিদ্র মানুষের সংখ্যা ১১.৯০ শতাংশ, এবং বার্ষিক দারিদ্র হ্রাসের হার ১.৫ শতাংশ। এই উন্নয়নশীল দেশটি প্রায় দুই দশক যাবৎ বার্ষিক ৫ থেকে ৬.২ শতাংশ হারে অর্থনৈতিক প্রবৃদ্ধির অর্জনপূর্বক "পরবর্তী একাদশ" অর্থনীতিসমূহের তালিকায় স্থান করে নিয়েছে। রাজধানী ঢাকা ও অন্যান্য শহরের পরিবর্ধন বাংলাদেশের এই উন্নতির চালিকাশক্তিরূপে কাজ করছে। এর কেন্দ্রবিন্দুতে কাজ করেছে একটি উচ্চাকাঙ্ক্ষী মধ্যবিত্ত শ্রেণীর ত্বরিত বিকাশ এবং একটি সক্ষম ও সক্রিয় উদ্যোক্তা শ্রেণীর আর্বিভাব। বাংলাদেশের রপ্তানীমুখী তৈরি পোশাক শিল্প সারা বিশ্বে বিশেষভাবে প্রসিদ্ধ। জনশক্তি রপ্তানীও দেশটির অন্যতম অর্থনৈতিক স্তম্ভ।\n\nগঙ্গা-ব্রহ্মপুত্রের উর্বর অববাহিকায় অবস্থিত এই দেশটিতে প্রায় প্রতি বছর মৌসুমী বন্যা হয়; আর ঘূর্ণিঝড়ও খুব সাধারণ ঘটনা। নিম্ন আয়ের এই দেশটির প্রধান সমস্যা পরিব্যাপ্ত দারিদ্র গত দুই দশকে অনেকাংশে নিয়ন্ত্রণে এসেছে সাক্ষরতার হার বৃদ্ধি পেয়েছে দ্রুত, জন্ম নিয়ন্ত্রণ কার্যক্রমে অর্জিত হয়েছে অভূতপূর্ব সফলতা। এছাড়া আন্তর্জাতিক মানব সম্পদ উন্নয়ন সূচকে বাংলাদেশ দৃষ্টান্তমূলক অগ্রগতি অর্জনে সক্ষম হয়েছে।[১০], তবে বাংলাদেশে এখনো বেশ কিছু গুরুত্বপূর্ণ চ্যালেঞ্জ মোকাবেলা করছে যার মধ্যে রয়েছে পরিব্যাপ্ত রাজনৈতিক ও প্রশাসনিক দুর্নীতি, বিশ্বায়নের প্রেক্ষাপটে অর্থনৈতিক প্রতিযোগিতা এবং জলবায়ু পরিবর্তনের ফলে সমুদ্রতলের উচ্চতা বৃদ্ধির ফলশ্রুতিতে তলিয়ে যাবার শঙ্কা। এছাড়া একটি সর্বগ্রহণযোগ্য নির্বাচন ব্যবস্থার রূপ নিয়ে নতুন ভাবে সামাজিক বিভাজনের সৃষ্টি হয়েছে।\n\nবাংলাদেশে সংসদীয় গণতান্ত্রিক সরকার ব্যবস্থা প্রচলিত। বাংলাদেশ দক্ষিণ এশীয় আঞ্চলিক সহযোগিতা সংস্থা ও বিমসটেক-এর প্রতিষ্ঠাতা সদস্য। এছাড়া দেশটি জাতিসংঘ, বিশ্ব বাণিজ্য সংস্থা, বিশ্ব শুল্ক সংস্থা, কমনওয়েলথ অফ নেশনস, উন্নয়নশীল ৮টি দেশ, জোট-নিরপেক্ষ আন্দোলন, ওআইসি, ইত্যাদি আন্তর্জাতিক সংঘের সক্রিয় সদস্য।', 'বাংলাদেশ', 2),
(14, 'বাংলাদেশের জাতীয় প্রতীক', 0, 0, '2017/07/03 20:19:10', 'বাংলাদেশ এর জাতীয় প্রতীক গ্রহণ করা হয় ১৯৭১ সালে, স্বাধীনতার অব্যবহিত পরে। বাংলাদেশের জাতীয় প্রতীকের কেন্দ্রে রয়েছে পানিতে ভাসমান একটি শাপলা ফুল যা বাংলাদেশের জাতীয় ফুল। শাপলা ফুলটিকে বেষ্টন করে আছে ধানের দুটি শীষ। চূড়ায় পাটগাছের পরস্পরযুক্ত তিনটি পাতা এবং পাতার উভয় পার্শ্বে দুটি করে মোট চারটি তারকা। চারটি তারকা চিহ্ন দ্বারা বাংলাদেশের সংবিধানের চারটি মূলনীতিকে নির্দেশ করা হয়েছে। পানি, ধান ও পাট প্রতীকে বৈশিষ্ট্যমণ্ডিত হয়েছে বাংলাদেশের নিসর্গ ও অর্থনীতি। এ তিনটি উপাদানের উপর স্থাপিত জলজ প্রস্ফুটিত শাপলা হলো অঙ্গীকার, সৌন্দর্য ও সুরুচির প্রতীক। তারকাগুলোতে ব্যক্ত হয়েছে জাতির লক্ষ্য ও উচ্চাকাঙ্ক্ষা। [১]', 'জাতীয় প্রতীক', 2),
(15, 'বাংলাদেশের জাতীয় পতাকা', 0, 0, '2017/07/03 20:19:10', 'বাংলাদেশের জাতীয় পতাকা সবুজ আয়তক্ষেত্রের মধ্যে লাল বৃত্ত। সবুজ রং বাংলাদেশের সবুজ প্রকৃতি ও তারুণ্যের প্রতীক, বৃত্তের লাল রং উদীয়মান সূর্য, স্বাধীনতা যুদ্ধে আত্মোৎসর্গকারীদের রক্তের প্রতীক। বাংলাদেশের জাতীয় পতাকার এই রূপটি ১৯৭২ সালের ১৭ জানুয়ারি সরকারীভাবে গৃহীত হয়।\n\n১৯৭১ সালে বাংলাদেশের স্বাধীনতা যুদ্ধের সময় প্রায় একই রকম দেখতে একটি পতাকা ব্যবহার করা হতো, যেখানে মাঝের লাল বৃত্তের ভেতর হলুদ রংয়ের একটি মানচিত্র ছিল। ১২ জানুয়ারি, ১৯৭২ তারিখে বাংলাদেশের পতাকা থেকে মানচিত্রটি সরিয়ে ফেলা হয়।[১] পতাকার উভয় পাশে সঠিকভাবে মানচিত্রটি ফুটিয়ে তোলার অসুবিধা পতাকা থেকে মানচিত্রটি সরিয়ে ফেলার অন্যতম কারণ।[২]', 'বাংলা', 2);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articles_comments`
--

INSERT INTO `articles_comments` (`comment_id`, `user_id`, `comment_date`, `comment_up_vote`, `comment_down_vote`, `comment_content`, `article_id_comment`) VALUES
(1, 1, '2017/06/18 15:53:39', 6, 0, 'rtetet', 3),
(2, 1, '2017/06/19 00:52:46', 0, 0, 'test', 1),
(3, 1, '2017/06/19 00:52:46', 0, 0, 'test', 1),
(4, 1, '2017/06/19 00:52:46', 0, 0, 'test', 1),
(5, 1, '2017/06/19 00:52:46', 0, 0, 'test', 1),
(6, 1, '2017/06/19 00:52:46', 0, 0, 'sdfsdf', 4),
(7, 1, '2017/06/19 00:52:46', 0, 0, 'sdfsdf', 4),
(8, 1, '2017/06/19 16:48:13', 0, 0, 'gjjhgjhbjh', 0),
(9, 1, '2017/06/19 17:19:54', 0, 0, 'asda', 7),
(10, 1, '2017/06/19 17:19:54', 0, 0, 'asda', 7),
(11, 1, '2017/06/19 17:19:54', 0, 0, 'asda', 7),
(12, 1, '2017/06/19 17:19:54', 0, 0, 'asda', 7),
(13, 1, '2017/06/19 17:19:54', 0, 0, 'asda', 7),
(14, 1, '2017/06/19 17:19:54', 0, 0, 'asda', 7),
(15, 1, '2017/06/19 17:19:54', 0, 0, 'asda', 7),
(16, 1, '2017/06/19 18:52:20', 0, 0, 'zxcz', 9),
(17, 1, '2017/06/19 18:52:20', 0, 0, 'zxcz', 9),
(18, 1, '2017/06/19 18:52:20', 0, 0, 'zxcz', 9),
(19, 1, '2017/06/19 18:52:20', 0, 0, 'zxcz', 9),
(20, 1, '2017/06/19 18:52:20', 0, 0, 'zxcz', 9),
(21, 1, '2017/06/19 18:52:20', 0, 0, 'op', 9),
(22, 2, '2017/06/19 18:52:20', 0, 0, 'opioio', 9),
(23, 2, '2017/06/19 18:52:20', 0, 0, 'rr', 9),
(24, 1, '2017/06/20 00:33:18', 0, 0, 'juth', 3),
(25, 1, '2017/06/20 00:33:18', 0, 0, 'juth', 3),
(26, 1, '2017/06/20 00:33:18', 0, 0, 'sdfsd', 3),
(27, 0, '2017/06/20 00:33:18', 0, 0, 'commet to art 1', 1),
(28, 1, '2017/06/20 01:05:40', 0, 0, 'dfd', 10),
(29, 1, '2017/06/20 01:05:40', 0, 0, 'sdf', 10),
(30, 2, '2017/07/03 20:19:10', 0, 0, 'What is main crop of Bangladesh', 13),
(31, 2, '2017/07/03 20:19:10', 0, 0, 'R u with commonwealth country', 13),
(32, 1, '2017/07/15 09:50:05', 0, 0, 'Test', 1),
(33, 1, '2017/07/16 08:03:12', 0, 0, 'test Comment : why u not give the details, why only give a character', 9),
(34, 1, '2017/07/16 08:03:12', 0, 0, 'test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character', 9),
(35, 1, '2017/07/16 18:14:22', 0, 0, 'est Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character est Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character test Comment : why u not give the details, why only give a character', 9),
(36, 1, '2017/07/16 18:14:22', 0, 0, 'select  *from article', 9),
(37, 1, '2017/07/16 18:14:22', 0, 0, 'PostgreSQL is one of the most popular relational databases, and Hibernate is probably the most popular JPA implementation. So, it’s no surprise that they’re often used together and that you don’t have to expect any major issues doing that.  But as so often, there is a difference between “it works” and “it works great”. Out of the box, Hibernate and PostgreSQL work well together. But if you want to use both systems to it’s fullest extent, you need to know a few things and avoid some others.  Here is my list of the 5 most important things you should know when you want to use Hibernate with PostgreSQL.', 9);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articles_comments_votes`
--

INSERT INTO `articles_comments_votes` (`Articles_comments_votes_vote_id`, `vote_user_id`, `vote_articles_comments_id`, `vote_date`, `vote_value`) VALUES
(1, 1, 37, 'sdf', 1),
(2, 2, 37, 'tet', 1),
(3, 1, 36, 'fg', -1);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articles_votes`
--

INSERT INTO `articles_votes` (`articles_vote_id`, `vote_user_id`, `vote_article_id`, `vote_date`, `vote_value`) VALUES
(1, 1, 1, '2017/06/21 07:28:09', 0),
(2, 1, 9, 'Mon Jul 17 22:39:32 BDT 2017', 1),
(3, 1, 9, 'Mon Jul 17 22:39:32 BDT 2017', 1),
(4, 1, 9, 'Mon Jul 17 22:39:32 BDT 2017', 1),
(5, 1, 9, 'Mon Jul 17 22:39:32 BDT 2017', 1),
(6, 1, 9, 'Mon Jul 17 22:39:32 BDT 2017', -1),
(7, 1, 9, 'Mon Jul 17 22:39:32 BDT 2017', -1),
(8, 1, 9, 'Mon Jul 17 22:39:32 BDT 2017', -1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `custid` int(11) NOT NULL,
  `custname` varchar(10) DEFAULT NULL,
  `forevenIdCustomer` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custid`, `custname`, `forevenIdCustomer`) VALUES
(407, 'customer4', 401),
(408, 'customer5', 401),
(409, 'customer6', 401);

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL,
  `message_date` varchar(255) DEFAULT NULL,
  `message_sender_id` int(11) DEFAULT NULL,
  `message_receiver_id` int(11) DEFAULT NULL,
  `message` varchar(5000) DEFAULT NULL,
  `read_status` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`message_id`, `message_date`, `message_sender_id`, `message_receiver_id`, `message`, `read_status`, `subject`) VALUES
(1, '2017/06/18 15:30:27', 3, 2, 'How are u', 1, 'test'),
(2, '2017/06/21 16:07:33', 3, 2, 'কেমন  আছো ', 1, 'test'),
(3, '2017/06/21 16:07:33', 3, 2, 'প্রজেক্ট এর কাজ কত দূর ', 1, 'test'),
(4, '2017/06/21 16:07:33', 3, 4, 'When u will come to univarsity', 0, 'test'),
(5, '2017/06/21 16:07:33', 3, 2, 'I am interested to work with u.', 1, 'test'),
(6, '2017/06/21 16:19:06', 4, 2, 'The name of our supervisor is very helpful .', 1, 'test'),
(7, '2017/06/21 16:19:06', 4, 2, 'আল্লাহু আকবার', 1, 'test'),
(8, '2017/07/02 20:11:08', 2, 1, 'Helloo..', 1, 'test'),
(9, '2017/07/02 20:11:08', 2, 6, 'Helloo..', 0, 'test'),
(10, '2017/07/02 20:38:16', 1, 2, 'Have u completed ur presentation', 1, 'test'),
(13, '2017/07/03 20:19:10', 2, 5, 'How are rupa', 1, 'test'),
(14, '2017/07/15 17:51:42', 4, 2, 'আল্লাহু আকবার', 0, 'test'),
(15, '2017/07/15 20:32:44', 2, 5, 'How r u rupa?', 1, 'Hello');

-- --------------------------------------------------------

--
-- Table structure for table `message_block`
--

CREATE TABLE `message_block` (
  `message_block_id` int(11) NOT NULL,
  `user_who_will_block` int(11) DEFAULT NULL,
  `user_who_will_be_blocked` int(11) DEFAULT NULL,
  `date_of_block` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message_block`
--

INSERT INTO `message_block` (`message_block_id`, `user_who_will_block`, `user_who_will_be_blocked`, `date_of_block`) VALUES
(2, 5, 4, '2017/06/19 03:40:22'),
(3, 2, 5, '2017/06/19 03:40:22'),
(4, 1, 1, '2017/07/20 10:16:10');

-- --------------------------------------------------------

--
-- Table structure for table `message_exception`
--

CREATE TABLE `message_exception` (
  `message_exception_id` int(11) NOT NULL,
  `user_who_will_make_exception` int(11) DEFAULT NULL,
  `user_who_will_be_made_exception` int(11) DEFAULT NULL,
  `date_making_exception` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message_exception`
--

INSERT INTO `message_exception` (`message_exception_id`, `user_who_will_make_exception`, `user_who_will_be_made_exception`, `date_making_exception`) VALUES
(1, 1, 2, '2017/06/19 08:55:06'),
(2, 1, 3, '2017/06/19 08:55:06'),
(3, 1, 4, '2017/06/19 08:55:06');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `pid` int(11) NOT NULL,
  `pname` varchar(10) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`pid`, `pname`, `price`, `CustomerID`, `enable`) VALUES
(1, 'p3', 300, 407, 1),
(2, 'p1', 100, 407, 1),
(3, 'p2', 200, 407, 1),
(4, 'Test', 1000, 408, NULL),
(5, 'Test', 1000, 407, NULL),
(6, 'Test2', 1000, 407, NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question_and_answer`
--

INSERT INTO `question_and_answer` (`question_id`, `question_date`, `quesion_up_Vote`, `quesion_down_vote`, `question`, `question_description`, `answer_id`, `question_type`, `userid_question_asked_byuser`) VALUES
(2, '2017/06/19 08:48:58', 0, 0, 'asdad', 'asdad', 0, 'asd', 1),
(3, '2017/06/19 16:57:30', 0, 0, ' Allahuakbar ', ' Question Description ', 0, 'ibadah', 2),
(4, '2017/06/19 18:52:20', 0, 0, 'test q', 'weweerwe', 0, 'werwr', 1),
(5, '2017/06/20 00:33:18', 0, 0, 'sdf', 'sdf', 0, 'sdf', 1),
(6, '2017/06/20 09:47:26', 0, 0, ' Allahuakbar ', ' Question Description ', 0, 'ibadah', 2);

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
  `question_comment_content` varchar(5000) DEFAULT NULL,
  `is_it_answer` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question_and_answer_comment`
--

INSERT INTO `question_and_answer_comment` (`question_comment_id`, `user_id`, `question_comment_date`, `question_comment_up_vote`, `question_comment_down_vote`, `question_comment_content`, `is_it_answer`, `question_id`) VALUES
(1, 2, '2017/06/19 17:13:52', 0, 0, 'asdasda', 0, 1),
(2, 2, '2017/06/19 17:13:52', 0, 0, 'asdasda', 0, 1),
(3, 1, '2017/06/19 18:52:20', 0, 0, 'sdasd', 0, 4),
(4, 1, '2017/06/19 18:52:20', 0, 0, 'sdasd', 0, 4),
(5, 1, '2017/06/19 18:52:20', 0, 0, 'sdasd', 0, 4),
(6, 1, '2017/06/19 18:52:20', 0, 0, 'sdasd', 0, 4),
(7, 2, '2017/06/19 18:52:20', 0, 0, 'asdasda', 0, 1),
(8, 1, '2017/06/20 00:33:18', 0, 0, 'ret', 0, 2),
(9, 2, '2017/06/20 00:33:18', 0, 0, 'asdasda', 0, 1),
(10, 2, '2017/06/20 00:33:18', 0, 0, 'asdasda', 0, 1),
(11, 2, '2017/06/20 00:33:18', 0, 0, 'twest', 0, 1);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(200) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `password`, `user_first_name`, `user_last_name`, `date_of_birth`, `address`, `gender`, `educational_qualification`, `interested_fields`, `currently_working`, `occupation`, `contact_info`, `join_date`, `religious_view`, `nationality`, `expriences`, `skills`, `enabled`, `communication_interest`, `total_articles`, `total_questions`, `total_answered`, `total_posts`, `total_up_vote`, `total_down_vote`, `total_vote`, `profile_weight`) VALUES
(1, 'manin', '123456', 'Abedeen', 'Khan', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Marine Engineering', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/19 00:58:34', 'Religious View', 'Nationality', 'Expriences', 'Railway Engineering', 1, 0, 0, 0, 0, 0, 5, 3, 8, 0.625),
(2, 'csegub', 'test1234', 'Ajharul', 'Abedeen', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Journalism', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/19 11:08:23', 'Religious View', 'Nationality', 'Expriences', 'machine learnging', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(3, 'man2', 'test1234', 'Sajib', 'kumar', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Fishing', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/19 11:10:43', 'Religious View', 'Nationality', 'Expriences', 'Big Data', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 'man3', 'test1234', 'rokeya', 'keya', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Writting', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/19 11:14:53', 'Religious View', 'Nationality', 'Expriences', 'Power Distribution', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 'man4', 'test1234', 'rupa', 'begum', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Traveling ', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/19 11:17:48', 'Religious View', 'Nationality', 'Expriences', 'Swinging', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 'fazuda', '123456', 'adil', 'raisd', 'Date of Join', 'Please Enter ur Name', 'Which gender u belongs to', 'Educational Qualification', 'Robotics', 'Currently Working', 'Occupation', 'Contact Info', '2017/06/20 09:47:26', 'Religious View', 'Nationality', 'Expriences', 'Marketing', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(200) DEFAULT NULL,
  `role` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_role_id`, `username`, `role`) VALUES
(1, 'manin', 'ADMIN'),
(2, 'man', 'ADMIN'),
(3, 'man2', 'ADMIN'),
(4, 'man3', 'ADMIN'),
(5, 'man4', 'ADMIN'),
(6, 'fazuda', 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `users_security`
--

CREATE TABLE `users_security` (
  `username` varchar(255) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users_security`
--

INSERT INTO `users_security` (`username`, `password`, `enabled`) VALUES
('fazuda', '123456', 1),
('man', 'test1234', 1),
('man2', 'test1234', 1),
('man3', 'test1234', 1),
('man4', 'test1234', 1),
('manin', 'test1234', 1);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `vendid` int(11) NOT NULL,
  `vendname` varchar(10) DEFAULT NULL,
  `address` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`vendid`, `vendname`, `address`) VALUES
(401, 'VenVen', 'Dhaka');

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
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`custid`),
  ADD KEY `FK_c27jjm49k1fuo8wi7f1stvyni` (`forevenIdCustomer`);

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
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `FK_amcd273q7eia1m862mme2wgqf` (`CustomerID`);

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

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`vendid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FK_c27jjm49k1fuo8wi7f1stvyni` FOREIGN KEY (`forevenIdCustomer`) REFERENCES `vendor` (`vendid`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK_amcd273q7eia1m862mme2wgqf` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`custid`);

--
-- Constraints for table `question_and_qnswer_comment_votes`
--
ALTER TABLE `question_and_qnswer_comment_votes`
  ADD CONSTRAINT `question_and_qnswer_comment_votes_ibfk_1` FOREIGN KEY (`question_and_answer_comment_vote_id`) REFERENCES `question_and_answer` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
