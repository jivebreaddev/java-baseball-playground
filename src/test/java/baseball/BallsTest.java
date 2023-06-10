package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class BallsTest {

    @Test
    @DisplayName("숫자들을 받아서 Balls 생성중 중복 값이 있을 때")
    void BallsInput(){
//        List<Integer> ballNumbers = new ArrayList<>();
        //given
        Balls newBalls = new Balls(Arrays.asList(1,2,3));
        Balls input = new Balls(Arrays.asList(1,2,3));
        //when
        Throwable thrown = catchThrowable(() -> new Balls(Arrays.asList(1,2,1)));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("숫자들을 받아서 Balls 생성")
    void Play_1strike_2ball(){
        Balls newBalls = new Balls(Arrays.asList(1,2,3));
        Balls input = new Balls(Arrays.asList(3,1,2));
        //when
        PlayResult playResult = newBalls.play(input);
        //then
        assertThat(playResult.getStrikeCount()).isEqualTo(0);
        assertThat(playResult.getBallCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자들을 받아서 Strike 확인")
    void play_strike(){
        Balls newBalls = new Balls(Arrays.asList(1,2,3));
        Balls input = new Balls(Arrays.asList(5,2,6));
        //when
        PlayResult playResult =  newBalls.play(input);
        //then
        assertThat(playResult.getStrikeCount()).isEqualTo(1);
        assertThat(playResult.getBallCount()).isEqualTo(0);
    }
    @Test
    @DisplayName("오답들만 받아서 NOTHING 확인")
    void play_nothing(){

        Balls newBalls = new Balls(Arrays.asList(1,2,3));
        Balls input = new Balls(Arrays.asList(5,6,7));
        //when
        PlayResult playResult = newBalls.play(input);
        //then
        assertThat(playResult.getStrikeCount()).isEqualTo(0);
        assertThat(playResult.getBallCount()).isEqualTo(0);
    }
}
