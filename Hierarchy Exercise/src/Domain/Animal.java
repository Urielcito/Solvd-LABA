public abstract class Animal extends Cell implements Moveable{
    protected String speciesName;
    protected boolean hasFur;
    protected String type;
    protected String gender;

    protected static int animalCount;

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public boolean isFurry() {
        return hasFur;
    }

    public void setFur(boolean hasFur) {
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

    static{
        animalCount = 0;
        System.out.println("Clase Animal cargada");
    }


    public Animal(){
        super();
        this.speciesName = "";
        this.hasFur = false;
        this.type = "generic";
        this.gender = "undetermined";
        animalCount++;
    }
    public Animal(String speciesName, boolean hasFur, String type, String gender) {
        super();
        this.speciesName = speciesName;
        this.hasFur = hasFur;
        this.type = type;
        this.gender = gender;
        animalCount++;
    }

    public boolean swim(){
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

    public static int animalsCreated(){
        return animalCount;
    }
    public Animal reproduce(Animal offspring){
        offspring.speciesName = speciesName;
        offspring.hasFur = hasFur;
        offspring.type = type;

        return offspring;
    }

    public boolean jump(){
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
        return energy < initialEnergy || storedEnergy < initialStored; // return true if animal jumped succesfully
    }

    public boolean bite(Animal animalB)
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


    public abstract void makeSound();

    @Override
    public void showEverything(){
        System.out.println("Alive: "+this.alive+"\nSpecies: " + this.speciesName + "\nHas fur: " + this.hasFur + "\nType: " + this.type);
    }

}
