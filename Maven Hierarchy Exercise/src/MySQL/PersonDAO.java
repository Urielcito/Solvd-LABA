package MySQL;

import Domain.Person;
import Service.IPerson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends MySql implements IPerson {
    private static final Logger logger = LogManager.getLogger(PersonDAO.class);

    @Override
    public void Create(Person person) {
        strSQL = "INSERT INTO person(id, name, identity, countryId) VALUES (" +
                person.getId() + ", '" + person.getName() + "', " + person.getIdentity() +
                ", " + person.getCountryId() + ");";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Person Read(int id) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(Person person) {
        strSQL = "UPDATE person SET name='" + person.getName() +
                "', identity=" + person.getIdentity() +
                ", countryId=" + person.getCountryId() +
                " WHERE id=" + person.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM person WHERE id=" + id + ";";
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
    public List<Person> Persons() {
        List<Person> personList = new ArrayList<>();
        Person person = null;
        this.select("SELECT * FROM person");
        try {
            while (rs.next()) {
                person = new Person(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("identity"),
                        rs.getInt("countryId"));
                personList.add(person);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return personList;
    }
}
