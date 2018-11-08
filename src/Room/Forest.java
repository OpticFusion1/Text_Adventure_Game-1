package Room;

public class Forest extends Room {
    public Forest(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You are now in the forest. Since this is a magical house, there is a forest inside the house.");
    }
}