package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void splitArray() {
        String actual = "1,2";
        String[] result = actual.split(",");
        assertThat(result).contains("1","2");
    }
    @Test
    void splitSingle() {
        String actual = "1";
        String[] result = actual.split(",");
        assertThat(result).containsExactly("1");
    }
    @Test
    void splitSingleWithParentheses() {
        String actual = "(1,2)";
        actual = actual.replace("(", "");
        actual = actual.replace(")", "");
        String[] result = actual.split(",");
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("charAt 작동 테스트")
    void charAt() {
        String actual = "1,2";

        char result = actual.charAt(0);
        assertThat(result).isEqualTo('1');
    }
    @Test
    @DisplayName("charAt Exception 핸들링하는것 확인하기")
    void charAtException() {

        // given some preconditions
        String actual = "1,2";

        // when
        Throwable thrown = catchThrowable(() -> { actual.charAt(5); });

        // then
        assertThat(thrown).isInstanceOf(Exception.class);
    }
}
