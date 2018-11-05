import java.util.Scanner;
import java.lang.String;

public class Runner {

    private static boolean gameOn = true;

    public static String[] firstNames = {"Ashley", "Ben", "Chris", "David", "Evelyn", "Franny", "Gabe", "Hayley", "Ina", "Janet", "Kevin", "Larry"};
    //private static Person player1 = new Person(0,0,10,1);

    public static void main(String[] args) {
        Board house = new Board(10, 20);

        for (int x = 0; x < house.board.length; x++) {
            for (int y = 0; y < house.board[x].length; y++) {
                house.board[x][y] = new Room(x, y);
            }
        }

        System.out.println(house);
        int health = 10;
        int numOfCreatures = 0;
        Person player1 = new Person (0,0);
        house.board[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        System.out.println("You are currently in the house. Be on the lookout for some pocket creatures!");
        System.out.println("You can move using N for North, W for West, S for South, and E for East.");
        while (gameOn) {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if (validMove(move, player1, house.board)) {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                if (player1.getxLoc() == 0 && player1.getyLoc() == 3) {
                    int x = (int)(Math.random()*50);
                    Earth earth = new Earth(x);
                    System.out.println(earth + " (Level " + x + ")");
                    if (x <= 25) {
                        System.out.println("You have gained a new Earth creature.");
                        numOfCreatures++;
                    }
                    else {
                        int q = (int)(Math.random()*3 + 1);
                        health -= q;
                        System.out.println("The creature is too strong! Your health has fallen to " + health);
                    }
                }

            } else {
                System.out.println("Please choose a valid move.");
            }
        }
        in.close();
    }

    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }
}
