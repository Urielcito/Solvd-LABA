import java.util.Random;

public class Tree extends Plant{
    private int height;
    private int humidity;

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

    private void Grow(){
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
    public int searchForFood(){
        int food = 0;
        if(isWatered == false)
            absorbWater();
        if(receivesSunlight && isWatered)
            food = 100;
        storedEnergy += food * 60;
        Eat();
        Grow();
        releaseOxygen();
        this.isWatered=false;
        return food;
    }

    public void showEverything(){
        System.out.println("Environment humidity: " +this.humidity+"\nHeight: "+this.height);
    }
}
