package calculator;

import java.util.List;

public class Calculator {
    private List<Number> numbers;

    public Calculator(List<Number> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        // 리스트에 수가 없는 경우 0
        if (numbers.isEmpty()) {
            return 0;
        }

        Number sumResult = numbers.getFirst();
        for (int i = 1; i < numbers.size(); i++) {
            sumResult = sumResult.add(numbers.get(i));
        }

        return sumResult.getValue();
    }
}
