# Relevant info for the DAO homework:
- 'Service' package that's inside the src folder now hosts a large quantity of new interfaces (IAnimal, ICat, etc...) these are implemented in each respective DAO
- New 'MySQL' package located inside the src folder that hosts the 'JDBC' class responsible for the connection to the database and all the Data Access Objects.
- A copy of the connector jar file was stored under the folder Maven Hierarchy Exercise/lib/


# Requested MySQL Queries
- "10 statements for insertion"
```
INSERT INTO country (id, name) VALUES (1, 'Uruguay');
INSERT INTO identity (number) VALUES (52629636);
INSERT INTO identity (number) VALUES (51098210);
INSERT INTO person(id,name,identity,countryId) VALUES (0, 'Uriel', 52629636, 1);
INSERT INTO person (id, name, identity, countryId) VALUES (1, 'Natalia', 51098210, 1);
INSERT INTO animal (id, speciesName, hasFur, type, gender, ownerId) VALUES (1, 'Cat', 1, 'Mammal', 'Male', 0);
INSERT INTO animal (id, speciesName, hasFur, type, gender, ownerId) VALUES (2, 'Fish', 0, 'Aquatic', 'Female', 1);
INSERT INTO cat (id, name, race, meow) VALUES (0, 'Sir Cat', 'Siamese', 'Soft');
INSERT INTO fish (id, weight, eggsLayed) VALUES (1, '2kg', 200);
INSERT INTO tree (id, height, humidity) VALUES (0, 5.5, 75);
```
- "10 statements for updating"
```
UPDATE animal SET speciesName = 'Dog' WHERE id = 1;
UPDATE cat SET name = 'Fluffy' WHERE id = 0;
UPDATE fish SET eggsLayed = 300 WHERE id = 1;
UPDATE person SET name = 'Tuxedo Mask' WHERE id = 0;
UPDATE country SET name = 'Japan' WHERE id = 1;
UPDATE tree SET humidity = 80 WHERE id = 0;
UPDATE person SET name = 'Sailor Moon' WHERE id = 1;
UPDATE animal SET speciesName = 'Guinea Pig' WHERE id = 2;
UPDATE animal SET gender = 'Female' WHERE id = 1;
UPDATE fish SET weight = 2 WHERE id = 1;
```
- "10 statements for deletions" (I'm not deleting too much existing data so I don't have to insert more things for the next queries..)
```
DELETE FROM animal WHERE speciesName = 'Dodo'
DELETE FROM cat WHERE name = 'Fluffy'
DELETE FROM fish WHERE eggsLayed<200
DELETE FROM person WHERE identity = 0
DELETE FROM country WHERE name = "Netherlands"
DELETE FROM cell WHERE health=0
DELETE FROM animal WHERE hasFur=0
DELETE FROM tree WHERE height=0.0
DELETE FROM human WHERE intelligence = 0
DELETE FROM mushroom WHERE areaCovered = 0
```
- "5 alter table"
```
ALTER TABLE animal MODIFY COLUMN gender VARCHAR(100);
ALTER TABLE identity ADD CONSTRAINT unique_identity_number UNIQUE (number);
ALTER TABLE person MODIFY name VARCHAR(200);
ALTER TABLE fish MODIFY weight DOUBLE;
ALTER TABLE animal MODIFY COLUMN speciesName VARCHAR(200);
```
- "1 big statement to join all tables in the database"
```
SELECT *
FROM animal
LEFT JOIN person ON animal.ownerId = person.id
LEFT JOIN cat ON animal.id = cat.id
LEFT JOIN fish ON animal.id = fish.id
LEFT JOIN guineapig ON animal.id = guineapig.id
LEFT JOIN human ON animal.id = human.id
LEFT JOIN country ON person.countryId = country.id
LEFT JOIN identity ON person.identity = identity.number;
```
- "5 statements with left, right, inner, outer joins"
```
-- LEFT JOIN
SELECT person.name, animal.speciesName
FROM person
LEFT JOIN animal ON person.id = animal.ownerId;

-- RIGHT JOIN
SELECT person.name, country.name
FROM person
RIGHT JOIN country ON person.countryId = country.id;

-- INNER JOIN
SELECT cat.name, animal.speciesName
FROM cat
INNER JOIN animal ON cat.id = animal.id;

-- FULL OUTER JOIN
SELECT *
FROM person
LEFT JOIN country ON person.countryId = country.id
UNION
SELECT *
FROM person
RIGHT JOIN country ON person.countryId = country.id;

-- LEFT JOIN with condition
SELECT person.name, country.name
FROM person
LEFT JOIN country ON person.countryId = country.id
WHERE country.name = 'Japan';
```
- "7 statements with aggregate functions, group by, without having"
```
-- Quantity of animals of each species
SELECT speciesName, COUNT(*) FROM animal GROUP BY speciesName;

-- Quantity of animals of each gender
SELECT gender, COUNT(*) FROM animal GROUP BY gender;

-- Quantity of persons from each country
SELECT country.name, COUNT(person.id) FROM person INNER JOIN country ON person.countryId = country.id GROUP BY country.name;

-- Quantity of cats from each race
SELECT race, COUNT(*) FROM cat GROUP BY race;

-- Average of intelligence for each ethnicity
SELECT ethnicity, AVG(intelligence) FROM human GROUP BY ethnicity;

-- Quantity of trees with the same height
SELECT height, COUNT(*) FROM tree GROUP BY height;

-- Quantity of fish with the same amount of eggs layed.
SELECT eggsLayed, COUNT(*) FROM fish GROUP BY eggsLayed;
```
- "7 statements with aggregate functions, group by, having"
```
-- Animals for which there are more than one register for that species in the database.
SELECT speciesName, COUNT(*) FROM animal GROUP BY speciesName HAVING COUNT(*) > 1;

-- Animal genders for which there are more than one register for animals with that gender in the database.
SELECT gender, COUNT(*) FROM animal GROUP BY gender HAVING COUNT(*) > 1;

-- Amount of persons from a country which has more than one person registered living in it.
SELECT country.name, COUNT(person.id) FROM person INNER JOIN country ON person.countryId = country.id GROUP BY country.name HAVING COUNT(person.id) > 1;

-- Cat races that have more than one cat with that race registered in the database.
SELECT race, COUNT(*) FROM cat GROUP BY race HAVING COUNT(*) > 1;

-- Ethnicities that average an intelligence above 100.
SELECT ethnicity, AVG(intelligence) FROM human GROUP BY ethnicity HAVING AVG(intelligence) > 100;

-- Amount of trees that have any height above 1 meter.
SELECT height, COUNT(*) FROM tree GROUP BY height HAVING COUNT(*) > 1;

-- Amount of fish that have any amount of eggs layed above 100.
SELECT eggsLayed, COUNT(*) FROM fish GROUP BY eggsLayed HAVING COUNT(*) > 100;
```
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
  `ownerId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ownerId_idx` (`ownerId`),
  CONSTRAINT `ownerId` FOREIGN KEY (`ownerId`) REFERENCES `person` (`id`)
)

