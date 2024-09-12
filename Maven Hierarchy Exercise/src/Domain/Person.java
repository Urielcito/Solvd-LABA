package Domain;

import Exceptions.*;
import Service.Reproducible;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

final public class Person extends Human implements Reproducible {
    final protected String name;

    public String getName() {
        return name;
    }

    public Person(){ //Empty constructor
        super();
        this.name = "N/A";
        this.birthday = "N/A";
        this.ethnicity = "N/A";
        this.age = 0;
        this.intelligence = 0;
    }
    public Person(String name){ //Generic constructor
        super();
        this.name = name;
        this.birthday = "N/A";
        this.ethnicity = "N/A";
        this.age = 0;
        this.intelligence = 0;
    }
    public Person(String name, String birthday, String ethnicity, int age, int intelligence, String gender){ //Full constructor
        super();
        this.name = name;
        this.birthday = birthday;
        this.ethnicity = ethnicity;
        this.age = age;
        this.intelligence = intelligence;
        this.gender = gender;
    }
    public Person(String birthday, String ethnicity, int averageIntelligence, String name) { // Newborn constructor
        super(birthday, ethnicity, averageIntelligence);
        this.name = name;
    }
    public static Person personFromInput() throws NoNameException{
        try (Scanner read = new Scanner(System.in)){
            System.out.println("Enter name: ");
            String name = read.nextLine();
            if(name == ""){
                throw new NoNameException("Name can't be left empty");
            }

            System.out.println("Enter birthday: ");
            String birthday = read.nextLine();

            System.out.println("Enter ethnicity: ");
            String ethnicity = read.nextLine();

            System.out.println("Enter age: ");
            int age = read.nextInt();

            System.out.println("Enter intelligence: ");
            int intelligence = read.nextInt();

            System.out.println("Enter gender: ");
            String gender = read.nextLine();

            return new Person(name, birthday, ethnicity, age, intelligence, gender);
        } catch (Exception e){
            System.out.println("An error occurred while reading from input");
            e.printStackTrace();
            return null;
        }
    }
    public static void validateGender(Person p) throws InvalidGenderException {
        if(p.getGender().matches(".*\\d.*"))
            throw new InvalidGenderException("Gender can't have numbers");
        else
            System.out.println("Gender is valid");
    }
    public static void validateAge(Person p) throws NegativeAgeException{
        if(p.getAge() < 0)
            throw new NegativeAgeException("Age can't be negative");
        else
            System.out.println("Age is valid.");
    }
    public static void validateIntelligence(Person p) throws NegativeIntException{
        if(p.getIntelligence() < 0)
            throw new NegativeIntException("Intelligence can't be negative");
        else
            System.out.println("Intelligence is valid.");
    }

    public Object reproduce(Object objectB, String name) throws TooYoungException {
        Person parentB = (Person) objectB;
        Person child;
        if(this.age < 18 || parentB.getAge() < 18)
        {
            throw new TooYoungException("Persons under 18 years old shouldn't reproduce");
        }
        else {
            Random chooseEthnicity = new Random();
            String childEthnicity = "";
            if (chooseEthnicity.nextInt(1, 3) == 1)
                childEthnicity = ethnicity;
            else
                childEthnicity = parentB.getEthnicity();

            int averageIntelligence = (this.intelligence + parentB.getIntelligence()) / 2;
            child = new Person(LocalDateTime.now().toString(), childEthnicity, averageIntelligence, name);
        }
        return child;
    }

    public void speak(){
        think();
        makeSound();
    }
    public void makeSound(){
        System.out.println("*says something*");
    }

    @Override
    public void showEverything(){
        System.out.println("\nName: "+this.name+"\nAge: "+this.age+"\nBirthday: "+this.birthday+"\nEthnicity: "+this.ethnicity+"\nIntelligence: "+this.intelligence+"\nGender: "+this.gender+"\n");
    }

    //Overriding Object class methods:

    @Override
    public String toString() {
        return "Domain.Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this.name == ((Person) o).getName())
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        int code = this.getAge() + this.getIntelligence();
        return code;
    }
}
