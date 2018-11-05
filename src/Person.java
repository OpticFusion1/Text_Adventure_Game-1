/**
 * Person represents the player as they move through the game.
 */
public class Person {
    int xLoc, yLoc, health;

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public Person (int xLoc, int yLoc, int health)
    {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.health = health;
    }


}