DROP TABLE IF EXISTS `cat`;

CREATE TABLE `cat` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  `meow` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

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
)

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `fish`;

CREATE TABLE `fish` (
  `id` int NOT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `eggsLayed` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `fish_eaten`;

CREATE TABLE `fish_eaten` (
  `idCat` int NOT NULL,
  `idFish` int NOT NULL,
  PRIMARY KEY (`idCat`,`idFish`),
  KEY `fish_idx` (`idFish`),
  CONSTRAINT `cat` FOREIGN KEY (`idCat`) REFERENCES `cat` (`id`),
  CONSTRAINT `fish` FOREIGN KEY (`idFish`) REFERENCES `fish` (`id`)
)

DROP TABLE IF EXISTS `guineapig`;

CREATE TABLE `guineapig` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `human`;

CREATE TABLE `human` (
  `id` int NOT NULL,
  `age` int DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `intelligence` int DEFAULT NULL,
  `ethnicity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `identity`;

CREATE TABLE `identity` (
  `number` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
)

DROP TABLE IF EXISTS `mushroom`;

CREATE TABLE `mushroom` (
  `id` int NOT NULL,
  `areaCovered` int DEFAULT NULL,
  `count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `identity` int DEFAULT NULL,
  `countryId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `identity_idx` (`identity`),
  KEY `country_idx` (`countryId`),
  CONSTRAINT `country` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`),
  CONSTRAINT `identity` FOREIGN KEY (`identity`) REFERENCES `identity` (`number`)
)

DROP TABLE IF EXISTS `plant`;

CREATE TABLE `plant` (
  `id` int NOT NULL,
  `receivesSunlight` tinyint DEFAULT NULL,
  `isWatered` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `tree`;

CREATE TABLE `tree` (
  `id` int NOT NULL,
  `height` double DEFAULT NULL,
  `humidity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```

## Changelog:
### Oct 14.
- Wrote every DAO, it should work as intended just for uploading & downloading those objects to/from the database, in the hierarchy itself they probably are not functional.
### Oct 10.
- Added the requested SQL Statements
- DAO Structure is done just for Animal class (this means I can now do every other class using this one as a template)
- JDBC Library implemented.
### Oct 8.
- Removed Entity-Relation Model Diagram
- Added relationships to my existing Entity Relation Model:
	- "Cat eats Fish" N:N
	- "Person is from Country" N:1
	- "Person has pet" (Animal) 1:N
	- "Person has identity" 1:1
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