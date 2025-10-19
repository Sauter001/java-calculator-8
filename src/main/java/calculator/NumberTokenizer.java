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
    private String numberList;
    private String delimiters;

    public NumberTokenizer(String input) {
        this.numberList = input;
        this.delimiters = DEFAULT_DELIMITERS;
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


