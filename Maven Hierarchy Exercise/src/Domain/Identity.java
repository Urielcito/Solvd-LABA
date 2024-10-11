package Domain;

public class Identity {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Identity(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "number=" + number +
                '}';
    }
}
