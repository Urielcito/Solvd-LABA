package MySQL;

import Domain.Cell;
import Service.ICell;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CellDAO extends MySql implements ICell {
    private static final Logger logger = LogManager.getLogger(CellDAO.class);

    @Override
    public void Create(Cell cell) {
        strSQL = "INSERT INTO cell(id, health, energyPerOperation, energy, storedEnergy, oxygen, alive, maxEnergy, maxOxygen, storageCapacity) VALUES (" +
                cell.getId() + ", " + cell.getHealth() + ", " + cell.getEnergyPerOperation() + ", " + cell.getEnergy() +
                ", " + cell.getStoredEnergy() + ", " + cell.getOxygen() + ", " + cell.isAlive() + ", " + cell.getMaxEnergy() +
                ", " + cell.getMaxOxygen() + ", " + cell.getStorageCapacity() + ");";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Cell Read(int id) {
        return null;
    }

    @Override
    public void Update(Cell cell) {
        strSQL = "UPDATE cell SET health=" + cell.getHealth() + ", energyPerOperation=" + cell.getEnergyPerOperation() +
                ", energy=" + cell.getEnergy() + ", storedEnergy=" + cell.getStoredEnergy() + ", oxygen=" + cell.getOxygen() +
                ", alive=" + cell.isAlive() + ", maxEnergy=" + cell.getMaxEnergy() + ", maxOxygen=" + cell.getMaxOxygen() +
                ", storageCapacity=" + cell.getStorageCapacity() + " WHERE id=" + cell.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM cell WHERE id=" + id + ";";
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
    public List<Cell> Cells() {
        List<Cell> cells = new ArrayList<>();
        Cell c = null;
        this.select("SELECT * FROM cell");
        try {
            while (rs.next()) {
                c = new Cell(rs.getInt("id"),
                        rs.getInt("health"),
                        rs.getInt("energyPerOperation"),
                        rs.getDouble("energy"),
                        rs.getDouble("storedEnergy"),
                        rs.getDouble("oxygen"),
                        rs.getBoolean("alive"),
                        rs.getDouble("maxEnergy"),
                        rs.getDouble("maxOxygen"),
                        rs.getDouble("storageCapacity")) {
                    @Override
                    public void showEverything() {

                    }
                };
                cells.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return cells;
    }
}