package calculator;

import java.math.BigDecimal;

public class Number {
    private BigDecimal value;

    public Number(String value) {
        initValue(value);
    }

    private void initValue(String value) {
        try {
            BigDecimal numberValue = new BigDecimal(value);
            if (numberValue.signum() <= 0) {
                throw new IllegalArgumentException("입력된 숫자는 양수여야 합니다.");
            }

            this.value = numberValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수가 아닌 값을 입력 받았습니다.");
        }
    }

    public BigDecimal addTo(BigDecimal currentValue) {
        return this.value.add(currentValue);
    }
}
