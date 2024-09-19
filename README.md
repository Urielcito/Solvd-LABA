# Solvd-LABA
## TO-DO:
- Use at least 5 lambda functions from the java.util.function package.
- Create 3 custom Lambda functions with generics.
- Create 5 complex Enums(with fields, methods, blocks)

### ( NOT NOW )
- Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
- Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods.

## Latest homework relevant source:
```java
File file = new File("resources/text.txt");
File output = new File("resources/output.txt");
try{
	String string = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	String[] words = StringUtils.split(string);
	int amountOfWords = words.length;
	System.out.println("Text of the file: " + string);
	FileUtils.writeStringToFile(output, "File has "+amountOfWords+" words.", StandardCharsets.UTF_8);
```
## Examples of some terms inside the code:
- **P.O.O**: Everything makes use of P.O.O.

- **Polymorphism**: In the Move() method many of the classes have.

- **Inheritance**: Many classes inherit from Cell.

- **Abstraction**: Every class.

- **Encapsulation**: Every class.

- **Overriding**: Cell's methods.

- **Overloading**: GuineaPig class.

- **.this**: Constructor of any class.

- **Interfaces**: Service package.

- **Constructor**: Every class has one.

- **Default constructor**: Invisible.

- **Logger**: Main method.

- **Exception**: Exceptions package.

- **List**: Main method.

- **ArrayList**: Domain.Collections class.

- **Set, Deck, Map, Hash..**: I didn't code any.

- **Streams**: Main method.

- **Lambda function**: Main method.

- **Reflection**: Main method.

## Changelog:

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