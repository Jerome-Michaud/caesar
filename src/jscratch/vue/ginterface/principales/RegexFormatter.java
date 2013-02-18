package jscratch.vue.ginterface.principales;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.text.DefaultFormatter;

/**
 * A regular expression based implementation of AbstractFormatter.
 */
public class RegexFormatter extends DefaultFormatter {

	private Pattern pattern;
	private Matcher matcher;

	/**
	 * Creates a regular expression based AbstractFormatter.
	 * pattern specifies the regular expression that will be used
	 * to determine if a value is legal.
	 */
	public RegexFormatter(String pattern) throws PatternSyntaxException {
		super();
		this.pattern = Pattern.compile(pattern);
	}

	@Override
	public Object stringToValue(String text) throws ParseException {
		matcher = pattern.matcher(text);

		if (matcher.matches()) {
			return super.stringToValue(text);
		}
		throw new ParseException("Pattern did not match", 0);
	}
}