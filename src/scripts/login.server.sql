CREATE TABLE `login`.`server` (
  `serverID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `playerAmount` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`serverID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;