package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DELIMITER_REGEX = "^//(.)\\\\n"; // custom 구분자 추출을 위한 정규표현식
    private static final String DEFAULT_DELIMITERS = ",:";

    private final Matcher delimiterMatcher;
    private final String input;
    private final boolean isDelimiterFound;

    public DelimiterExtractor(String input) {
        Pattern pattern = Pattern.compile(DELIMITER_REGEX);
        this.delimiterMatcher = pattern.matcher(input);
        this.input = input;
        this.isDelimiterFound = this.delimiterMatcher.find();
    }

    public String initNumbersString() {
        // 커스텀 구분자 정의 안 된 경우 입력 문자열 그대로
        if (!this.isDelimiterFound) {
            return this.input;
        }

        return this.input.substring(this.delimiterMatcher.end());
    }

    public String initDelimiters() {
        if (!this.isDelimiterFound) {
            return DEFAULT_DELIMITERS;
        }

        String customDelimiter = this.delimiterMatcher.group(1);
        if (customDelimiter == null || customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("입력 받은 커스텀 구분자가 없습니다.");
        }

        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자 길이는 1이어야 합니다.");
        }

        return DEFAULT_DELIMITERS + customDelimiter;
    }
}
