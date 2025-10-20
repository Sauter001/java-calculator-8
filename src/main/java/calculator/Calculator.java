package calculator;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    private final List<Number> numbers;

    public Calculator(List<Number> numbers) {
        this.numbers = numbers;
    }

    public BigDecimal sum() {
        BigDecimal totalSum = BigDecimal.ZERO;
        // 리스트에 수가 없는 경우 0
        if (numbers.isEmpty()) {
            return BigDecimal.ZERO;
        }

        for (Number number : numbers) {
            totalSum = number.addTo(totalSum);
        }

        return totalSum;
    }
}
