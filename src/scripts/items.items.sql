CREATE TABLE `items`.`items` (
  `itemID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_typeID` int(10) unsigned NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`itemID`),
  KEY `item_typeID` (`item_typeID`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`item_typeID`) REFERENCES `item_types` (`item_typeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;