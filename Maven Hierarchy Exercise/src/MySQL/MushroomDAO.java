package MySQL;

import Domain.Mushroom;
import Service.IMushroom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MushroomDAO extends MySql implements IMushroom {
    private static final Logger logger = LogManager.getLogger(MushroomDAO.class);

    @Override
    public void Create(Mushroom mushroom) {
        strSQL = "INSERT INTO mushroom(id, areaCovered, count) VALUES (" + mushroom.getId() + ", " + mushroom.getAreaCovered() + ", " + mushroom.getCount() + ");";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Mushroom Read(int id) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(Mushroom mushroom) {
        strSQL = "UPDATE mushroom SET areaCovered=" + mushroom.getAreaCovered() + ", count=" + mushroom.getCount() + " WHERE id=" + mushroom.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM mushroom WHERE id=" + id + ";";
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
    public List<Mushroom> Mushrooms() {
        List<Mushroom> mushroomList = new ArrayList<>();
        Mushroom mushroom = null;
        this.select("SELECT * FROM mushroom");
        try {
            while (rs.next()) {
                mushroom = new Mushroom(rs.getInt("id"),
                        rs.getInt("areaCovered"),
                        rs.getInt("count"));
                mushroomList.add(mushroom);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return mushroomList;
    }
}
