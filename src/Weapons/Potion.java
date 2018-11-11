package Weapons;

public class Potion implements Weapon{
    private String name;

    public Potion(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
