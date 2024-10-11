package Service;

import Domain.Fish;

import java.util.List;

public interface IFish {
    public void Create(Fish f);
    public Fish Read(int id);
    public void Update(Fish f);

    public boolean Delete(int id);

    public List<Fish> theFish();
}
