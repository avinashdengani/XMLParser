import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.EventObject;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Validator {

	public boolean validate(String rule, String value) {
		Pattern pattern = Pattern.compile(rule);
		Matcher matcher = pattern.matcher(value);

		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	public boolean checkForValidations(EventObject e) {
		boolean validationStatus = false;
		if(e.getSource() == StudentDataForm.rollNoTextField || e.getSource() == StudentDataForm.submitBtn){
			validationStatus = textFieldValidations(StudentDataForm.rollNoTextField, RegexConstants.isDigitRegex, StudentDataForm.rollNoTextField.getText(), StudentDataForm.rollNoErrorLabel, StudentDataForm.rollNoLabel);
		}
		if(e.getSource() == StudentDataForm.nameTextField || e.getSource() == StudentDataForm.submitBtn) {
			validationStatus = textFieldValidations(StudentDataForm.nameTextField, RegexConstants.nameRegex, StudentDataForm.nameTextField.getText(), StudentDataForm.nameErrorLabel, StudentDataForm.nameLabel);
		} 
		if(e.getSource() == StudentDataForm.phoneNoTextField || e.getSource() == StudentDataForm.submitBtn) {
			validationStatus = textFieldValidations(StudentDataForm.phoneNoTextField, RegexConstants.phoneNumberRegex, StudentDataForm.phoneNoTextField.getText(), StudentDataForm.phoneNoErrorLabel, StudentDataForm.phoneNoLabel);
		} 
		if(e.getSource() == StudentDataForm.emailTextField || e.getSource() == StudentDataForm.submitBtn) {
			validationStatus = textFieldValidations(StudentDataForm.emailTextField, RegexConstants.emailRegex, StudentDataForm.emailTextField.getText(), StudentDataForm.emailErrorLabel, StudentDataForm.emailLabel);
		}
		return validationStatus;
	}
	public void isNumeric(KeyEvent ke) {
		char c = ke.getKeyChar();
      	if (!((c >= KeyEvent.VK_0) && (c <= KeyEvent.VK_9) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {
        	ke.consume();
      	}
	}

	public boolean textFieldValidations(JTextField textFieldName, String validationRule, String validationValue, JLabel errorLabel, JLabel labelName) {
		if(! validate(validationRule, validationValue)) {
			StudentDataForm.setErrorLabelTextStatus(errorLabel, labelName, false);
			return false;
		}
		StudentDataForm.setErrorLabelTextStatus(errorLabel, labelName, true);
		return true;
	}
}