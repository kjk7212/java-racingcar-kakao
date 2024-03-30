package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final int CUSTOM_DELIMITER_GROUP = 1;
	private static final int CUSTOM_DELIMITER_TEXT_GROUP = 2;

	public String[] parseInput(String input) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

		if (matcher.find()) {
			String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
			return matcher.group(CUSTOM_DELIMITER_TEXT_GROUP).split(customDelimiter);
		}

		return input.split("[,:;]");
	}

	public Integer strToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자가 아닌 값이 들어가있습니다.");
		}
	}
}
