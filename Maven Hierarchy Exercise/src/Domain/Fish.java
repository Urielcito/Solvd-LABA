package Domain;

import java.util.Random;
public class Fish extends Animal{
    int id;
    double weight;
    int eggsLayed;



    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getEggsLayed() {
        return eggsLayed;
    }

    public void setEggsLayed(int eggsLayed) {
        this.eggsLayed = eggsLayed;
    }

    public Fish(int id, double weight, int eggsLayed) {
        super();
        this.id = id;
        this.weight = weight;
        this.eggsLayed = eggsLayed;
    }
    public Fish() {
        super();
        this.speciesName = "Domain.Fish";
        this.hasFur = false;
        this.type = "aquatic";
        Random r = new Random();
        this.weight = r.nextDouble(1,10);
        this.eggsLayed = 0;
    }

    public Fish(double weight) {
        super();
        this.speciesName = "Domain.Fish";
        this.hasFur = false;
        this.type = "aquatic";
        Random r = new Random();
        this.weight = weight;
        this.eggsLayed = 0;
    }

    public void LayEggs(){
        Random r = new Random();
        long amount = Math.round(weight);
        this.eggsLayed += r.nextLong(25, 25+amount);
    }

    public void makeSound(){
        System.out.println("Glu Glu Glu");
    }

    @Override
    public void showEverything(){
        System.out.println("Eggs layed: "+this.eggsLayed+" eggs.\nWeight: "+this.weight+" kg.");
    }
}
