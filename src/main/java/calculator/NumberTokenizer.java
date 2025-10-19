package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberTokenizer {
    private final String numberList;
    private final String delimiters;

    public NumberTokenizer(String input) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);
        this.delimiters = delimiterExtractor.initDelimiters();
        this.numberList = delimiterExtractor.initNumbersString();
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


