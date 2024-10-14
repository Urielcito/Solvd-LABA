package MySQL;

import Domain.Animal;
import Service.IAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO extends MySql implements IAnimal {
    private static final Logger logger = LogManager.getLogger(CatDAO.class);
    @Override
    public void Create(Animal anAnimal){
        strSQL = "INSERT INTO animal(id, speciesName, hasFur, type, gender, ownerId) VALUES ("+anAnimal.getId()+", '"+anAnimal.getSpeciesName()+"', "+anAnimal.isFurry()+", '"+anAnimal.getType()+"', '"+anAnimal.getGender()+"', "+anAnimal.getOwnerId()+");";
        try {
            update(strSQL);
        }catch(SQLException ex){
            logger.error("SQLException: "+ex.getMessage());
        }
    }

    @Override
    public Animal Read(int id){
        return null;
    }

    @Override
    public void Update(Animal a){
        strSQL = "UPDATE animal SET id='" + a.getId() + "',speciesName='" +a.getSpeciesName()+"', hasFur='" + a.isFurry()+ "', type='"+a.getType()+"', gender='"+a.getGender()+"', ownerId='"+a.getOwnerId()+"' WHERE id=" + a.getId();
        try {
            update(strSQL);
        }catch(SQLException ex){
            logger.error("SQLException: "+ex.getMessage());
        }
    }

    @Override
    public boolean Delete(int id){
        strSQL = "DELETE FROM animal WHERE id='"+id+"'";
        boolean deleted = false;
        try{
            update(strSQL);
            deleted = true;
        }catch(SQLException ex){
            logger.error("SQLException: "+ex.getMessage());
        }
        return deleted;

    }

    @Override
    public List<Animal> Animals() {
        List<Animal> Animals = new ArrayList<Animal>();
        Animal a = null;
        this.select("SELECT * FROM animal");
        try {
            while (rs.next()) {
                a = new Animal(rs.getInt("id"),
                        rs.getString("speciesName"),
                        rs.getBoolean("hasFur"),
                        rs.getString("type"),
                        rs.getString("gender"),
                        rs.getInt("ownerId")) {
                    @Override
                    public void makeSound() {
                        System.out.println("sound!");
                    }
                };
                Animals.add(a);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("SQLException: "+ex.getMessage());
        }
        return Animals;
    }
    
}
