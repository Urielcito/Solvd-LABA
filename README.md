# Solvd-LABA
## TO-DO:
```
- Use at least 5 lambda functions from the java.util.function package.
- Create 3 custom Lambda functions with generics.
- Create 5 complex Enums(with fields, methods, blocks)

 ( NOT NOW )
- Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
- Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods. Create object and call method using the only reflection
```
## Changelog:
```
- Moved whole project to quickstart maven archetype
- Deleted all demo code for previous homework and stored it in a txt just in case
- Installed dependencies for StringUtils and FileUtils
- Read unique word count from file using StringUtils and FileUtils done in Main class
```

## Relevant source:
```

. . .

File file = new File("resources/text.txt");
        try{
            String string = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println("Text of the file: " + string);
            // Using countMatches (LESS ROBUST)
            System.out.println("(countMatches method) \nFile has " + (1 + StringUtils.countMatches(string, " ")) + " words.");

            // Using split (ROBUST)
            String[] words = StringUtils.split(string);
            System.out.println("(split method) \nFile has " + words.length + " words.");
			
. . .

```