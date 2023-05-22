package baseball;

import java.util.Scanner;
public class InputView {
    private static Scanner scanner;

    public InputView(){
        scanner = new Scanner(System.in);
    }
    public void printPrompt(){
        System.out.print("숫자를 입력해 주세요");
    }
    public String get(){

        String number = scanner.next();
        return number;
    }
}
