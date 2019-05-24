CREATE TABLE `login`.`chars` (
  `charID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) DEFAULT NULL,
  `exp` int(10) unsigned DEFAULT NULL,
  `userID` int(10) unsigned NOT NULL,
  `serverID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`charID`),
  KEY `userID` (`userID`),
  KEY `chars_ibfk_2_idx` (`serverID`),
  CONSTRAINT `chars_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`),
  CONSTRAINT `chars_ibfk_2` FOREIGN KEY (`serverID`) REFERENCES `server` (`serverID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;