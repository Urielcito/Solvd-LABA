public class GuineaPig extends Animal{

    private String name;
    private String race;

    private enum actions{
        ASK_FOR_FOOD, APPRECIATE_PATS, ANGRY, DANGER,CURIOUS
    };

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

    public GuineaPig(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public void makeSound(){
        System.out.println("cui cui cui");
    }

    public void makeSound(actions a){
        switch(a){
            case ANGRY:
                System.out.println("*teeth chattering*");
                break;
            case DANGER:
                System.out.println("*bird noises*");
                break;
            case CURIOUS:
                System.out.println("*curious guinea pig noises*");
                break;
            case ASK_FOR_FOOD:
                System.out.println("CUIIIIIIIII CUIIIIIIIIIII CUIIIIIIIIIIII *bites cage*");
                break;
            case APPRECIATE_PATS:
                System.out.println("*nothing*");
                break;
        }
    }
    public void showEverything(){

    }


}
