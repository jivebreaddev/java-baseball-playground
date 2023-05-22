package study;

import baseball.InputView;
import baseball.Judge;
import baseball.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

//import assertThat
//import catchThrowable
//given
//when
//then
public class BaseBallTest {
    // 여기 parameterized test 이용해보는게 좋겠다.
// application takes three parts
// 1. strike, ball call
// 3. print call output (UI LOGIC)
// 2. finish, restart game
////given
//    String input = "1 + 2 + 3";
//    InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//    out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//    assertThat("6").isEqualTo(out.toString());
// 두개의 방법이 있어보인다.
    // 1. 객체 3개(judge, input, output) 를 여기서 직접 사용해서 test 하는 방법
    // 2. baseball 이라는 객체 하나만 test 하는 방법
        // 3. 객체가 서로 의존관계를 가지면 객체만 call 해도 UI가 뜨긴 해야되 보인다.

    // 1 로 진행하자.
    private static Judge judge;
    private static ResultView outputView;
    private static InputView inputView;
    @BeforeEach
    public void before(){
        judge = new Judge("123");
        inputView = new InputView();
        outputView = new ResultView();
    }

    @Test
    @DisplayName("인풋이 strikes의 경우를 포함 할때")
    public void strikeTest() {
        //given
        String input = "123";
        inputView.printPrompt();
        // System.in setup
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String number = inputView.get();
        //when

        String call = judge.call(input);
        outputView.printPrompt(call);

        //then
        // ui 에 표기
        assertThat(out.toString()).isEqualTo("1스트라이크");
        return;
    }

    @Test
    @DisplayName("인풋이 ball의 경우를 포함할 때")
    public void ballTest() {
        //given
        inputStream input = ~~;
        //when
        judge.call(inputStream());
        //then
        assertsThat(ui.output().toString()).isEquals();

        return;
    }

    @Test
    @DisplayName("인풋이 strikes의 경우와 ball의 경우를 받았을 때")
    public void strikeBallTest() {
        //given

        //when

        //then
        return;
    }
    @Test
    @DisplayName("인풋이 정답을 받았을 때")
    public void correctAnswer() {
        //given

        //when

        //then
        return;
    }

    @Test
    @DisplayName("게임이 끝나고 게임이 다시 시작될때")
    public void rematchGame() {
        //given

        //when

        //then

        // return;
    }

    @Test
    @DisplayName("게임이 끝나고 게임을 끝냈을 때")
    public void endGame() {
        //given
        //when
        //then
        return;
    }

    @Test
    @DisplayName("게임이 끝나고 게임을 끝냈을 때 인풋이 틀렸을 때")
    public void wrongEndGame() {
        //given
        //when
        //then
        return;
    }
}
