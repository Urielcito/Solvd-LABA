package MySQL;

import Domain.Plant;
import Service.IPlant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantDAO extends MySql implements IPlant {
    private static final Logger logger = LogManager.getLogger(PlantDAO.class);

    @Override
    public void Create(Plant plant) {
        strSQL = "INSERT INTO plant(id, receivesSunlight, isWatered) VALUES (" +
                plant.getId() + ", " + plant.getReceivesSunlight() + ", " + plant.getWatered() + ");";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Plant Read(int id) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(Plant plant) {
        strSQL = "UPDATE plant SET receivesSunlight=" + plant.getReceivesSunlight() +
                ", isWatered=" + plant.getWatered() +
                " WHERE id=" + plant.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM plant WHERE id=" + id + ";";
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
    public List<Plant> Plants() {
        List<Plant> plantList = new ArrayList<>();
        Plant plant = null;
        this.select("SELECT * FROM plant");
        try {
            while (rs.next()) {
                plant = new Plant(rs.getInt("id"),
                        rs.getBoolean("receivesSunlight"),
                        rs.getBoolean("isWatered"));
                plantList.add(plant);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return plantList;
    }
}
