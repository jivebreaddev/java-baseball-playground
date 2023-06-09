package baseball;

import lombok.Data;

@Data
public class Ball {
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 9;
    public static final int POSITION_MIN = 0;
    public static final int POSITION_MAX = 2;
    public int index;
    public int ballNumber;
    public Ball(int index, int ballNumber) {

        if(ballNumber > NUMBER_MAX || ballNumber < NUMBER_MIN){
            throw new IllegalArgumentException(String.format("ballNumber should be between %d and %d", NUMBER_MIN, NUMBER_MAX));
        }
        if(index > POSITION_MAX || index < POSITION_MIN){
            throw new IllegalArgumentException(String.format("index should be between %d and %d", POSITION_MIN, POSITION_MAX));
        }
        this.index = index;
        this.ballNumber = ballNumber;
    }
    public BallStatus play(Ball ball){
        if (this.equals(ball)){
            return BallStatus.STRIKE;
        }
        if (this.matchBallNumbers(ball.getBallNumber())) {
               return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean matchBallNumbers(int ballNumber){
        return ballNumber == this.ballNumber;
    }

}
