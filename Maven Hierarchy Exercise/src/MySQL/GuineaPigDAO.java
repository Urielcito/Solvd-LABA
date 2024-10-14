package MySQL;

import Domain.GuineaPig;
import Service.IGuineaPig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuineaPigDAO extends MySql implements IGuineaPig {
    private static final Logger logger = LogManager.getLogger(GuineaPigDAO.class);

    @Override
    public void Create(GuineaPig guineaPig) {
        strSQL = "INSERT INTO guineapig(id, name, race) VALUES (" + guineaPig.getId() + ", '" + guineaPig.getName() + "', '" + guineaPig.getRace() + "');";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public GuineaPig Read(int id) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(GuineaPig guineaPig) {
        strSQL = "UPDATE guineapig SET name='" + guineaPig.getName() + "', race='" + guineaPig.getRace() + "' WHERE id=" + guineaPig.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM guineapig WHERE id=" + id + ";";
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
    public List<GuineaPig> GuineaPigs() {
        List<GuineaPig> guineaPigList = new ArrayList<>();
        GuineaPig guineaPig = null;
        this.select("SELECT * FROM guineapig");
        try {
            while (rs.next()) {
                guineaPig = new GuineaPig(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("race"));
                guineaPigList.add(guineaPig);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return guineaPigList;
    }
}
