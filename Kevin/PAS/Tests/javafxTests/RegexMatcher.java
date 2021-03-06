package javafxTests;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author chrismcclune
 * Custom Regex Matcher class to be used with JUNIT tests for RecpetionLayoutController
 */
public class RegexMatcher extends TypeSafeMatcher<String> {

	/**
	 *  variable to hold the regular expression
	 */
    private final String regex;
    
    /**
     * Constructor with args
     * 
     * @param regex
     */
    public RegexMatcher(final String regex) {
        this.regex = regex;
    }

    /**
     * Method to override the describeTo method in super class (TypeSafeMatcher)
     */
    @Override
    public void describeTo(final Description description) {
        description.appendText("matches regex=`" + regex + "`");
    }

    /**
     * Method to override the matchesSafely method in super class (TypeSafeMatcher)
     */
    @Override
    public boolean matchesSafely(final String string) {
        return string.matches(regex);
    }

    /**
     * RegexMatcher Method to be used to compare pattern with custom regular expression
     * 
     * @param regex
     * @return
     */
    public static RegexMatcher matchesRegex(final String regex) {
        return new RegexMatcher(regex);
    }
}