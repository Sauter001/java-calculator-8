package calculator;

import java.util.List;

public class Calculator {
    private final List<Number> numbers;

    public Calculator(List<Number> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        int totalSum = 0;
        // 리스트에 수가 없는 경우 0
        if (numbers.isEmpty()) {
            return 0;
        }

        for (Number number : numbers) {
            totalSum += number.getValue();
        }

        return totalSum;
    }
}
