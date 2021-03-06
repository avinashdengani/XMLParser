<h1 align="center" class="text-white" style="color:blue;"> XML PARSER </h1>

<hr>


<p>The project provides a <b><i>validated</i></b> Student form which required name, roll no., email and phone no. as input.</p>
<p>On submitting the form the data given as input will get stored in <b><i>XML</i></b> format.</p>


<p>Example:-
    <img src="https://github.com/avinashdengani/XMLParser/blob/master/screenshots/XMLExample.jpg">
</p>

<hr>

<h3>Validations</h3>
<p>For validation I have used regex. I have created a interface which stores RegexConstants:


<code>
        
	
	public interface RegexConstants {

		static final String emailRegex =

			"^[A-Za-z_]([\\.A-Za-z0-9\\+-_]+)*@([A-Za-z_]([A-Za-z0-9-])*)(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z0-9]{2,})$";

		static final String phoneNumberRegex = "^\\+\\d{2}\\s[6-9]\\d{9}$";

		static final String isDigitRegex = "^[0-9]+$";

		static final String isAlphabetRegex = "^[A-Za-z]+$";

		static final String nameRegex = "^[A-Za-z_ ]+$";
	}
</code>
</p>


<p>To read extract data from XML I have used <i><b>Pattern and Matcher</b></i> of regex.</p>

<p>
    <img src="https://github.com/avinashdengani/XMLParser/blob/master/screenshots/PatternAndMatcher.jpg">
</p>

<hr>


<h3>Application Interface</h3>
<p>
    <img src="https://github.com/avinashdengani/XMLParser/blob/master/screenshots/StudentForm.jpg">
</p>

<hr>