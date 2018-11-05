public abstract class Creatures {
    private String type, name;
    private int level;

    public Creatures(String type, String name, int level) {
        this.type = type;
        this.name = name;
        this.level = level;
    }

    public String toString() {
        return "I am a " + type + "pocket creature. \nMy name is " + name + ".";
    }
}
