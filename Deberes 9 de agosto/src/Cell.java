import java.util.Random;

public class Cell {
    private int health;
    private int energyPerOperation;
    private double energy;
    private double storedEnergy;
    private double oxygen;

    private boolean alive;

    private double maxEnergy = 100;
    private double maxOxygen = 100;

    private double storageCapacity = 1000;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEnergyPerOperation() {
        return energyPerOperation;
    }

    public void setEnergyPerOperation(int energyPerOperation) {
        this.energyPerOperation = energyPerOperation;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getStoredEnergy() {
        return storedEnergy;
    }

    public void setStoredEnergy(double storedEnergy) {
        this.storedEnergy = storedEnergy;
    }

    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public boolean isAlive() {
        return alive;
    }

    public void Kill(boolean alive) {
        this.alive = alive;
    }

    public Cell() {
        this.health = 100;
        this.energyPerOperation = 20;
        this.storedEnergy = 0;
        this.energy = 100;
        this.oxygen = 100;
        this.alive = true;
    }

    public Cell(int health, int energyPerOperation, double energy, double storedEnergy, double oxygen, boolean alive) {
        this.health = health;
        this.energyPerOperation = energyPerOperation;
        this.storedEnergy = storedEnergy;
        this.energy = energy;
        this.oxygen = oxygen;
        this.alive = alive;
    }

    public void showEverything(){
        System.out.println("Health: " + this.health + "\nEnergy: " + this.energy + "\nStored energy: " + storedEnergy + "\nOxygen: " + this.oxygen + "\nAlive: " + alive);
    }

    private void Kill() {
        this.alive = false;
        this.energyPerOperation = 0;
        this.oxygen = 0;
        this.energy = 0;
        this.storedEnergy = 0;
    }

    private void Breathe() {
        oxygen = 100;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            Kill();
        }
    }

    private void spendOxygen(double energyUsed) {
        oxygen -= energyUsed / 2;
        if (oxygen < (energyPerOperation/2))
            Breathe();
    }
    private void spendEnergy(double energyUsed){
        energy -= energyUsed;
        if(energy < 0)
            energy = 0;
    }
    private void spendStoredEnergy(double energyUsed){
        storedEnergy -= energyUsed;
        if(storedEnergy < 0)
            storedEnergy = 0;
    }

    public boolean Move() {
        double initialEnergy = energy;
        double initialStored = storedEnergy;
        if(health != 0)
        {
            if (storedEnergy > energyPerOperation)
                spendStoredEnergy(energyPerOperation);
            else
                spendEnergy(energyPerOperation);
            spendOxygen(energyPerOperation);

            if (energy <= 0 && Eat() == false)
                takeDamage(energyPerOperation);
        }
        return energy < initialEnergy || storedEnergy < initialStored; // return true if cell moved successfully
    }

    public boolean Eat() {
        double initialStored = storedEnergy;
            while (storedEnergy != 0 && energy < 100) {
                energy += 1;
                storedEnergy -= 1;
        }
        return storedEnergy < initialStored; // return true if cell ate successfully
    }

    public int searchForFood() {
        int food = 0;
        Random r = new Random();
        double rateOfSuccess = 100 - energy;
        int amountOfTries = r.nextInt(0, 6);
        while (energy > energyPerOperation && amountOfTries != 0) {
            Move();
            double chanceToFindFood = r.nextDouble(0, 100);
            if (chanceToFindFood > rateOfSuccess)
                food++;
            amountOfTries--;
        }
        storedEnergy += food * 60;
        Eat();
        return food;
    }
}
