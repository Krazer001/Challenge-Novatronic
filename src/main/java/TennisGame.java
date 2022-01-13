public class TennisGame {
    private Player player1;
    private Player player2;
    private int scorePlayer1;
    private int scorePlayer2;
    private boolean winner;

    public TennisGame(Player player1,Player player2){
        this.setPlayer1(player1);
        this.setPlayer2(player2);
        this.setScorePlayer1(0);
        this.setScorePlayer2(0);
        this.setWinner(false);
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public void setScorePlayer1(int scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public void setScorePlayer2(int scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    public boolean getWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void play(){
        do{
            Player player = getPlayerWonPoint();
            incrementScore(player);
            String score = getScore();
            if(finishGame(score)) winner = true;
            System.out.println("Score: " + score);
        }while(!winner);
    }

    private Player getPlayerWonPoint(){
        return (Math.random() < 0.5) ? this.getPlayer1() : this.getPlayer2();
    }

    private void incrementScore(Player player){

        if(getPlayer1().equals(player)){
            this.setScorePlayer1(this.getScorePlayer1() + 1);
        }else{
            this.setScorePlayer2(this.getScorePlayer2() + 1);
        }

        System.out.println(player.getName() + " has won 1 point!");
    }

    public String getScore(){
        Score scoreBoard = new Score();
        return  scoreBoard.show(this);
    }

    public String getHighScorerPlayerName() {
        return getScorePlayer1() > getScorePlayer2() ? getPlayer1().getName() : getPlayer2().getName();
    }

    private boolean finishGame(String score){
        return score.substring(0,4).equals("Game");
    }
}
