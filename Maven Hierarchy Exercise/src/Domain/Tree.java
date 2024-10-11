package Domain;

import Service.Growable;

import java.util.Random;

public class Tree extends Plant implements Growable {
    private int id;
    private int height;
    private int humidity;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Tree(){
        super();
        this.receivesSunlight = true;
        this.isWatered = true;
        this.height = 1;
        this.humidity = 5;
    }
    public Tree(Boolean receivesSunlight, Boolean isWatered, int height, int humidity) {
        super(receivesSunlight, isWatered);
        this.height = height;
        this.humidity = humidity;
    }

    public void grow(){
        if(isWatered)
        {
            height += 2;
            if(height > 100)
                height = 100;
            releaseOxygen();
            isWatered = false;
        }
    }

    private boolean absorbWater(){
        Random waterAbsorption = new Random();
        int waterAbsorbed = 0;
        waterAbsorbed = waterAbsorption.nextInt(0,10);
        if(waterAbsorbed < humidity)
            this.isWatered = true;
        return this.isWatered;
    }
    @Override
    public int searchForFood(){
        int food = 0;
        if(isWatered == false)
            absorbWater();
        if(receivesSunlight && isWatered)
            food = 100;
        storedEnergy += food * 60;
        eat();
        grow();
        releaseOxygen();
        this.isWatered=false;
        return food;
    }

    @Override
    public void showEverything(){
        System.out.println("Environment humidity: " +this.humidity+"\nHeight: "+this.height);
    }
}
