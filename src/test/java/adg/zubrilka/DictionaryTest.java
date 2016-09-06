package adg.zubrilka;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {
	
	@Test public void addStudyElement() {
		Dictionary dictionary = new Dictionary();
		StudyElement studyElement = new StudyElement();
		dictionary.add( studyElement );
		
		Assert.assertEquals( 1, dictionary.getStudyElements().size() );
	}

}
