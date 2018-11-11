package Main;

import Creatures.Earth;
import Creatures.Fire;
import Creatures.Water;
import Room.Room;
import Room.Person;
import Creatures.Air;
import Room.Forest;
import Weapons.Negotiation;
import Weapons.Potion;
import Weapons.Sword;
import Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;


public class Runner {

    private static boolean gameOn = true;

    /**This builds my rooms.
     *
     * @param args
     */
    public static void main(String[] args) {
        Board house = new Board(8, 7);

        for (int x = 0; x < house.board.length; x++) {
            for (int y = 0; y < house.board[x].length; y++) {
                house.board[x][y] = new Room(x, y);
            }
        }
        int a = (int)(Math.random()*house.board.length-1);
        int b = (int)(Math.random()*house.board.length-1);
        house.board[a][b] = new Forest(a, b);

        System.out.println(house);

        List<String> weaponList = new ArrayList<String>();
        int health = 10;
        int numOfCreatures = 0;
        Person player1 = new Person(0,0);
        house.board[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        System.out.println("You are currently in the house. Your health is at 10. Be on the lookout for some pocket creatures!");
        System.out.println("You can move using N for North, W for West, S for South, and E for East.");
        String[] type = {"Air", "Earth", "Fire", "Water"};
        String[] weap = {"Potion", "Sword", "Negotiation"};

        while (gameOn) {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if (validMove(move, player1, house.board) && player1.getxLoc() < 10 && player1.getyLoc() < 10) {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                System.out.println(house);
                int statement = (int)(Math.random()*4+1);
                if (statement == 1) {
                    if (player1.getxLoc() <= house.board.length && player1.getyLoc() <= house.board.length) {
                        int x = (int) (Math.random() * 50);
                        int y = (int) (Math.random() * type.length);
                        if (player1.getxLoc() == a && player1.getyLoc() == b) {
                            System.out.println("Congratulations! You have gained a legendary pocket creature." + " (Level " + (int) (Math.random() * 1000 + 100) + ")");
                            numOfCreatures++;
                            if (numOfCreatures == 1)
                                System.out.println("You now have " + numOfCreatures + " pocket creature.");
                            else
                                System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                            System.out.println("Health: " + health);
                        }
                        switch (type[y]) {
                            case "Air":
                                Air air = new Air(x);
                                System.out.println(air + " (Level " + x + ")");
                                if (x <= 25) {
                                    System.out.println("You have gained a new " + type[y] + " creature.");
                                    numOfCreatures++;
                                    if (numOfCreatures == 1)
                                        System.out.println("You now have " + numOfCreatures + " pocket creature.");
                                    else
                                        System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                                }
                                else {
                                    System.out.println("The creature is too strong!");
                                    if (weaponList.size() > 0) {
                                        System.out.println("Would you like to use one of your weapons? (yes/no)");
                                        Scanner useWeapon = new Scanner(System.in);
                                        String use = useWeapon.nextLine();
                                        if (use.equals("yes")) {
                                            System.out.println(weaponList);
                                            System.out.println("Which weapon would you like to use?");
                                            Scanner weaponChoice = new Scanner(System.in);
                                            String weaponC = weaponChoice.nextLine();
                                            if (weaponList.contains(weaponC)) {
                                                weaponList.remove(weaponC);
                                                System.out.println("You were able to get away.");
                                            }
                                            else {
                                                System.out.println("You do not have this weapon.");
                                                int q = (int) (Math.random() * 3 + 1);
                                                health -= q;
                                                System.out.println("Your health has fallen to " + health + ".");
                                            }
                                        }
                                    }
                                    else {
                                        int q = (int) (Math.random() * 3 + 1);
                                        health -= q;
                                        System.out.println("Your health has fallen to " + health + ".");
                                    }
                                }
                                System.out.println("Health: " + health);
                                break;
                            case "Earth":
                                Earth earth = new Earth(x);
                                System.out.println(earth + " (Level " + x + ")");
                                if (x <= 25) {
                                    System.out.println("You have gained a new " + type[y] + " creature.");
                                    numOfCreatures++;
                                    if (numOfCreatures == 1)
                                        System.out.println("You now have " + numOfCreatures + " pocket creature.");
                                    else
                                        System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                                }
                                else {
                                    System.out.println("The creature is too strong!");
                                    if (weaponList.size() > 0) {
                                        System.out.println("Would you like to use one of your weapons? (yes/no)");
                                        Scanner useWeapon = new Scanner(System.in);
                                        String use = useWeapon.nextLine();
                                        if (use.equals("yes")) {
                                            System.out.println(weaponList);
                                            System.out.println("Which weapon would you like to use?");
                                            Scanner weaponChoice = new Scanner(System.in);
                                            String weaponC = weaponChoice.nextLine();
                                            if (weaponList.contains(weaponC)) {
                                                weaponList.remove(weaponC);
                                                System.out.println("You were able to get away.");
                                            } else {
                                                System.out.println("You do not have this weapon.");
                                                int q = (int) (Math.random() * 3 + 1);
                                                health -= q;
                                                System.out.println("Your health has fallen to " + health + ".");
                                            }
                                        }
                                    } else {
                                        int q = (int) (Math.random() * 3 + 1);
                                        health -= q;
                                        System.out.println("Your health has fallen to " + health + ".");
                                    }
                                }
                                System.out.println("Health: " + health);
                                break;
                            case "Fire":
                                Fire fire = new Fire(x);
                                System.out.println(fire + " (Level " + x + ")");
                                if (x <= 25) {
                                    System.out.println("You have gained a new " + type[y] + " creature.");
                                    numOfCreatures++;
                                    if (numOfCreatures == 1)
                                        System.out.println("You now have " + numOfCreatures + " pocket creature.");
                                    else
                                        System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                                }else {
                                    System.out.println("The creature is too strong!");
                                    if (weaponList.size() > 0) {
                                        System.out.println("Would you like to use one of your weapons? (yes/no)");
                                        Scanner useWeapon = new Scanner(System.in);
                                        String use = useWeapon.nextLine();
                                        if (use.equals("yes")) {
                                            System.out.println(weaponList);
                                            System.out.println("Which weapon would you like to use?");
                                            Scanner weaponChoice = new Scanner(System.in);
                                            String weaponC = weaponChoice.nextLine();
                                            if (weaponList.contains(weaponC)) {
                                                weaponList.remove(weaponC);
                                                System.out.println("You were able to get away.");
                                            } else {
                                                System.out.println("You do not have this weapon.");
                                                int q = (int) (Math.random() * 3 + 1);
                                                health -= q;
                                                System.out.println("Your health has fallen to " + health + ".");
                                            }
                                        }
                                    } else {
                                        int q = (int) (Math.random() * 3 + 1);
                                        health -= q;
                                        System.out.println("Your health has fallen to " + health + ".");
                                    }
                                }
                                System.out.println("Health: " + health);
                                break;
                            case "Water":
                                Water water = new Water(x);
                                System.out.println(water + " (Level " + x + ")");
                                if (x <= 25) {
                                    System.out.println("You have gained a new " + type[y] + " creature.");
                                    numOfCreatures++;
                                    if (numOfCreatures == 1)
                                        System.out.println("You now have " + numOfCreatures + " pocket creature.");
                                    else
                                        System.out.println("You now have " + numOfCreatures + " pocket creatures.");
                                } else {
                                    System.out.println("The creature is too strong!");
                                    if (weaponList.size() > 0) {
                                        System.out.println("Would you like to use one of your weapons? (yes/no)");
                                        Scanner useWeapon = new Scanner(System.in);
                                        String use = useWeapon.nextLine();
                                        if (use.equals("yes")) {
                                            System.out.println(weaponList);
                                            System.out.println("Which weapon would you like to use?");
                                            Scanner weaponChoice = new Scanner(System.in);
                                            String weaponC = weaponChoice.nextLine();
                                            if (weaponList.contains(weaponC)) {
                                                weaponList.remove(weaponC);
                                                System.out.println("You were able to get away.");
                                            } else {
                                                System.out.println("You do not have this weapon.");
                                                int q = (int) (Math.random() * 3 + 1);
                                                health -= q;
                                                System.out.println("Your health has fallen to " + health + ".");
                                            }
                                        }
                                    } else {
                                        int q = (int) (Math.random() * 3 + 1);
                                        health -= q;
                                        System.out.println("Your health has fallen to " + health + ".");
                                    }
                                }
                                System.out.println("Health: " + health);
                                break;
                        }
                        if (health <= 0) {
                            gameOff();
                        }
                    }
                }
                else if (statement == 2) {
                    if (player1.getxLoc() <= house.board.length && player1.getyLoc() <= house.board.length) {
                        int q = (int) (Math.random() * weap.length);
                        switch (weap[q]) {
                            case "Potion":
                                Potion potion = new Potion("Potion");
                                System.out.println("You have found a potion! Would you like to add it to your weapons collection? (yes/no)");
                                Scanner news = new Scanner(System.in);
                                String weaponAgree = news.nextLine();
                                weaponAgree = weaponAgree.toLowerCase().trim();
                                if (weaponAgree.equals("yes")) {
                                    weaponList.add("Potion");
                                    System.out.println(weaponList);
                                }
                                break;
                            case "Negotiation":
                                Negotiation negotiation = new Negotiation("Negotiation");
                                System.out.println("You have found Negotiation! Would you like to add it to your weapons collection? (yes/no)");
                                Scanner news1 = new Scanner(System.in);
                                String weaponAgree1 = news1.nextLine();
                                weaponAgree1 = weaponAgree1.toLowerCase().trim();
                                if (weaponAgree1.equals("yes")) {
                                    weaponList.add("Negotiation");
                                    System.out.println(weaponList);
                                }
                                break;
                            case "Sword":
                                Sword sword = new Sword("Sword");
                                System.out.println("You have found a sword! Would you like to add it to your weapons collection? (yes/no)");
                                Scanner news2 = new Scanner(System.in);
                                String weaponAgree2 = news2.nextLine();
                                weaponAgree2 = weaponAgree2.toLowerCase().trim();
                                if (weaponAgree2.equals("yes")) {
                                    weaponList.add("Sword");
                                    System.out.println(weaponList);
                                }
                                break;
                        }
                    }
                }
                else {
                    String[] comments = {"There's nothing in this room, but don't be discouraged.", "Don't worry!", "You'll find them eventually.", "They're just hiding."};
                    int randomComment = (int)(Math.random()*comments.length);
                    System.out.println(comments[randomComment]);
                }
            }
            else
                System.out.println("Please choose a valid move.");
        }
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
        System.out.println("Sorry, you lose all of your health and creatures. Game over. :(");
    }
}