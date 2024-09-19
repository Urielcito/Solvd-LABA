import Domain.*;
import Enums.*;
import Exceptions.*;
import Service.CustomLambda;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    private static Logger logger;
    public static void main(String[] args) {
        logger = LogManager.getLogger(Main.class);

        // Below is all of the previous homework combined for convenience-----------------------------------------------
        /*
        Collections c = new Collections();
        CustomLinkedList<Person> linkedList = new CustomLinkedList();
        System.out.println("\nPerson:");
        Person p = new Person("Uriel", "11/12/2013", "White", 22, 125, "male");
        Person p2 = new Person("Naty", "17/02/2001", "Asian", 23, 130, "female");
        try {
            Person child = (Person) p.reproduce(p2, "Fabricio");
            Person child2 = (Person) p.reproduce(p2, "Julieta"); // Runtime polymorphism (casting Object -> Domain.Person)
            p.showEverything();
            p2.showEverything();
            child.showEverything();
            child2.showEverything();
            c.students.add(child);
            c.students.add(child2);


        }catch (TooYoungException ex){
            System.out.println("Exception caught");
            System.out.println("Message: "+ex.getMessage());
        }


        System.out.println("\nPlant:");
        Plant plant0 = new Plant(true, true);
        plant0.searchForFood();
        plant0.water();
        plant0.showEverything();


        System.out.println("\nTree:");
        Tree tree0 = new Tree(true,true,1,7);
        tree0.searchForFood();
        tree0.showEverything();

        System.out.println("\nMushroom:");
        Mushroom mush0 = new Mushroom();
        mush0.releaseSpores();
        mush0.showEverything();

        System.out.println("\nFish:");
        Fish fish0 = new Fish();
        fish0.LayEggs();
        fish0.showEverything();

        System.out.println("\nCat:");
        Cat cat0 = new Cat("Pirata","Negro","Miau");
        cat0.meow();
        cat0.showEverything();

        System.out.println("\nGuinea Pig:");
        GuineaPig piggy0 = new GuineaPig("Tita blanca", "Abisinio");
        piggy0.makeSound(); // standard sound
        piggy0.makeSound(GuineaPig.actions.ASK_FOR_FOOD); // Compile time polymorphism
        piggy0.showEverything();

        System.out.println("\nUse of static in Domain.Animal class:");
        System.out.println("animales creados: "+Animal.animalsCreated()); // Use of static block + static method + static variable

        System.out.println("\n----EXCEPTIONS AND LOGGING----\n");

        // REPRODUCTION RELATED EXCEPTION IS CAUGHT ABOVE IN "PERSON" SECTION

        Person p3 = new Person("Age13", "11/12/2002", "white", 13, 100, "male");
        Person p4 = new Person("Age-13", "17/2/2001", "white", -13, -100, "male");
        System.out.println("Validating person of age 13.");
        try{
            Person.validateAge(p3);
        } catch (NegativeAgeException ex){
            System.out.println("Exception caught");
            System.out.println("Message: "+ex);
        }
        System.out.println("Validating person of age -13.");
        try{
            Person.validateAge(p4);
        } catch (NegativeAgeException ex){
            System.out.println("Exception caught");
            System.out.println("Message: "+ex);
        }
        System.out.println("Validating intelligence 100:");
        try{
            Person.validateIntelligence(p3);
        } catch (NegativeIntException ex){
            System.out.println("Exception caught");
            System.out.println("Message: "+ex);
        }
        System.out.println("Validating intelligence -100:");
        try{
            Person.validateIntelligence(p4);
        } catch (NegativeIntException ex){
            System.out.println("Exception caught");
            System.out.println("Message: "+ex);
        }
        System.out.println("Creating person from input..."); // TRY WITH RESOURCES DONE HERE
        try {
            Person p5 = Person.personFromInput();
            if(p5 != null){
                System.out.println("Created person: ");
                p5.showEverything();
            }
        } catch(NoNameException ex){
            System.out.println("Exception caught");
            System.out.println("Message: "+ex);
        }

        logger = LogManager.getLogger(Main.class);
        logger.info("a"); // LOG INTO FILE, CONSOLE. DONE.



        c.friends.add(p);
        c.friends.add(p2);
        c.pets.add(cat0);
        c.pets.add(piggy0);
        //the two childs are added to students arraylist above
        linkedList.append(p);
        linkedList.append(p2);
        //linkedList.pop(); pop deletes the last node
        linkedList.display();
        */

        //StringUtils and FileUltis homework----------------------------------------------------------------------------

        /*
        File file = new File("resources/text.txt");
        File output = new File("resources/output.txt");
        try{
            String string = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            String[] words = StringUtils.split(string);
            int amountOfWords = words.length;

            System.out.println("Text of the file: " + string);
            FileUtils.writeStringToFile(output, "File has "+amountOfWords+" words.", StandardCharsets.UTF_8);

        } catch(IOException e){
            logger.error("An IOException occurred while reading the file: " + file.getAbsolutePath(), e);
        }
        */

        //Lambda functions and complex enums homework-------------------------------------------------------------------------------------
        /*
        // I ran out of creativity to put all this on context with the project
        // Using function.Function
        Function<Integer, String> intToString = (i) -> "Number: " + i;
        System.out.println(intToString.apply(10));

        // Using function.Consumer
        Consumer<String> print = (s) -> System.out.println(s);
        print.accept("Hello World");

        // Using function.Predicate
        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        System.out.println(isEven.test(4)); // true

        // Using function.Supplier
        Supplier<String> supplyString = () -> "This is a Supplier";
        System.out.println(supplyString.get());

        // Using function.BiFunction
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(2, 3)); // 5

        // My own Custom Lambda Functions:
        // converts double to string
        CustomLambda<Double, String> doubleToString = (d) -> "Converted: " +d;
        System.out.println(doubleToString.apply(42.3));

        // calculates the square of a double
        CustomLambda<Double, Double> square = (d) -> d*d;
        System.out.println(square.apply(12.5));

        // returns the length of a string
        CustomLambda<String, Integer> stringLength = (s) -> s.length();
        System.out.println(stringLength.apply("A String of length: 21"));

        // My complex enums:
        // Enum used to represent days of the week
        System.out.println(Day.MONDAY.getType());

        // Enum used to represent the priority of anything
        Priority.LOW.printPriority();

        //Enum used to represent the size of whatever
        System.out.println(Size.fromString("Medium size"));

        //Enum used to do arithmetic
        System.out.println(Operation.ADD.apply(5,3));

        //Enum used to convert from a currency to another
        double amountInUSD = 100;
        double amountInEUR = Currency.convert(amountInUSD, Currency.USD, Currency.EUR);
        System.out.println(amountInEUR);
        */
        //Streaming and Reflection homework-----------------------------------------------------------------------------
        /*
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. Non-terminal: filter
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)  // Non-terminal
                .collect(Collectors.toList()); // Terminal
        System.out.println("Even numbers: " + evenNumbers);

        // 2. Non-terminal: map
        List<String> numberStrings = numbers.stream()
                .map(n -> "Number " + n)  // Non-terminal operation
                .collect(Collectors.toList()); // Terminal
        System.out.println("Number strings: " + numberStrings);

        // 3. Non-terminal: distinct
        List<Integer> duplicates = Arrays.asList(1, 1, 2, 3, 3, 4);
        List<Integer> uniqueNumbers = duplicates.stream()
                .distinct()  // Non-terminal
                .collect(Collectors.toList()); // Terminal
        System.out.println("Unique numbers: " + uniqueNumbers);

        // 4. Non-terminal: sorted
        List<Integer> sortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())  // Non-terminal
                .collect(Collectors.toList()); // Terminal
        System.out.println("Sorted numbers: " + sortedNumbers);

        // 5. Non-terminal: limit
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5)  // Non-terminal
                .collect(Collectors.toList()); // Terminal
        System.out.println("Limited numbers: " + limitedNumbers);

        // 6. Non-terminal: skip
        List<Integer> skippedNumbers = numbers.stream()
                .skip(5)  // Non-terminal
                .collect(Collectors.toList()); // Terminal
        System.out.println("Skipped numbers: " + skippedNumbers);

        // 7. Terminal: forEach
        System.out.println("Numbers squared:");
        numbers.stream()
                .map(n -> n * n)  // Non-terminal
                .forEach(System.out::println); // Terminal

        // USING REFLECTION NOW:
        Class<?> clazz = ReflectionExample.class;

        // Get and show the class's fields.
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName() + ", Modifiers: " + Modifier.toString(field.getModifiers()));
        }

        // Get and show the class's methods.
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName() +
                    ", Return type: " + method.getReturnType() +
                    ", Parameters: " + Arrays.toString(method.getParameterTypes()));
        }

        // Get and show the class's constructors
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName() +
                    ", Parameters: " + Arrays.toString(constructor.getParameterTypes()));
        }

        // Making an instance of the class through reflection
        try {
            ReflectionExample instance = (ReflectionExample) clazz.getDeclaredConstructor().newInstance();
            // Calling a method from the class through reflection
            Method greetMethod = clazz.getMethod("greet", String.class);
            greetMethod.invoke(instance, "World");
        } catch(Exception e){
            logger.info(e.getMessage());
        }
         */
    }
}

