package Service;

import Domain.Country;

import java.util.List;

public interface ICountry {
    public void Create(Country c);
    public Country Read(int id);
    public void Update(Country c);

    public boolean Delete(int id);

    public List<Country> Countries();
}
