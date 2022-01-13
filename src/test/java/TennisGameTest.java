
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
    public void shoud_display_love_when_score_0(){
        TennisGame game = new TennisGame(player1,player2);
        assertThat(game,hasProperty("score",is("Love all")));
    }

    @Test
    public void shoud_display_fifteen_when_player1_score_1_point() {
        TennisGame game = new TennisGame(player1,player2);
        game.incrementScore(player1);
        assertThat(game, hasProperty("score", is("Fifteen - Love")));
    }

    @Test
    public void shoud_display_thirty_when_player2_score_2_consecutive_points() {
        TennisGame game = new TennisGame(player1,player2);
        game.incrementScore(player2);
        game.incrementScore(player2);
        assertThat(game, hasProperty("score", is("Love - Thirty")));
    }

    @Test
    public void shoud_display_forty_when_player1_score_3_consecutive_points() {
        TennisGame game = new TennisGame(player1,player2);
        game.incrementScore(player1);
        game.incrementScore(player1);
        game.incrementScore(player1);
        assertThat(game, hasProperty("score", is("Forty - Love")));
    }

    @Test
    public void shoud_display_Deuce_when_both_players_reach_forty() {
        TennisGame game = new TennisGame(player1, player2);
        for (int i = 0; i < 3; i++) {
            game.incrementScore(player1);
            game.incrementScore(player2);
        }

        assertThat(game, hasProperty("score", is("Deuce")));
    }

    @Test
    public void shoud_display_player2_has_advantage_when_score_is_Deuce_and_player2_win_point() {
        TennisGame game = new TennisGame(player1, player2);
        for (int i = 0; i < 3; i++) {
            game.incrementScore(player1);
            game.incrementScore(player2);
        }
        game.incrementScore(player2);
        assertThat(game, hasProperty("score", is("Advantage " + player2.getName())));
    }

    @Test
    public void should_display_game_when_player1_have_won_at_least_four_points_in_total_and_with_at_least_two_points_more_than_the_opponent() {
        TennisGame game = new TennisGame(player1, player2);
        for (int i = 0; i < 3; i++) {
            game.incrementScore(player1);
            game.incrementScore(player2);
        }
        game.incrementScore(player1);
        game.incrementScore(player1);
        assertThat(game, hasProperty("score", is("Game won by " + player1.getName())));
    }
}
