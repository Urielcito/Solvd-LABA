package Domain;

import Service.Thinker;

import java.sql.Date;
import java.util.Random;

public abstract class Human extends Animal implements Thinker {
    protected int id;
    protected int age;
    protected String birthday;
    protected int intelligence;

    protected String ethnicity;




    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }
    public Human(int id, int age, String birthday, int intelligence, String ethnicity) {
        super();
        this.id = id;
        this.age = age;
        this.birthday = birthday;
        this.intelligence = intelligence;
        this.ethnicity = ethnicity;
    }

    public Human(){
        super();
        this.speciesName = "Domain.Human";
        this.hasFur = false;
        this.type = "bipedal omnivore";
        this.gender = "undetermined";
    }
    public Human(String birthday, String ethnicity, int averageIntelligence) {
        super();
        this.speciesName = "Domain.Human";
        this.hasFur = false;
        this.type = "bipedal omnivore";
        this.age = 1;
        this.birthday = birthday;
        this.ethnicity = ethnicity;

        String randomGender = "female";
        Random r = new Random();
        if(r.nextInt(1,3) == 1)
            randomGender = "male";
        this.gender = randomGender;
        this.intelligence = r.nextInt(0, averageIntelligence / 10);
    }

    public boolean think(){
        int success = intelligence;
        if(success < 10);
            success = 10;

        Random thinkProcess = new Random();
        int thought = thinkProcess.nextInt(0, 250);
        int reward = 0;
        if(thought < success)
            reward = thinkProcess.nextInt(5,10);
        else
            reward = thinkProcess.nextInt(0,3);

        intelligence += reward;
        return thought < success; //true if the thinking was effective
    }
    public boolean solveProblem(){
        boolean solved = false;
        if(health != 0)
        {
            if (storedEnergy > energyPerOperation)
                spendStoredEnergy(energyPerOperation);
            else
                spendEnergy(energyPerOperation);
            spendOxygen(energyPerOperation);

            if (energy <= 0 && eat() == false)
                takeDamage(energyPerOperation);
            solved = think();
        }
        return solved;
    }

    @Override
    public int searchForFood() {
        int food = 0;
        Random r = new Random();
        double rateOfSuccess = 100 - energy;
        int amountOfTries = r.nextInt(0, 6);
        while (energy > energyPerOperation - 10 && amountOfTries != 0) {
            move();
            solveProblem();
            double chanceToFindFood = r.nextDouble(0, 100);
            if (chanceToFindFood > rateOfSuccess)
                food++;
            amountOfTries--;
        }
        storedEnergy += food * 100;
        eat();
        return food;
    }

    @Override
    public void showEverything(){
        System.out.println("Name: ");
    }
}
