package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

}
