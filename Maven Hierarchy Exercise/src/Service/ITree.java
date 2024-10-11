package Service;

import Domain.Tree;

import java.util.List;

public interface ITree {
    public void Create(Tree t);
    public Tree Read(int id);
    public void Update(Tree t);

    public boolean Delete(int id);

    public List<Tree> Trees();
}
