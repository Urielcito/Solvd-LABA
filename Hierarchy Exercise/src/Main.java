import Domain.*;
import Exceptions.NegativeAgeException;
import Exceptions.NegativeIntException;
import Exceptions.NoNameException;
import Exceptions.TooYoungException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger;
    public static void main(String[] args) {
        // Domain.Cell has final kill() method.
        // class Domain.Person is final.
        // Domain.Person has final 'name' variable.

        // Static variable: animalCount.
        // Static block: Initiate Animals.animalCount = 0.
        // Static method: Return animalCount (Animals.animalsCreated())

        // Classes Domain.Cat, Domain.GuineaPig and Domain.Person override toString(), hashCode() and equals() from the Object class.
        Collections c = new Collections();
        CustomLinkedList<Person> linkedList = new CustomLinkedList<>();
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
        /*System.out.println("Creating person from input..."); // TRY WITH RESOURCES DONE HERE
        try {
            Person p5 = Person.personFromInput();
            if(p5 != null){
                System.out.println("Created person: ");
                p5.showEverything();
            }
        } catch(NoNameException ex){
            System.out.println("Exception caught");
            System.out.println("Message: "+ex);
        }*/
        logger = LogManager.getLogger(Main.class);
        logger.info("a");



        c.friends.add(p);
        c.friends.add(p2);
        c.pets.add(cat0);
        c.pets.add(piggy0);
        //the two childs are added to students arraylist above
        linkedList.append(p);
        linkedList.append(p2);
        linkedList.pop();
        linkedList.display();

    }
}

