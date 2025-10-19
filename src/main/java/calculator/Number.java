package calculator;

public class Number {
    private int value;

    public Number(String value) {
        initValue(value);
    }

    private void initValue(String value) {
        try {
            int numberValue = Integer.parseInt(value);
            if (numberValue <= 0) {
                throw new IllegalArgumentException("입력된 숫자는 양수여야 합니다.");
            }

            this.value = numberValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수가 아닌 값을 입력 받았습니다.");
        }
    }

    public Number add(Number number) {
        this.value += number.value;
        return this;
    }

    public int getValue() {
        return this.value;
    }
}
