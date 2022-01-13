import java.util.HashMap;
import java.util.Map;

public class Score {
    private Map<Integer,String> scoreMap;

    public Score(){
        scoreMap = new HashMap<>();
        scoreMap.put(0,"Love");
        scoreMap.put(1,"Fifteen");
        scoreMap.put(2,"Thirty");
        scoreMap.put(3,"Forty");
    }

    public  String show(TennisGame game){
        int scorePlayer1 = game.getScorePlayer1();
        int scorePlayer2 = game.getScorePlayer2();
        if (scorePlayer1 == scorePlayer2) {
            return scorePlayer1 > 2 ? "Deuce" : scoreMap.get(scorePlayer1) + " all";
        } else {
            if (Math.max(scorePlayer1, scorePlayer2) > 3) {
                int pointDifference = Math.abs(scorePlayer1 - scorePlayer2);
                return (pointDifference == 1 ?  "Advantage " : "Game won by ") + game.getAdvantagePlayerName();
            } else {
                return scoreMap.get(scorePlayer1) + " - " + scoreMap.get(scorePlayer2);
            }
        }
    }
}
