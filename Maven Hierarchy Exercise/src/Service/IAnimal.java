package Service;

import Domain.Animal;

import java.util.List;

public interface IAnimal {
    public void Create(Animal a);
    public Animal Read(int id);
    public void Update(Animal a);

    public boolean Delete(int id);

    public List<Animal> Animals();
}
