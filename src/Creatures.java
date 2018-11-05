public abstract class Creatures {
    private String type;

    public Creatures(String type) {
        this.type = type;
    }

    public String toString() {
        return "I am a " + type + "pocket creature.";
    }
}
