package MySQL;

import Domain.Fish;
import Service.IFish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FishDAO extends MySql implements IFish {
    private static final Logger logger = LogManager.getLogger(FishDAO.class);

    @Override
    public void Create(Fish aFish) {
        strSQL = "INSERT INTO fish(id, weight, eggsLayed) VALUES (" + aFish.getId() + ", " + aFish.getWeight() + ", " + aFish.getEggsLayed() + ");";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Fish Read(int id) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(Fish fish) {
        strSQL = "UPDATE fish SET weight=" + fish.getWeight() + ", eggsLayed=" + fish.getEggsLayed() + " WHERE id=" + fish.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM fish WHERE id=" + id + ";";
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
    public List<Fish> theFish() {
        List<Fish> fishList = new ArrayList<>();
        Fish fish = null;
        this.select("SELECT * FROM fish");
        try {
            while (rs.next()) {
                fish = new Fish(rs.getInt("id"),
                        rs.getDouble("weight"),
                        rs.getInt("eggsLayed"));
                fishList.add(fish);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return fishList;
    }
}
