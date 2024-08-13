import java.time.LocalDateTime;
import java.util.Random;

public class Person extends Human{
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Person Reproduce(Person parentB, String name){
        Random chooseEthnicity = new Random();
        String childEthnicity = "";
        if(chooseEthnicity.nextInt(1,3) == 1)
            childEthnicity = ethnicity;
        else
            childEthnicity = parentB.getEthnicity();

        int averageIntelligence = (this.intelligence + parentB.getIntelligence()) / 2;
        Person child = new Person(LocalDateTime.now().toString(), childEthnicity, averageIntelligence, name);

        return child;
    }

    public void Speak(){
        Think();
        makeSound();
    }
    public void makeSound(){
        System.out.println("*says something*");
    }
    public void showEverything(){
        System.out.println("\nName: "+this.name+"\nAge: "+this.age+"\nBirthday: "+this.birthday+"\nEthnicity: "+this.ethnicity+"\nIntelligence: "+this.intelligence+"\nGender: "+this.gender+"\n");
    }
}
