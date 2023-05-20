package calculator;

import java.util.Scanner;

public class Calculator {
    private Scanner scanner;

    public void calculate(){
        scanner = new Scanner(System.in);
        String inputs = scanner.nextLine();
        String[] values = inputs.split(" ");
        // input processing 먼저 숫자랑 operators 이랑 나눠서 illegal 이면
        // exception 던지는게 맞음
        int acc = Integer.parseInt(values[0]);

        for(int i = 1; i<values.length; i+=2){
            if (values[i].equals("+")){
                acc += Integer.parseInt(values[i+1]);
            }else if (values[i].equals("-")){
                acc -= Integer.parseInt(values[i+1]);
            }else if (values[i].equals("*")){
                acc *= Integer.parseInt(values[i+1]);
            }else if (values[i].equals("/")){
                acc /= Integer.parseInt(values[i+1]);
            }else{
                throw new IllegalArgumentException("Please check arguments");
            }

        }
        System.out.print(acc);
    }
}
