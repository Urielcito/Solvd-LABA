package Service;

import Domain.Animal;
import Domain.Cat;

import java.util.List;

public interface ICat {
    public void Create(Cat c);
    public Cat Read(int id);
    public void Update(Cat c);

    public boolean Delete(int id);

    public List<Cat> Cats();
}
