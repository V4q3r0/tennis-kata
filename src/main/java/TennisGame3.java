
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if(compareScore()) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[p1];
            return assignScore(s, p);
        }
        if (isEqualScore()) {
            return "Deuce";
        }
        s = whoWin();
        return setNameScore(s);
    }

    private String whoWin() {
        return p1 > p2 ? p1N : p2N;
    }

    private String assignScore(String s, String[] p) {
        return (isEqualScore()) ? s + "-All" : s + "-" + p[p2];
    }

    private boolean isEqualScore() {
        return p1 == p2;
    }

    private String setNameScore (String s){
        return (isEqualsToOne(multiplicationOfSubtraction())) ? "Advantage "+s : "Win for "+s;
    }

    private boolean isEqualsToOne (int number){
        return number == 1;
    }

    private int multiplicationOfSubtraction() {
        return subtractionOfScore() * subtractionOfScore();
    }

    private int subtractionOfScore() {
        return p1-p2;
    }

    private boolean compareScore() {
        return isaBoolean() && compareScoreEqualsSix();
    }

    private boolean isaBoolean() {
        return p1 < 4 && p2 < 4;
    }

    private boolean compareScoreEqualsSix() {
        return !(p1 + p2 == 6);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
    }

}
