# MySQL Workbench commands to create the schema and the tables:

```
CREATE DATABASE  IF NOT EXISTS `proyectosolvd`; 
USE `proyectosolvd`;
DROP TABLE IF EXISTS `animal`;
CREATE TABLE `animal` (
  `id` int NOT NULL,
  `speciesName` varchar(45) DEFAULT NULL,
  `hasFur` tinyint DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  `meow` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `cell`;
CREATE TABLE `cell` (
  `id` int NOT NULL,
  `health` double DEFAULT NULL,
  `energyPerOperation` double DEFAULT NULL,
  `energy` double DEFAULT NULL,
  `storedEnergy` double DEFAULT NULL,
  `oxygen` double DEFAULT NULL,
  `alive` tinyint DEFAULT NULL,
  `maxEnergy` double DEFAULT NULL,
  `maxOxygen` double DEFAULT NULL,
  `storageCapacity` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `fish`;
CREATE TABLE `fish` (
  `id` int NOT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `eggsLayed` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `guineapig`;
CREATE TABLE `guineapig` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `human`;
CREATE TABLE `human` (
  `id` int NOT NULL,
  `age` int DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `intelligence` int DEFAULT NULL,
  `ethnicity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `mushroom`;
CREATE TABLE `mushroom` (
  `id` int NOT NULL,
  `areaCovered` int DEFAULT NULL,
  `count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `plant`;
CREATE TABLE `plant` (
  `id` int NOT NULL,
  `receivesSunlight` tinyint DEFAULT NULL,
  `isWatered` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `id` int NOT NULL,
  `height` double DEFAULT NULL,
  `humidity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

```

My project hierarchy is a particular one which doesn't have any relationships between entities, this SQL schema would only serve as a way of storaging simple data

- Note: If relations are needed, I shall redo all the hierarchy to one that will properly adapt to future requirements instead.

# Entity-Relation Model (graphical representation of RM)

<img src='mer.png' width=100%>



## Changelog:
### Oct 4.
- Removed useless RM, kept the cool diagram
- Added SQL commands to create the schema
- Added the SQL file to directly import into MySQL Workbench in case something goes wrong
### Oct 3.
- Removed last readme sections that aided in showing my code during the exam
- Added my first try at a relational model
### Sep 18.
- New readme section: It shows where are some of the most important topics reflected in the project's code.
- Removed TO-DO and relevant code sections from README to make the new section stand out
- Finished the lambda functions, complex enums, streaming and reflection homework, everything is in the main method.
### Sep 12.
- Moved whole project to quickstart maven archetype
- Deleted all demo code for previous homework and stored it in a txt just in case
- Installed dependencies for StringUtils and FileUtils
- Read unique word count from file using StringUtils and FileUtils done in Main class

### Sep 6.
- Built jar file located in 'target' folder.
- Different maven lifecycle commands worked succesfully (install, package, compile, validate) deploy command didn't work

### Aug 30.
- Installed maven on the project
- Successfully installed log4j through maven
- We are now able to log things to a file and to the console at the same time

### Aug 29.
- Added 4 arraylists.
- Added a custom coded linked list with 'Person' as data type

### Aug 26.
- Installed log4j in the current project
- Added 5 custom exceptions (NoNameException, NegativeAgeException, NegativeIntException, InvalidGenderException and TooYoungException, all of them are in class 'Person').
- Handled them first with throws inside 'Person' class and with try-catch in the main() method.
- Used try-with-resources inside 'Person' class on static method 'personFromInput' utilizing the Scanner class.

### Aug 22.
- Changed folder name to better fit the format of future homework.
- Added 5 interfaces (Eater, Moveable, Thinker, Reproducible, Growable)
- Fixed camelCase for all method names.
- Changed Cell's kill() method to be final.
- Changed Person's variable 'name' to be final.
- Changed Person's class type to be final.
- Added static variable animalCount to Animal
- Added static block in Animal to initialize animalCount = 0.
- Added static method in Animal to return animalCount.
- Improved the main method in Main to better reflect each requested feature.

### Aug 6.
- Sorting algorithm done.