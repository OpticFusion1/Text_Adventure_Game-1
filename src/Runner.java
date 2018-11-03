import java.util.Scanner;
import java.lang.String;

public class Runner {

    private static boolean gameOn = true;

    public static void main(String[] args) {
        //Room[][] building = new Room[10][10];
        //String[][] area = new String[10][20];
        //Room[][] house = new Room[10][10];

        Board house = new Board(10,20);

        for (int x = 0; x < house.board.length; x++)
        {
            for (int y = 0; y < house.board[x].length; y++)
            {
                house.board[x][y] = new Room(x,y);
            }
        }

        System.out.println(house);

        //int x = (int)(Math.random()*building.length);

        //Setup player 1 and the input scanner
        //Person player1 = new Person("FirstName", "FamilyName", 0, 0);
        //area[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        System.out.println("You are currently in the house. Be on the lookout for some pocket creatures!");
        System.out.println("You can move using W for North, A for West, S for South, and D for East.");
        while (gameOn) {
            String move = in.nextLine();
            if (move.equals("W")) {

            }
           /*if(validMove(move, player1, area))
           {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
           }
           else {
                System.out.println("Please choose a valid move.");*/
        }


    }
    //in.close();
}