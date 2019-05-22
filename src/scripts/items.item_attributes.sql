CREATE TABLE `items`.`item_attributes` (
  `item_attributeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `itemID` int(10) unsigned NOT NULL,
  `attributeID` int(10) unsigned NOT NULL,
  `amount` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`item_attributeID`),
  KEY `itemID` (`itemID`),
  KEY `attributeID` (`attributeID`),
  CONSTRAINT `item_attributes_ibfk_1` FOREIGN KEY (`itemID`) REFERENCES `items` (`itemID`),
  CONSTRAINT `item_attributes_ibfk_2` FOREIGN KEY (`attributeID`) REFERENCES `attributes` (`attributeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;