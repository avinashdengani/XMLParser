public interface RegexConstants {
	static final String emailRegex = "^[A-Za-z_]([\\.A-Za-z0-9\\+-_]+)*@([A-Za-z_]([A-Za-z0-9-])*)(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z0-9]{2,})$";
	static final String phoneNumberRegex = "^\\+\\d{2}\\s[6-9]\\d{9}$";
	static final String isDigitRegex = "^[0-9]+$";
	static final String isAlphabetRegex = "^[A-Za-z]+$";
	static final String nameRegex = "^[A-Za-z_ ]+$";
}