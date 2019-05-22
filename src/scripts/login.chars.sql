CREATE TABLE `login`.`chars` (
  `charID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) DEFAULT NULL,
  `exp` int(10) unsigned DEFAULT NULL,
  `userID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`charID`),
  KEY `userID` (`userID`),
  CONSTRAINT `chars_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;