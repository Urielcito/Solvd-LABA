package Enums;

// Simple and small complex enum with just some fields and one method
public enum Day {
    MONDAY("Weekday"), TUESDAY("Weekday"), WEDNESDAY("Weekday"),
    THURSDAY("Weekday"), FRIDAY("Weekday"), SATURDAY("Weekend"), SUNDAY("Weekend");

    private final String type;

    Day(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
