package MySQL;

import Domain.Identity;
import Service.IIdentity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdentityDAO extends MySql implements IIdentity {
    private static final Logger logger = LogManager.getLogger(IdentityDAO.class);

    @Override
    public void Create(Identity identity) {
        strSQL = "INSERT INTO identity(number) VALUES (" + identity.getNumber() + ");";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Identity Read(int number) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(Identity identity) {
        strSQL = "UPDATE identity SET number=" + identity.getNumber() + " WHERE number=" + identity.getNumber() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int number) {
        strSQL = "DELETE FROM identity WHERE number=" + number + ";";
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
    public List<Identity> Identities() {
        List<Identity> identityList = new ArrayList<>();
        Identity identity = null;
        this.select("SELECT * FROM identity");
        try {
            while (rs.next()) {
                identity = new Identity(rs.getInt("number"));
                identityList.add(identity);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return identityList;
    }
}
