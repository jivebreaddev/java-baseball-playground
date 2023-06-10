package baseball;

public enum BallStatus {
    STRIKE,
    BALL,
    NOTHING;


    public boolean isStrike(){
        return this.equals(BallStatus.STRIKE);
    }
    public boolean isBall(){
        return this.equals(BallStatus.BALL);
    }
}
