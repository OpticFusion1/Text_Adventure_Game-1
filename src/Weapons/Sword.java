package Weapons;

public class Sword implements Weapon{
    private String name;

    public Sword(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
