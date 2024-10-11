package Domain;

import Service.Eater;

import java.util.Random;

public abstract class Cell implements Eater {
    protected int id;
    protected int health;
    protected int energyPerOperation;
    protected double energy;
    protected double storedEnergy;
    protected double oxygen;

    protected boolean alive;

    protected double maxEnergy = 100;
    protected double maxOxygen = 100;

    protected double storageCapacity = 1000;

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

    final public boolean isAlive() {
        return alive;
    }

    public Cell() {
        this.id = id;
        this.health = 100;
        this.energyPerOperation = 20;
        this.storedEnergy = 0;
        this.energy = 100;
        this.oxygen = 100;
        this.alive = true;
    }

    public Cell(int id, int health, int energyPerOperation, double energy, double storedEnergy, double oxygen, boolean alive) {
        this.id = id;
        this.health = health;
        this.energyPerOperation = energyPerOperation;
        this.storedEnergy = storedEnergy;
        this.energy = energy;
        this.oxygen = oxygen;
        this.alive = alive;
    }

    public abstract void showEverything();

    final protected void kill() {
        this.alive = false;
        this.energyPerOperation = 0;
        this.oxygen = 0;
        this.energy = 0;
        this.storedEnergy = 0;
    }

    protected void breathe() {
        oxygen = 100;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            kill();
        }
    }

    protected void spendOxygen(double energyUsed) {
        oxygen -= energyUsed / 2;
        if (oxygen < (energyPerOperation/2))
            breathe();
    }
    protected void spendEnergy(double energyUsed){
        energy -= energyUsed;
        if(energy < 0)
            energy = 0;
    }
    protected void spendStoredEnergy(double energyUsed){
        storedEnergy -= energyUsed;
        if(storedEnergy < 0)
            storedEnergy = 0;
    }

    public boolean move() {
        double initialEnergy = energy;
        double initialStored = storedEnergy;
        if(health != 0)
        {
            if (storedEnergy > energyPerOperation)
                spendStoredEnergy(energyPerOperation);
            else
                spendEnergy(energyPerOperation);
            spendOxygen(energyPerOperation);

            if (energy <= 0 && eat() == false)
                takeDamage(energyPerOperation);
        }
        return energy < initialEnergy || storedEnergy < initialStored; // return true if cell moved successfully
    }

    public boolean eat() {
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
            move();
            double chanceToFindFood = r.nextDouble(0, 100);
            if (chanceToFindFood > rateOfSuccess)
                food++;
            amountOfTries--;
        }
        storedEnergy += food * 60;
        eat();
        return food;
    }
}
