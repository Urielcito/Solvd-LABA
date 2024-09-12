# Solvd-LABA
## TO-DO:
- Use at least 5 lambda functions from the java.util.function package.
- Create 3 custom Lambda functions with generics.
- Create 5 complex Enums(with fields, methods, blocks)

###( NOT NOW )
- Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
- Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods.
## Changelog:
- Moved whole project to quickstart maven archetype
- Deleted all demo code for previous homework and stored it in a txt just in case
- Installed dependencies for StringUtils and FileUtils
- Read unique word count from file using StringUtils and FileUtils done in Main class
## Relevant source:
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