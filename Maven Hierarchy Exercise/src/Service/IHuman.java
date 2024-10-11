package Service;

import Domain.Human;

import java.util.List;

public interface IHuman {
    public void Create(Human h);
    public Human Read(int id);
    public void Update(Human h);

    public boolean Delete(int id);

    public List<Human> Humans();
}
