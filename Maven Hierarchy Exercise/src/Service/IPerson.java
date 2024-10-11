package Service;

import Domain.Person;

import java.util.List;

public interface IPerson {
    public void Create(Person p);
    public Person Read(int id);
    public void Update(Person p);

    public boolean Delete(int id);

    public List<Person> Persons();
}
