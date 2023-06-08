package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {
    @Test
    @DisplayName("")
    void playBall(int index, int number){
        //given
        Ball ball = new Ball(0,1);
        Ball ball2 = new Ball(1,2);
        //when
        BallStatus status = ball.play(0,2);
        BallStatus status2 = ball2.play(1,3);
        //then
        assertThat(status).isEqualTo(BallStatus.Ball);
        assertThat(status2).isEqualTo(BallStatus.Ball);
    }
    @Test
    @DisplayName("")
    void playStrike(int index, int number){
        //given
        Ball ball = new Ball(0,1);
        Ball ball2 = new Ball(1,2);
        //when
        BallStatus status = ball.play(0,2);
        BallStatus status2 = ball2.play(1,3);
        //then
        assertThat(status).isEqualTo(BallStatus.Strike);
        assertThat(status2).isEqualTo(BallStatus.Strike);
    }
    @Test
    @DisplayName("")
    void playNothing(int index, int number){
        //given
        Ball ball = new Ball(0,1);
        Ball ball2 = new Ball(1,2);
        //when
        BallStatus status = ball.play(0,2);
        BallStatus status2 = ball2.play(1,3);
        //then
        assertThat(status).isEqualTo(BallStatus.Ball);
        assertThat(status2).isEqualTo(BallStatus.Ball);
    }
}
