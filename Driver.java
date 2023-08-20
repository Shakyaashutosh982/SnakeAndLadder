import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver{


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of Players in Game : ");

        int noOfPlayers =scanner.nextInt();

        List<Player> players = new ArrayList<Player>();

        System.out.println("Enter Name of each player : ");

        for(int i=0; i<noOfPlayers; i++){

            players.add(new Player(scanner.next()));
        }



        System.out.println("Enter number of Snakes in Gameboard : ");

        int noOfSnakes = scanner.nextInt();

        List<Snake> snakes = new ArrayList<Snake>();

        System.out.println("Enter Head and Tail of each snake  : ");

        for(int i=0; i<noOfSnakes; i++){

            snakes.add(new Snake(scanner.nextInt(),scanner.nextInt()));

        }


        System.out.println("Enter number of Ladders in Gameboard : ");

        int noOfLadders = scanner.nextInt();

        List<Ladder> ladders = new ArrayList<Ladder>();

        System.out.println("Enter Start and End of each Ladder  : ");

        for(int i=0; i<noOfLadders; i++){

            ladders.add(new Ladder(scanner.nextInt(),scanner.nextInt()));

        }


        GameBoardConnect gameBoardConnect = new GameBoardConnect();

        gameBoardConnect.setPlayers(players);

        gameBoardConnect.setSnakes(snakes);

        gameBoardConnect.setLadders(ladders);

        gameBoardConnect.gameStart();


    }


}