
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String FILE_NAME="in";
		final String VALUE="value";
		final String ERROR_LINE="Error-line = ";
		final String FILE_NOT_FOUND="File not found";
		final String FORMAT_STRING_FOR_RESULT="Sum = %1.3f\n";
		final String PATTERN_FOR_INDEX="index(.*)";
		final String PATTERN_FOR_INDEX_VALUE="([1-9]\\d*)";
		final int NUM_GROUP = 1;
		int badRow=0;
		double result=0;




		Pattern patternIndex=Pattern.compile(PATTERN_FOR_INDEX);
		Pattern patternValue=Pattern.compile(PATTERN_FOR_INDEX_VALUE);

		try {
			ResourceBundle rb=ResourceBundle.getBundle(FILE_NAME);
			Enumeration<String> keys = rb.getKeys();
			String key;
			while(keys.hasMoreElements()) {
				key=keys.nextElement();
				Matcher matcherIndex=patternIndex.matcher(key);
				if(matcherIndex.matches()) {
					String stringValue = rb.getString(key).trim();
					Matcher matcherValue = patternValue.matcher(stringValue);
					String stringIndexNumber = matcherIndex.group(NUM_GROUP);
					Matcher matcherIndexNumber = patternValue.matcher(stringIndexNumber);
					if ((matcherValue.matches())&&(matcherIndexNumber.matches())) {
						try {
							String valueAll=VALUE+stringIndexNumber+stringValue;
							String value = rb.getString(valueAll).trim();
							result += Double.parseDouble(value);
						} catch (NumberFormatException | MissingResourceException e) {
							badRow++;
						}
					}
					else {
						badRow++;
					}
				}
			}
			System.out.format(Locale.ENGLISH, FORMAT_STRING_FOR_RESULT,result);
			System.out.println(ERROR_LINE+badRow);
		} catch (MissingResourceException e){
			System.out.println(FILE_NOT_FOUND);
		}
	}
}
