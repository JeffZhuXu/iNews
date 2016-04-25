package catchnews.websites.sina;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CatchImageSina {

	public static List<String> getImageAsString(String body)
	throws PatternSyntaxException {
List<String> temp2 = new ArrayList<String>();

Pattern pattern = Pattern.compile(
		"(?<= src=')[\\s\\S]{0,80}(?=('\\s))", Pattern.DOTALL);
Matcher matcher = pattern.matcher(body);
while (matcher.find()) {
	temp2.add(matcher.group());
}
if (temp2.size() < 1)
	temp2.add("0");
return temp2;
}
	
}
