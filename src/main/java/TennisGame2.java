
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    public String score = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        score = pointEqualsOrP1pointLessToFour(score);
        P1IsEqualsToP2AndP1IsGreaterWhatP2();

        P1IsGreaterWhatZeroAndP1EqualsZero();
        P2IsGreaterWhatZeroAndP1EqualsZero();

        P1IsGreaterP2AndP1IsLessWhatFour();
        P2IsGreaterP1AndP2IsLessWhatFour();

        P1IsGreaterWhatP2AndP2IsGreaterWhatTwo();

        P2IsGreaterWhatP1AndP1IsGreaterWhatTwo();

        if (compareThreeBoolean(P1pointIsGreaterWhat(3), P2pointIsGreaterWhat(-1), numberIsGreaterWhat(subtraction(P1point, P2point),1)))
        {
            score = "Win for player1";
        }
        if (compareThreeBoolean(P2pointIsGreaterWhat(3), P1pointIsGreaterWhat(-1), numberIsGreaterWhat(subtraction(P2point, P1point), 1)))
        {
            score = "Win for player2";
        }
        return score;
    }

    private void P2IsGreaterWhatP1AndP1IsGreaterWhatTwo() {
        if (compareTwoBoolean(P2pointIsGreaterWhat(P1point), P1pointIsGreaterWhat(2)))
        {
            score = "Advantage player2";
        }
    }

    private void P1IsGreaterWhatP2AndP2IsGreaterWhatTwo() {
        if (compareTwoBoolean(P1pointIsGreaterWhat(P2point), P2pointIsGreaterWhat(2)))
        {
            score = "Advantage player1";
        }
    }

    private void P1IsEqualsToP2AndP1IsGreaterWhatP2() {
        if (compareTwoBoolean(P1pointIsEquals(P2point), P1pointIsGreaterWhat(2)))
            score = "Deuce";
    }

    private void P2IsGreaterP1AndP2IsLessWhatFour() {
        if (compareTwoBoolean(P2pointIsGreaterWhat(P1point), P2pointIsLessWhat(4)))
        {
            compareP2WithEquals("Thirty",2);
            compareP2WithEquals("Forty", 3);
            compareP1WithEquals("Fifteen", 1);
            compareP1WithEquals("Thirty", 2);
            score = P1res + "-" + P2res;
        }
    }

    private void compareP2WithEquals(String dato, int i) {
        if (P2pointIsEquals(i))
            P2res=dato;
    }

    private void compareP1WithEquals(String dato, int i){
        if (P1pointIsEquals(i))
            P1res=dato;
    }

    private void P1IsGreaterP2AndP1IsLessWhatFour() {
        if (compareTwoBoolean(P1pointIsGreaterWhat(P2point), P1pointIsLessWhat(4)))
        {
            compareP1WithEquals("Thirty", 2);
            compareP1WithEquals("Forty", 3);
            compareP2WithEquals("Fifteen", 1);
            compareP2WithEquals("Thirty", 2);
            score = P1res + "-" + P2res;
        }
    }

    private void P2IsGreaterWhatZeroAndP1EqualsZero() {
        if (compareTwoBoolean(P2pointIsGreaterWhat(0), P1pointIsEquals(0)))
        {
            compareP2WithEquals("Fifteen", 1);
            compareP2WithEquals("Thirty", 2);
            compareP2WithEquals("Forty", 3);

            P1res = "Love";
            score = P1res + "-" + P2res;
        }
    }

    private void P1IsGreaterWhatZeroAndP1EqualsZero() {
        if (compareTwoBoolean(P1pointIsGreaterWhat(0), P2pointIsEquals(0)))
        {
            compareP1WithEquals("Fifteen", 1);
            compareP1WithEquals("Thirty", 2);
            compareP1WithEquals("Forty", 3);

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
    }

    private String pointEqualsOrP1pointLessToFour(String score) {
        if (compareTwoBoolean(P1pointIsEquals(P2point), P1pointIsLessWhat(4)))
        {
            if (P1pointIsEquals(0))
                score = "Love";
            if (P1pointIsEquals(1))
                score = "Fifteen";
            if (P1pointIsEquals(2))
                score = "Thirty";
            score += "-All";
        }
        return score;
    }

    private boolean compareTwoBoolean(boolean one, boolean two){
        return one && two;
    }

    private boolean compareThreeBoolean(boolean one, boolean two, boolean three){
        return one && two && three;
    }

    private boolean P1pointIsEquals(int i) {
        return P1point==i;
    }

    private boolean P2pointIsEquals(int i){
        return P2point==i;
    }

    private boolean P1pointIsGreaterWhat(int i){
        return P1point > i;
    }

    private boolean P2pointIsGreaterWhat(int i){
        return P2point > i;
    }

    private boolean P2pointIsLessWhat(int i){
        return P2point < i;
    }

    private boolean P1pointIsLessWhat(int i) {
        return P1point < i;
    }

    private boolean P1pointIsEqualsToP2point() {
        return P1point == P2point;
    }

    private int subtraction(int One, int Two){
        return One - Two;
    }

    private boolean numberIsGreaterWhat(int number, int i){
        return number > i;
    }

    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}