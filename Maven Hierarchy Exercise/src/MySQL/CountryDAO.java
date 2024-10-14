package MySQL;

import Domain.Country;
import Service.ICountry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends MySql implements ICountry {
    private static final Logger logger = LogManager.getLogger(CountryDAO.class);

    @Override
    public void Create(Country country) {
        strSQL = "INSERT INTO country(id, name) VALUES (" + country.getId() + ", '" + country.getName() + "');";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Country Read(int id) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(Country country) {
        strSQL = "UPDATE country SET name='" + country.getName() + "' WHERE id=" + country.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM country WHERE id=" + id + ";";
        boolean deleted = false;
        try {
            update(strSQL);
            deleted = true;
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return deleted;
    }

    @Override
    public List<Country> Countries() {
        List<Country> countryList = new ArrayList<>();
        Country country = null;
        this.select("SELECT * FROM country");
        try {
            while (rs.next()) {
                country = new Country(rs.getInt("id"),
                        rs.getString("name"));
                countryList.add(country);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return countryList;
    }
}
