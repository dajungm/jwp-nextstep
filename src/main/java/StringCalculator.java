import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dajung.mun on 2017. 6. 27..
 */
public class StringCalculator {
    public int add(String line) {
        if (isBlank(line)) {
            return 0;
        }

        String[] data = split(line);
        return sum(data);
    }

    private boolean isBlank(String line) {
        return line == null || line.trim().isEmpty();
    }

    private String[] split(String line) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(line);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return line.split(",|:");
    }

    private int sum(String[] data) {
        int sum = 0;
        for (String datum : data) {
            sum = Calculator.add(sum, toPositive(datum));
        }
        return sum;
    }

    private int toPositive(String datum) {
        if (!datum.matches("[0-9]+")) {
            throw new RuntimeException();
        }

        return Integer.parseInt(datum);
    }
}
