package Service;

import Domain.Mushroom;

import java.util.List;

public interface IMushroom {
    public void Create(Mushroom m);
    public Mushroom Read(int id);
    public void Update(Mushroom m);

    public boolean Delete(int id);

    public List<Mushroom> Mushrooms();
}
