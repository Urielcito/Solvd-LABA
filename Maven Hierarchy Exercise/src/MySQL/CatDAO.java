package MySQL;

import Domain.Animal;
import Domain.Cat;
import Service.ICat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatDAO extends MySql implements ICat {
    private static final Logger logger = LogManager.getLogger(CatDAO.class);
    @Override
    public void Create(Cat anCat){
        strSQL = "INSERT INTO cat(id, name, race, meow) VALUES ("+anCat.getId()+", '"+anCat.getName()+"', '"+anCat.getMeow()+"');";
        try{
            update(strSQL);
        } catch(SQLException ex){
            logger.error("SQLException: "+ex.getMessage());
        }
    }

    @Override
    public Cat Read(int id){
        return null;
    }

    @Override
    public void Update(Cat c){
        strSQL = "UPDATE cat SET id="+c.getId()+", name='"+c.getName()+"', race='"+c.getRace()+"', meow='"+c.getMeow()+"' WHERE id="+c.getId();
        try{
            update(strSQL);
        }catch(SQLException ex){
            logger.error("SQLException: "+ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id){
        strSQL = "DELETE FROM cat WHERE id='"+id+"'";
        boolean deleted = false;
        try{
            update(strSQL);
            deleted = true;
        }catch(SQLException ex){
            logger.error("SQLException: "+ex.getMessage());
        }
        return deleted;
    }

    public List<Cat> Cats() {
        List<Cat> Cats = new ArrayList<Cat>();
        Cat c = null;
        this.select("SELECT * FROM animal");
        try {
            while (rs.next()) {
                c = new Cat(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("race"),
                        rs.getString("meow")) {
                    @Override
                    public void makeSound() {
                        System.out.println("sound!");
                    }
                };
                Cats.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: "+ex.getMessage());
        }
        return Cats;
    }
}
