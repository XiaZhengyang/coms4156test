package coms4156.spring2017;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFormatter {
	
	//Ref: https://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	
	private Matcher matcher;
	
	public EmailSender es = new EmailSender();
	
	public EmailFormatter() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	/**
	 * Checkk email address, create email object and send.
	 * @param address
	 * @return
	 */
	public boolean formatAndSend(String address) {
		matcher = pattern.matcher(address);
		if (!matcher.matches()) {
			return false;
		}
		
		Email e = new Email();
		e.address = address;
		String name = address.split("@")[0];
		e.title = "Welcome " + name;
		e.contents = "Hello " + name + "!/n";
		return this.es.sendMail(e);
	}

}
