package Main;

import Creatures.Earth;
import Creatures.Fire;
import Creatures.Water;
import Room.Room;
import Room.Person;
import Creatures.Air;
import Room.Forest;

import java.util.Scanner;
import java.lang.String;


public class Runner {

    private static boolean gameOn = true;
    String[] type = {"Air", "Earth", "Fire", "Water"};
    String[] type1 = {"air", "earth", "fire", "water"};

    /**This builds my rooms.
     *
     * @param args
     */
    public static void main(String[] args) {
        Board house = new Board(10, 10);

        for (int x = 0; x < house.board.length; x++) {
            for (int y = 0; y < house.board[x].length; y++) {
                house.board[x][y] = new Room(x, y);
            }
        }
        int a = (int)(Math.random()*house.board.length);
        int b = (int)(Math.random()*house.board.length);
        house.board[a][b] = new Forest(a, b);

        System.out.println(house);

        int health = 20;
        int numOfCreatures = 0;
        Person player1 = new Person(0,0);
        house.board[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        System.out.println("You are currently in the house. Your health is at 20. Be on the lookout for some pocket creatures!");
        System.out.println("You can move using N for North, W for West, S for South, and E for East.");
        while (gameOn) {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if (validMove(move, player1, house.board) && player1.getxLoc() < 10 && player1.getyLoc() < 10) {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                System.out.println(house);
                if (player1.getxLoc() == a && player1.getyLoc() == b) {
                    System.out.println("Congratulations! You have gained a legendary pocket creature." + " Level " + (int)(Math.random()*1000+100));
                    numOfCreatures++;
                    System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                }
                if (player1.getxLoc() == 0 && player1.getyLoc() == 1) {
                    int x = (int)(Math.random()*50);
                    Earth earth = new Earth(x);
                    System.out.println(earth + " (Level " + x + ")");
                    if (x <= 25) {
                        System.out.println("You have gained a new Earth creature.");
                        numOfCreatures++;
                        System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                    }
                    else {
                        int q = (int)(Math.random()*3 + 1);
                        health -= q;
                        System.out.println("The creature is too strong! Your health has fallen to " + health + ".");
                    }
                }
                if (player1.getxLoc() == 5 && player1.getyLoc() == 6) {
                    int x = (int)(Math.random()*50);
                    Water water = new Water(x);
                    System.out.println(water + " (Level " + x + ")");
                    if (x <= 25) {
                        System.out.println("You have gained a new Water creature.");
                        numOfCreatures++;
                        System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                    }
                    else {
                        int q = (int)(Math.random()*3 + 1);
                        health -= q;
                        System.out.println("The creature is too strong! Your health has fallen to " + health + ".");
                    }
                }
                if (player1.getxLoc() == 8 && player1.getyLoc() == 1) {
                    int x = (int)(Math.random()*50);
                    Air air = new Air(x);
                    System.out.println(air + " (Level " + x + ")");
                    if (x <= 25) {
                        System.out.println("You have gained a new Air creature.");
                        numOfCreatures++;
                        System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                    }
                    else {
                        int q = (int)(Math.random()*3 + 1);
                        health -= q;
                        System.out.println("The creature is too strong! Your health has fallen to " + health + ".");
                    }
                }
                if (player1.getxLoc() == 7 && player1.getyLoc() == 4) {
                    int x = (int)(Math.random()*50);
                    Fire fire = new Fire(x);
                    System.out.println(fire + " (Level " + x + ")");
                    if (x <= 25) {
                        System.out.println("You have gained a new Fire creature.");
                        numOfCreatures++;
                    }
                    else {
                        int q = (int)(Math.random()*3 + 1);
                        health -= q;
                        System.out.println("The creature is too strong! Your health has fallen to " + health + ".");
                    }
                }
                if (health == 0) {
                    gameOff();
                }

            }
            else {
                System.out.println("Please choose a valid move.");
            }
        }
        in.close();
    }

    /**
     * checks if the move is valid
     * @param move
     * @param p
     * @param map
     * @return
     */
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