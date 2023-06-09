package baseball;

import lombok.Data;

@Data
public class Ball {
    public int index;
    public int ballNumber;
    public Ball(int index, int ballNumber) {
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
