package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        int result = 0;
        String inputString = inputString();

        // 문자열의 수 쪼개기
        NumberTokenizer numberTokenizer = new NumberTokenizer(inputString);
        List<Number> numbers = numberTokenizer.tokenize();

        // 쪼개진 수 계산
        Calculator calculator = new Calculator(numbers);
        result = calculator.sum();

        System.out.printf("결과 : %d\n", result);
        Console.close();
    }

    private static String inputString() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            // 빈 문자열 받는 테스트에 대한 처리
            return "";
        }
    }
}
