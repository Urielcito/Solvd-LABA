public abstract class Animal extends Cell{
    protected String speciesName;
    protected boolean hasFur;
    protected String type;
    protected String gender;

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Animal(){
        super();
        this.speciesName = "";
        this.hasFur = false;
        this.type = "generic";
        this.gender = "undetermined";
    }
    public Animal(String speciesName, boolean hasFur, String type, String gender) {
        super();
        this.speciesName = speciesName;
        this.hasFur = hasFur;
        this.type = type;
        this.gender = gender;
    }

    public boolean Swim(){
        double initialEnergy = energy;
        double initialStored = storedEnergy;
        if(health != 0)
        {
            if (storedEnergy > energyPerOperation)
                spendStoredEnergy(energyPerOperation);
            else
                spendEnergy(energyPerOperation);
            spendOxygen(energyPerOperation);

            if (energy <= 0) // can't eat while in water body
                takeDamage(energyPerOperation);
        }
        return energy < initialEnergy || storedEnergy < initialStored; // return true if animal swimmed successfully
    }

    public Animal Reproduce(Animal offspring){
        offspring.speciesName = speciesName;
        offspring.hasFur = hasFur;
        offspring.type = type;

        return offspring;
    }

    public boolean Jump(){
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
        return energy < initialEnergy || storedEnergy < initialStored; // return true if animal jumped succesfully
    }

    public boolean Bite(Animal animalB)
    {
        double initialEnergy = energy;
        double initialStored = storedEnergy;
        if(health != 0)
        {
            if (storedEnergy > energyPerOperation)
                spendStoredEnergy(energyPerOperation);
            else
                spendEnergy(energyPerOperation);
            spendOxygen(energyPerOperation);

            if (energy <= 0) // can't eat while fighting
                takeDamage(energyPerOperation);
        }
        return energy < initialEnergy || storedEnergy < initialStored; // return true if animal bite was successful
    }



    public void showEverything(){
        System.out.println("Alive: "+this.alive+"\nSpecies: " + this.speciesName + "\nHas fur: " + this.hasFur + "\nType: " + this.type);
    }

}
