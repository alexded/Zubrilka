package zubrilka;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class Splitter_Test {
	
	private static final String SPACE = " ";
	private static final String ASTERIX = "*";
	private static final String DELIMITER = "=";
	private static final String END_OF_STRING = "\r\n";
	private static final String EMPTY = "";

	@Test public void empty() {
		String text = EMPTY;
		String splittedText = new Splitter().split( text );
		
		Assert.assertEquals( EMPTY, splittedText );
	}
	
	@Test public void oneWord() {
		String text = "ab";
		String splittedText = new Splitter().split( text );
		
		Assert.assertEquals( 
				StringUtils.join( new String[] { text, ASTERIX, EMPTY, "5", "5" }, DELIMITER ) + END_OF_STRING + 
				StringUtils.join( new String[] { "a" + ASTERIX, ASTERIX + "b", EMPTY, "5", "5" }, DELIMITER ) + END_OF_STRING + 
				StringUtils.join( new String[] { ASTERIX + "b", "a" + ASTERIX, EMPTY, "5", "5" }, DELIMITER ) + END_OF_STRING + 
				StringUtils.join( new String[] { ASTERIX, text, EMPTY, "5", "5" }, DELIMITER ) + END_OF_STRING, 
			splittedText );
	}

	@Test public void twoWords() {
		String firstWord = getRandomWord();
		String secondWord = getRandomWord();
		String text = firstWord + SPACE + secondWord;
		String splittedText = new Splitter().split( text );
		
		Assert.assertEquals( 
				StringUtils.join( new String[] { text, ASTERIX, EMPTY, "5", "5" }, DELIMITER ) + END_OF_STRING + 
				StringUtils.join( new String[] { firstWord + SPACE + ASTERIX, ASTERIX + SPACE + secondWord, EMPTY, "5", "5" }, DELIMITER ) + END_OF_STRING + 
				StringUtils.join( new String[] { ASTERIX + SPACE + secondWord, firstWord + SPACE + ASTERIX, EMPTY, "5", "5" }, DELIMITER ) + END_OF_STRING + 
				StringUtils.join( new String[] { ASTERIX, text, EMPTY, "5", "5" }, DELIMITER ) + END_OF_STRING, 
			splittedText );
	}
	
	@Test public void bigQuantity() {
		String text = "abc";
		int quantity = 1000;
		String splittedText = new Splitter().split( text, quantity );
		
		Assert.assertEquals( 8, StringUtils.split( splittedText, END_OF_STRING ).length );
	}
	
	@Test public void quantity() {
		String text = getRandomWord();
		int quantity = text.length();
		String splittedText = new Splitter().split( text, quantity );
		
		Assert.assertEquals( quantity, StringUtils.split( splittedText, END_OF_STRING ).length );
	}
	
	private String getRandomWord() {
		return String.valueOf( new Random().nextInt() );
	}
	
}
