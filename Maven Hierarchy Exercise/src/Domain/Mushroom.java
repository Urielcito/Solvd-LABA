package Domain;

import java.util.Random;

public class Mushroom extends Cell{
    private int id;
    private int areaCovered;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(int areaCovered) {
        this.areaCovered = areaCovered;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Mushroom(){
        super();
        this.areaCovered = 2;
        this.count = 1;
    }
    public Mushroom(int count) {
        super();
        this.areaCovered = (count / 3) * 2;
        this.count = count;
    }

    public void releaseSpores(){
        spendOxygen(10);
        Random r = new Random();
        int amount = r.nextInt(2,15);
        this.count *= amount;
        areaCovered = (this.count / 3) * 2;
    }
    private double releaseCO2(double oxygen){
        double CO2 = oxygen;
        return CO2;
    }

    @Override
    protected void breathe(){
        oxygen = 100;
        releaseCO2(oxygen);
    }

    @Override
    public void showEverything(){
        System.out.println("Quantity of Mushrooms in community: " + this.count + "\nArea covered: "+this.areaCovered +" square meters.\n");
    }
}
