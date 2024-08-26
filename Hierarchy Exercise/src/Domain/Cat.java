package Domain;

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
        meow();
    }
    public void meow(){
        System.out.println(this.meow);
    }

    @Override
    public void showEverything(){
        System.out.println("Name: " + this.name + "\nRace: "+this.race+"\nMeow style: "+this.meow+"\n");
    }

    @Override
    public String toString() {
        return "Domain.Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this.name == ((Cat) o).getName())
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        int code = Integer.parseInt(this.getMeow()) + Integer.parseInt(this.getName()); // transforms both his meow string and name string to create a code adding both values together.
        return code;
    }
}
