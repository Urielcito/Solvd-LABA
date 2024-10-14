package Service;

import Domain.Identity;

import java.util.List;

public interface IIdentity {
    public void Create(Identity i);
    public Identity Read(int id);
    public void Update(Identity i);

    public boolean Delete(int id);

    public List<Identity> Identities();
}
