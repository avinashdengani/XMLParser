import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	String rule, value;
		
	public Validator(String rule, String value) {
		this.rule = rule;
		this.value = value;
	}

	public boolean validate() {
		Pattern pattern = Pattern.compile(this.rule);
		Matcher matcher = pattern.matcher(this.value);

		if(matcher.matches()) {
			return true;
		}
		return false;
	}
}