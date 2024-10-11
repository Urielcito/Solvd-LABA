package Service;

import Domain.Cell;

import java.util.List;

public interface ICell {
    public void Create(Cell c);
    public Cell Read(int id);
    public void Update(Cell c);

    public boolean Delete(int id);

    public List<Cell> Cells();
}
