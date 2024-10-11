package Service;

import Domain.Plant;

import java.util.List;

public interface IPlant {
    public void Create(Plant p);
    public Plant Read(int id);
    public void Update(Plant p);

    public boolean Delete(int id);

    public List<Plant> Plants();
}
