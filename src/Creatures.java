public abstract class Creatures {
    private String type, name;
    private int level;

    public Creatures(String type) {
        this.type = type;
    }

    public String toString() {
        return "I am an " + type + " pocket creature.";
    }
}
