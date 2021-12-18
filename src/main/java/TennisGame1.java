
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String score = "";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {

        int tempScore=0;

        if (isScoreGreaterThanOrEqual())
        {
            int minusResult = less(m_score1,m_score2);
            compareMinusResult(minusResult);
        }
        else
        {
            setScore(getString(score));
        }
        if (compareScore())
        {
            setScore();
        }
        return score;
    }

    private void compareMinusResult(int minusResult) {
        if (isEqualsOne(minusResult)) setScore("Advantage player1");
        else if (minusResultLessOne(minusResult)) setScore("Advantage player2");
        else if (minusResultGreaterOrEquals(minusResult)) setScore("Win for player1");
        else setScore("Win for player2");
    }

    public void setScore(String dato){
        score = dato;
    }

    public int less (int numberOne, int numberTwo){
        return numberOne - numberTwo;
    }

    private String getString(String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (isEqualsOne(i)) tempScore = m_score1;
            else { score +="-"; tempScore = m_score2;}
            score = compareTemScore(score, tempScore);
        }
        return score;
    }

    private String compareTemScore(String score, int tempScore) {
        if(isEqualsOne(tempScore)) score += "Fifteen";
        if(isEqualsTwo(tempScore)) score += "Thirty";
        if(isEqualsCero(tempScore)) score +="Love";
        if(isEqualsThree(tempScore)) score +="Forty";

        return score;
    }

    private boolean isEqualsCero(int i ){
        return i==0;
    }

    private boolean isEqualsOne(int i) {
        return i==1;
    }

    private boolean isEqualsTwo(int i){
        return i==2;
    }

    private boolean isEqualsThree(int i){
        return i == 3;
    }

    private boolean isGreaterOfTwo(int i){
        return i > 2;
    }

    private boolean minusResultGreaterOrEquals (int minusResult) {
        return minusResult>=2;
    }

    private boolean minusResultLessOne (int minusResult) {
        return minusResult ==-1;
    }

    private void setScore() {
        if(isEqualsOne(m_score1)) setScore("Fifteen-All");
        if(isEqualsTwo(m_score1)) setScore("Thirty-All");
        if(isEqualsCero(m_score1)) setScore("Love-All");
        if(isGreaterOfTwo(m_score1)) setScore("Deuce");
    }

    private boolean isScoreGreaterThanOrEqual() {
        return m_score1>=4 || m_score2>=4;
    }

    private boolean compareScore() {
        return m_score1==m_score2;
    }
}
