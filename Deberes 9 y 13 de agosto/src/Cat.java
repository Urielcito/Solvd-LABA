public class Cat extends Animal{

    private String name;
    private String race;
    private String meow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    public Cat(String name, String race, String meow) {
        super();
        this.speciesName = "feline";
        this.hasFur = true;
        this.type = "cat";
        this.name = name;
        this.race = race;
        this.meow = meow;
    }
    public void makeSound(){
        Meow();
    }
    public void Meow(){
        System.out.println(this.meow);
    }

    public void showEverything(){
        System.out.println("\nName: " + this.name + "Race: "+this.race+"\nMeow style: "+this.meow+"\n");
    }
}
