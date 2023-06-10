package baseball;

import lombok.Getter;

@Getter
public class PlayResult {
    public int strikeCount;
    public int ballCount;
    public PlayResult(int strikeCount, int ballCount){
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;

    }

}
