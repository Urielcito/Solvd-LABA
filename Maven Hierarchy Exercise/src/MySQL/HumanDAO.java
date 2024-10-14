package MySQL;

import Domain.Human;
import Service.IHuman;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HumanDAO extends MySql implements IHuman {
    private static final Logger logger = LogManager.getLogger(HumanDAO.class);

    @Override
    public void Create(Human human) {
        strSQL = "INSERT INTO human(id, age, birthday, intelligence, ethnicity) VALUES (" +
                human.getId() + ", " + human.getAge() + ", '" + human.getBirthday() + "', " +
                human.getIntelligence() + ", '" + human.getEthnicity() + "');";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Human Read(int id) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(Human human) {
        strSQL = "UPDATE human SET age=" + human.getAge() +
                ", birthday='" + human.getBirthday() +
                "', intelligence=" + human.getIntelligence() +
                ", ethnicity='" + human.getEthnicity() +
                "' WHERE id=" + human.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM human WHERE id=" + id + ";";
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
    public List<Human> Humans() {
        List<Human> humanList = new ArrayList<>();
        Human human = null;
        this.select("SELECT * FROM human");
        try {
            while (rs.next()) {
                human = new Human(rs.getInt("id"),
                        rs.getInt("age"),
                        rs.getString("birthday"),
                        rs.getInt("intelligence"),
                        rs.getString("ethnicity")) {
                    @Override
                    public void makeSound() {

                    }
                };
                humanList.add(human);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return humanList;
    }
}
