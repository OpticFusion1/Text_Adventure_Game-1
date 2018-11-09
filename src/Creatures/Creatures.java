package Creatures;

public abstract class Creatures {
    private String type;
    private int level;

    public Creatures(String type) {
        this.type = type;
    }

    public String toString() {
        if (type.equals("Earth") || type.equals("Air"))
            return "I am an " + type + " pocket creature.";
        else
            return "I am a " + type + " pocket creature.";
    }
}
