CREATE TABLE `login`.`equipment` (
  `EquipID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bagSlot` int(10) unsigned DEFAULT NULL,
  `charID` int(10) unsigned NOT NULL,
  `itemID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`EquipID`),
  KEY `charID` (`charID`),
  KEY `itemID` (`itemID`),
  CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`charID`) REFERENCES `chars` (`charID`),
  CONSTRAINT `equipment_ibfk_2` FOREIGN KEY (`itemID`) REFERENCES `items`.`items` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;