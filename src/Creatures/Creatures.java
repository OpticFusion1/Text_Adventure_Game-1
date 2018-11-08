package Creatures;

public abstract class Creatures {
    private String type;
    private int level;

    public Creatures(String type) {
        this.type = type;
    }

    public String toString() {
        return "I am an " + type + " pocket creature.";
    }
}
