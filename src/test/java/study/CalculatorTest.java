package study;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

// calculator는 Scanner 로 인풋을 받는데
// test를 할때는 input 값이 정해져 있지 않다.
// 해당을 input stream 종류를 바꿔서 만들 수 있다.

public class CalculatorTest {
    private Calculator calculator;
    private OutputStream out;


    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("정상적인 input일 때, calculate 하기")
    void calculateTest(){
        //given
        String input = "1 + 2 + 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        calculator.calculate();

        //then
        assertThat("6").isEqualTo(out.toString());
    }

    @Test
    @DisplayName("systemin Exception 포맷에 맞지 않는 string 주어 졌을때")
    void wrongArgumentsTest(){
        // given
        String input = "1 + 2k + 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        // when
        Throwable thrown = catchThrowable(() -> {
            calculator.calculate();
            out = new ByteArrayOutputStream();
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

}
