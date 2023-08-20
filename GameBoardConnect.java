import java.util.*;

public class GameBoardConnect{

    private GameBoard gameBoard;

    private int initialTotalPlayers;

    private Queue<Player> players;


    public GameBoardConnect(){

        this.gameBoard = new GameBoard();

        this.players = new LinkedList<Player>();

    }


    public void setPlayers( List<Player> players ){

        initialTotalPlayers = players.size();

        Map<String, Integer> playerPosition = new HashMap<String,Integer>();


        for(Player player : players){

            this.players.add(player);

            playerPosition.put(player.getName(),0);

        }

        gameBoard.setPositions(playerPosition);

    }


    public void setSnakes(List<Snake> snakes){

        gameBoard.setSnakes(snakes);

    }

    public void setLadders(List<Ladder> ladders){

        gameBoard.setLadders(ladders);

    }



    public void movePlayer(Player player, int step){

        int oldPosition = gameBoard.getPositions().get(player.getName());

        int newPosition = oldPosition+step;

        if(newPosition > 100){

            newPosition=oldPosition;

        }

        newPosition = newPositionViaSnakeAndLadder(newPosition);


        gameBoard.getPositions().put(player.getName(),newPosition);


        System.out.println(player.getName()+" rolled a dice and got - "+step+" And move from "+oldPosition+" to "+newPosition);

    }

    public int newPositionViaSnakeAndLadder(int newPosition){


        int oldPosition;

        do{

            oldPosition = newPosition;


            for(Snake snake : gameBoard.getSnakes()){

                if(snake.getHeadOfSnake() == newPosition){

                    newPosition=snake.getTailOfSnake();
                }
            }

            for(Ladder ladder : gameBoard.getLadders()){

                if(ladder.getStartOfLadder()==newPosition){

                    newPosition = ladder.getEndOfLadder();
                }
            }



        } while(oldPosition!=newPosition);


        return newPosition;


    }

    public boolean hasPlayerWon(Player player){

        int playerPosition = gameBoard.getPositions().get(player.getName());

        return playerPosition == 100;

    }

    public boolean isGameCompleted(){

        return players.size()==0;

    }

    public void gameStart(){

        while(!isGameCompleted()){

            Dice dice = new Dice();

            int numberOnFace = dice.numberOnDice();

            Player currentPlayer = players.poll();

            movePlayer(currentPlayer,numberOnFace);

            if(hasPlayerWon(currentPlayer)){

                System.out.println(currentPlayer.getName()+" won the Game !!!!!!!!");

                gameBoard.getPositions().remove(currentPlayer.getName());
            }

            else{

                players.add(currentPlayer);
            }

        }
    }

}