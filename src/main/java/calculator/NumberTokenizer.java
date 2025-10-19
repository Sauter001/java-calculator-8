package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberTokenizer {
    private static final String DEFAULT_DELIMITERS = ",:";
    private final String numberList;
    private final String delimiters;

    public NumberTokenizer(String input) {
        this.delimiters = initDelimiters(input);
        this.numberList = initNumberListString(input);
    }

    private String initNumberListString(String input) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n"); // custom 구분자 추출을 위한 정규표현식
        Matcher matcher = pattern.matcher(input);

        // 커스텀 구분자 정의 안 된 경우 입력 문자열 그대로
        if (!matcher.find()) {
            return input;
        }

        return input.substring(matcher.end());
    }

    private String initDelimiters(String input) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n"); // custom 구분자 추출을 위한 정규표현식
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            return DEFAULT_DELIMITERS;
        }

        String customDelimiter = matcher.group(1);
        if (customDelimiter == null || customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("입력 받은 커스텀 구분자가 없습니다.");
        }

        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자 길이는 1이어야 합니다.");
        }

        return DEFAULT_DELIMITERS + customDelimiter;
    }

    public List<Number> tokenize() {
        StringTokenizer tokenizer = new StringTokenizer(this.numberList, delimiters);
        List<Number> tokens = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            tokens.add(new Number(token));
        }
        return tokens;
    }
}


