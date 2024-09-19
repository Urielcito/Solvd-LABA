package Enums;

// Simple, even smaller enum to demonstrate the use of static blocks
public enum Priority {
    LOW, MEDIUM, HIGH;

    static {
        System.out.println("Priority Enum Loaded");
    }

    public void printPriority() {
        System.out.println(this.name() + " Priority");
    }
}
