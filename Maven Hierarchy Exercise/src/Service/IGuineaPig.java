package Service;

import Domain.GuineaPig;

import java.util.List;

public interface IGuineaPig {
    public void Create(GuineaPig g);
    public GuineaPig Read(int id);
    public void Update(GuineaPig g);

    public boolean Delete(int id);

    public List<GuineaPig> GuineaPigs();
}
