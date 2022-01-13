
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class TennisGameTest {

    Player player1;
    Player player2;

    TennisGameTest(){
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    }

    @Test
    public void loveShouldBeDescriptionForScore0(){
        TennisGame game = new TennisGame(player1,player2);
        assertThat(game,hasProperty("score",is("Love all")));
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        TennisGame game = new TennisGame(player1,player2);
        game.incrementScore(player1);
        assertThat(game, hasProperty("score", is("Fifteen - Love")));
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        TennisGame game = new TennisGame(player1,player2);
        game.incrementScore(player2);
        game.incrementScore(player2);
        assertThat(game, hasProperty("score", is("Love - Thirty")));
    }

    @Test
    public void FortyShouldBeDescriptionForScore3() {
        TennisGame game = new TennisGame(player1,player2);
        game.incrementScore(player1);
        game.incrementScore(player1);
        game.incrementScore(player1);
        assertThat(game, hasProperty("score", is("Forty - Love")));
    }

}
