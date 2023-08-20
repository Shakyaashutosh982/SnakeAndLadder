import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard{
    public static int size=100;

    private List<Snake> snakes;

    private List<Ladder> ladders;

    public Map<String,Integer> playerPosition;


    GameBoard(){


        this.snakes = new ArrayList<Snake>();

        this.ladders = new ArrayList<Ladder>();

        this.playerPosition = new HashMap<String,Integer>();
    }



    public List<Snake> getSnakes(){

        return snakes;
    }


    public List<Ladder> getLadders(){

        return ladders;
    }


    public void setSnakes(List<Snake> snakes){

        this.snakes=snakes;
    }

    public void setLadders(List<Ladder> ladders){

        this.ladders=ladders;
    }


    public Map<String,Integer> getPositions(){

        return playerPosition;
    }


    public void setPositions(Map<String,Integer> playerPosition){
        
        this.playerPosition=playerPosition;
    }


}
