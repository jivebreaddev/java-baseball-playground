package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class BallTest {


    @Test
    @DisplayName("1~9가 아닌 BallNumber 받았을 때 생성자 오류생성 IllegalArgumentException")
    void throwErrorWhenNot19(){
        //given

        //when
        Throwable thrown = catchThrowable(() -> new Ball(1,10));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("0~2가 아닌 인덱스를 받았을 때 생성자 오류생성 IllegalArgumentException")
    void throwErrorWhenIndex(){
        //given

        //when
        Throwable thrown = catchThrowable(() -> new Ball(3,0));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("볼을 받았을때")
    void playBall(){
        //given
        Ball ball = new Ball(0,1);
        Ball ball2 = new Ball(1,2);
        Ball ball3 = new Ball(1,3);
        //when
        BallStatus status = ball.play(ball2);
        BallStatus status2 = ball2.play(ball3);
        //then
        assertThat(status).isEqualTo(BallStatus.BALL);
        assertThat(status2).isEqualTo(BallStatus.BALL);
    }
    @Test
    @DisplayName("스트라이크를 받았을 때")
    void playStrike(){
        //given
        Ball ball = new Ball(0,1);
        Ball ball2 = new Ball(1,2);
        Ball ball3 = new Ball(1,3);
        //when
        BallStatus status = ball.play(ball2);
        BallStatus status2 = ball2.play(ball3);
        //then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
        assertThat(status2).isEqualTo(BallStatus.STRIKE);
    }
    @Test
    @DisplayName("아무것도 받지 않았을때")
    void playNothing(){
        //given
        Ball ball = new Ball(0,1);
        Ball ball2 = new Ball(1,2);
        Ball ball3 = new Ball(1,3);
        //when
        BallStatus status = ball.play(ball2);
        BallStatus status2 = ball2.play(ball3);
        //then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
        assertThat(status2).isEqualTo(BallStatus.NOTHING);
    }
}
