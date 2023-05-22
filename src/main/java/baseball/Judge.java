package baseball;

public class Judge {
    private int answer;
    public Judge(int ans){
        answer = ans;
    }
    public void call(String number){
        int strikeCnt = 0;
        int ballCnt = 0;
        int comparison;
        for (int i = 0; i< number.length();i++){
            int current = Character.getNumericValue(number.charAt(i));
            comparison = this.answer % 10;

        }
    }

    public int ballCount(int number) {

    }

    public int strikeCount(int number){

    }
}
