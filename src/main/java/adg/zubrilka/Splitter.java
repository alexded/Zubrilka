package adg.zubrilka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class Splitter {

	public String split( String text ) {
		if( StringUtils.isEmpty( text )) { return text; }
		String delimiter = " ";
		String[] textArray = StringUtils.split( text, delimiter );
		if( textArray.length == 1 ) {
			delimiter = "";
			textArray = text.split( "" );
		}
		int length = textArray.length;
		char[] c = new char[ length ];
		Arrays.fill( c, '1' );
		String matrix = new String( c );
		Integer iterations = Integer.valueOf( matrix, 2 );
		final Collection<String[]> matrixCollection = new ArrayList<String[]>();
		while ( iterations > -1 ) {
			matrixCollection.add( new String[] { StringUtils.leftPad( Integer.toBinaryString( iterations ), length, '0' )});
			iterations--;
		}
		String result = "";
		for( String[] matrix1 : matrixCollection ) {
			String[] resultArray = new String[ length ];
			String[] answersArray = new String[ length ];
			for( int index = 0; index < length; index++ ) {
				if ( matrix1[0].charAt( index ) == '1' ) {
					resultArray[ index ] = textArray[ index ];
					answersArray[ index ] = "*";
				} else {
					resultArray[ index ] = "*";
					answersArray[ index ] = textArray[ index ];
				}
			}
			result = result + StringUtils.join( resultArray, delimiter ) + "=" + StringUtils.join( answersArray, delimiter ) + "==5=5" + "\r\n";
		}
		while( StringUtils.contains( result, "*" + delimiter + "*" )) {
			result = StringUtils.replacePattern( result, "\\*" + delimiter + "\\*", "*" );
		}
		return result;
	}
	
	public String split( String text, int quantity ) {
		String splittedText = split( text );
		String[] array = StringUtils.split( splittedText, "\r\n" );
		if( array.length <= quantity ) { return splittedText; }
		String[] resultArray = new String[ quantity ];
		for( int index = 0; index < quantity; index++ ) {
			resultArray[ index ] = array[ new Random().nextInt( array.length )];
		}
		return StringUtils.join( resultArray, "\r\n" );
	}
	
	public static void main( String[] args ) {
		System.out.println( new Splitter().split( "2619603690", 100 ));
	}

	

}
