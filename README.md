## XML Homework
### Animal.xml (theres 4 more in resources folder)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<animals>
    <animal id="1">
        <speciesName>Dog</speciesName>
        <hasFur>true</hasFur>
        <type>Mammal</type>
        <gender>Female</gender>
        <ownerId>0</ownerId>
    </animal>

    <animal id="2">
        <speciesName>Guinea Pig</speciesName>
        <hasFur>false</hasFur>
        <type>Aquatic</type>
        <gender>Male</gender>
        <ownerId>1</ownerId>
    </animal>
</animals>
```

### Animal.xsd (theres 4 more in resources folder)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="animals">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="animal" maxOccurs="unbounded">
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name="speciesName" type="xs:string"/>
                            <xs:element name="hasFur" type="xs:boolean"/>
                            <xs:element name="type" type="xs:string"/>
                            <xs:element name="gender" type="xs:string"/>
                            <xs:element name="ownerId" type="xs:int"/>
                        </xs:sequence>
                        <xs:attribute name="id" type="xs:int" use="required"/>
                    </xs:complexType>
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>
```

### Logger output for parsing and validating Animal.xml (done in main method through DOMParser.java class)
```
21:38:39.980 [main] INFO  Domain.DOMParseAndValidate - Element: animals
21:38:39.983 [main] INFO  Domain.DOMParseAndValidate -   Element: animal
21:38:39.983 [main] INFO  Domain.DOMParseAndValidate -     Attribute: id = 1
21:38:39.983 [main] INFO  Domain.DOMParseAndValidate -     Element: speciesName
21:38:39.983 [main] INFO  Domain.DOMParseAndValidate -       Text: Dog
21:38:39.983 [main] INFO  Domain.DOMParseAndValidate -     Element: hasFur
21:38:39.984 [main] INFO  Domain.DOMParseAndValidate -       Text: true
21:38:39.984 [main] INFO  Domain.DOMParseAndValidate -     Element: type
21:38:39.984 [main] INFO  Domain.DOMParseAndValidate -       Text: Mammal
21:38:39.984 [main] INFO  Domain.DOMParseAndValidate -     Element: gender
21:38:39.984 [main] INFO  Domain.DOMParseAndValidate -       Text: Female
21:38:39.984 [main] INFO  Domain.DOMParseAndValidate -     Element: ownerId
21:38:39.984 [main] INFO  Domain.DOMParseAndValidate -       Text: 0
21:38:39.985 [main] INFO  Domain.DOMParseAndValidate -   Element: animal
21:38:39.985 [main] INFO  Domain.DOMParseAndValidate -     Attribute: id = 2
21:38:39.985 [main] INFO  Domain.DOMParseAndValidate -     Element: speciesName
21:38:39.985 [main] INFO  Domain.DOMParseAndValidate -       Text: Guinea Pig
21:38:39.985 [main] INFO  Domain.DOMParseAndValidate -     Element: hasFur
21:38:39.986 [main] INFO  Domain.DOMParseAndValidate -       Text: false
21:38:39.986 [main] INFO  Domain.DOMParseAndValidate -     Element: type
21:38:39.986 [main] INFO  Domain.DOMParseAndValidate -       Text: Aquatic
21:38:39.986 [main] INFO  Domain.DOMParseAndValidate -     Element: gender
21:38:39.986 [main] INFO  Domain.DOMParseAndValidate -       Text: Male
21:38:39.986 [main] INFO  Domain.DOMParseAndValidate -     Element: ownerId
21:38:39.986 [main] INFO  Domain.DOMParseAndValidate -       Text: 1
21:38:39.987 [main] INFO  Domain.DOMParseAndValidate - Parsed src/resources/Animal.xml
21:38:40.018 [main] INFO  Domain.DOMParseAndValidate - Element: animals
21:38:40.018 [main] INFO  Domain.DOMParseAndValidate -   Element: animal
21:38:40.019 [main] INFO  Domain.DOMParseAndValidate -     Attribute: id = 1
21:38:40.019 [main] INFO  Domain.DOMParseAndValidate -     Element: speciesName
21:38:40.019 [main] INFO  Domain.DOMParseAndValidate -       Text: Dog
21:38:40.019 [main] INFO  Domain.DOMParseAndValidate -     Element: hasFur
21:38:40.019 [main] INFO  Domain.DOMParseAndValidate -       Text: true
21:38:40.020 [main] INFO  Domain.DOMParseAndValidate -     Element: type
21:38:40.020 [main] INFO  Domain.DOMParseAndValidate -       Text: Mammal
21:38:40.020 [main] INFO  Domain.DOMParseAndValidate -     Element: gender
21:38:40.020 [main] INFO  Domain.DOMParseAndValidate -       Text: Female
21:38:40.020 [main] INFO  Domain.DOMParseAndValidate -     Element: ownerId
21:38:40.020 [main] INFO  Domain.DOMParseAndValidate -       Text: 0
21:38:40.021 [main] INFO  Domain.DOMParseAndValidate -   Element: animal
21:38:40.021 [main] INFO  Domain.DOMParseAndValidate -     Attribute: id = 2
21:38:40.021 [main] INFO  Domain.DOMParseAndValidate -     Element: speciesName
21:38:40.021 [main] INFO  Domain.DOMParseAndValidate -       Text: Guinea Pig
21:38:40.021 [main] INFO  Domain.DOMParseAndValidate -     Element: hasFur
21:38:40.022 [main] INFO  Domain.DOMParseAndValidate -       Text: false
21:38:40.022 [main] INFO  Domain.DOMParseAndValidate -     Element: type
21:38:40.022 [main] INFO  Domain.DOMParseAndValidate -       Text: Aquatic
21:38:40.022 [main] INFO  Domain.DOMParseAndValidate -     Element: gender
21:38:40.022 [main] INFO  Domain.DOMParseAndValidate -       Text: Male
21:38:40.022 [main] INFO  Domain.DOMParseAndValidate -     Element: ownerId
21:38:40.022 [main] INFO  Domain.DOMParseAndValidate -       Text: 1
21:38:40.023 [main] INFO  Domain.DOMParseAndValidate - Parsed src/resources/Animal.xml
21:38:40.023 [main] INFO  Domain.DOMParseAndValidate - Xml src/resources/Animal.xml validated successfully against src/resources/Animal.xsd.
```

## Changelog:
### Oct 23.
- 5 XSD files added to src/resources
- 5 XML files added to src/resources
- DOM implemented to parse and validate XML files against a specified XSD schema.
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