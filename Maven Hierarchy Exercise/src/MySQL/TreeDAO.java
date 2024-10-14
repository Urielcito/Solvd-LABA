package MySQL;

import Domain.Tree;
import Service.ITree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreeDAO extends MySql implements ITree {
    private static final Logger logger = LogManager.getLogger(TreeDAO.class);

    @Override
    public void Create(Tree tree) {
        strSQL = "INSERT INTO tree(id, height, humidity) VALUES (" +
                tree.getId() + ", " + tree.getHeight() + ", " + tree.getHumidity() + ");";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Tree Read(int id) {
        return null; // Implementation as needed
    }

    @Override
    public void Update(Tree tree) {
        strSQL = "UPDATE tree SET height=" + tree.getHeight() +
                ", humidity=" + tree.getHumidity() +
                " WHERE id=" + tree.getId() + ";";
        try {
            update(strSQL);
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id) {
        strSQL = "DELETE FROM tree WHERE id=" + id + ";";
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
    public List<Tree> Trees() {
        List<Tree> treeList = new ArrayList<>();
        Tree tree = null;
        this.select("SELECT * FROM tree");
        try {
            while (rs.next()) {
                tree = new Tree(rs.getInt("id"),
                        rs.getInt("height"),
                        rs.getInt("humidity"));
                treeList.add(tree);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: " + ex.getMessage());
        }
        return treeList;
    }
}
