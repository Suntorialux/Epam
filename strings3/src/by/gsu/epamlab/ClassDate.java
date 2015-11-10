package by.gsu.epamlab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassDate  {

	private static final String PATTERN_DATE="(\\d{1,2}([/\\.-])\\d{1,2}\\2\\d{2,4})";
	private static final String DATE_FORMAT ="MMMM dd, yyyy" ;
	private static final int NUM_GROUP_SUBSTRING=1;
	private static final int NUM_GROUP_SEPARATOR=2;
	private static final String FORMAT_DAY="dd";
	private static final String FORMAT_MONTH="MM";
	private static final String FORMAT_YEAR="yy";
	
	public static String replaceDate(String line) {

		Date date=null;
		
		Pattern patternDate=Pattern.compile(PATTERN_DATE);
	    Matcher matcher = patternDate.matcher(line);
	    
	    while(matcher.find()) {
	    	String stringDate = matcher.group(NUM_GROUP_SUBSTRING);
	    	String separator = matcher.group(NUM_GROUP_SEPARATOR);
	    	String stringDateFormat = FORMAT_DAY+separator+FORMAT_MONTH+separator+FORMAT_YEAR;
	    	DateFormat format = new SimpleDateFormat(stringDateFormat, Locale.ENGLISH);
	    	SimpleDateFormat formatEnd = new SimpleDateFormat(DATE_FORMAT,Locale.ENGLISH);
	    	try {
				date=format.parse(stringDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	String formatDate = formatEnd.format(date);
	    	line=line.replace(stringDate, formatDate);			    	
	    }
		return line;
	}
}
