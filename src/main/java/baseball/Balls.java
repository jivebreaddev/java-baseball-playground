package baseball;

import lombok.Getter;

import java.util.*;

@Getter
public class Balls {
    public List<Ball> balls;

    public Balls(List<Integer> balls) {
        this.balls = this.mapBall(balls);
    }

    public PlayResult play(Balls other) {
        int strCount = 0;
        int ballCount = 0;

        for (Ball ball : other.getBalls()) {
            BallStatus ballStatus = this.play(ball);
            if (ballStatus.isStrike()) {
                strCount++;
            }
            if (ballStatus.isBall()) {
                ballCount++;
            }
        }

        return new PlayResult(strCount, ballCount);

    }

    public BallStatus play(Ball other) {
        Set<BallStatus> result = new HashSet<>();

        for (Ball ball : this.getBalls()) {
            result.add(ball.play(other));
        }
        if (result.contains(BallStatus.STRIKE)) {
            return BallStatus.STRIKE;
        }
        if (result.contains(BallStatus.BALL)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public List<Ball> mapBall(List<Integer> numbers) {
        if(isOverlapped(numbers)){
            throw new IllegalArgumentException("중복된 값이 입력되었습니다.");
        }
        List<Ball> balls = new ArrayList<>();
        int index = 0;
        for (int number : numbers) {
            balls.add(new Ball(index++, number));
        }

        return balls;
    }

    public boolean isOverlapped(List<Integer> numbers) {

        return numbers.stream()
                .filter(number -> Collections.frequency(numbers, number)>1 )
                .count() > 1;
    }


}
