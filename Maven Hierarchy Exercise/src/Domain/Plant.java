package Domain;

public class Plant extends Cell{
    protected int id;
    protected Boolean receivesSunlight;
    protected Boolean isWatered;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getReceivesSunlight() {
        return receivesSunlight;
    }

    public void setReceivesSunlight(Boolean receivesSunlight) {
        this.receivesSunlight = receivesSunlight;
    }

    public Boolean getWatered() {
        return isWatered;
    }

    public void setWatered(Boolean watered) {
        isWatered = watered;
    }

    public Plant(){
        super();
    }
    public Plant(int id, Boolean receivesSunlight, Boolean isWatered) {
        super();
        this.id = id;
        this.receivesSunlight = receivesSunlight;
        this.isWatered = isWatered;
    }

    protected void releaseOxygen(){
        this.oxygen = 0;
        breathe();
    }

    @Override
    public boolean move(){
        System.out.println("The plant can't move, instead it will release oxygen.");
        releaseOxygen();
        return false;
    }

    @Override
    public int searchForFood(){
        int food = 0;
        if(receivesSunlight && isWatered)
            food = 100;
        storedEnergy += food * 60;
        eat();
        this.isWatered=false;
        return food;
    }

    public void water(){
        this.isWatered=true;
    }

    @Override
    public void showEverything(){
        System.out.println("Receives sunlight: " +this.receivesSunlight+"\nIs watered: "+this.isWatered);
    }
}
