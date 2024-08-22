import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cell has final kill() method.
        // class Person is final.
        // Person has final 'name' variable.

        // Static variable: animalCount.
        // Static block: Initiate Animals.animalCount = 0.
        // Static method: Return animalCount (Animals.animalsCreated())

        // Classes Cat, GuineaPig and Person override toString(), hashCode() and equals() from the Object class.

        System.out.println("\nPerson:");
        Person p = new Person("Uriel", "11/12/2002", "White", 22, 125, "male");
        Person p2 = new Person("Naty", "17/02/2001", "Asian", 23, 130, "female");

        Person child = (Person) p.reproduce(p2, "Fabricio");
        Person child2 = (Person) p.reproduce(p2, "Julieta"); // Runtime polymorphism (casting Object -> Person)
        p.showEverything();
        p2.showEverything();
        child.showEverything();
        child2.showEverything();


        System.out.println("\nPlant:");
        Plant plant0 = new Plant(true, true);
        plant0.releaseOxygen();
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

        System.out.println("\nUse of static in Animal class:");
        System.out.println("animales creados: "+Animal.animalsCreated()); // Use of static block + static method + static variable

    }
}

