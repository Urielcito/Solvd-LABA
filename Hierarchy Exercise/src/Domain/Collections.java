package Domain;

import java.util.ArrayList;

public class Collections {
    public ArrayList<Person> friends;
    public ArrayList<Animal> pets;
    public ArrayList<Person> students;
    public ArrayList<Person> workers;

    public Collections(){
        friends = new ArrayList<Person>();
        pets = new ArrayList<Animal>();
        students = new ArrayList<Person>();
        workers = new ArrayList<Person>();
    }
}
