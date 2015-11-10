package by.gsu.epamlab;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassMoney {

	private static final String PATTERN_MONEY="\\b((\\d{1,3}(\\s+\\d{3})*)(\\s*)(\\sbelarusian roubles|\\sblr))";
	private static final int NUM_GROUP_SUBSTRING=1;
	private static final String SPACE=" ";
	private static final String NULL = "";
	
	public static String replaceMoney(String line)
    {
		Pattern patternMoney=Pattern.compile(PATTERN_MONEY);
        Matcher matcher=patternMoney.matcher(line);
        while (matcher.find())
        {
        	String stringMoney = matcher.group(NUM_GROUP_SUBSTRING);
            line=line.replace(stringMoney,matcher.group(2).replaceAll(SPACE,NULL)+matcher.group(5));
        }
        return line;
    }

	
}
