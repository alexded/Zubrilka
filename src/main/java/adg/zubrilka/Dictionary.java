package adg.zubrilka;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

	private List<StudyElement> studyElements;
	
	public Dictionary() {
		this.studyElements = new ArrayList<StudyElement>();
	}

	public void add( StudyElement studyElement ) {
		this.studyElements.add( studyElement );
	}

	public List<StudyElement> getStudyElements() {
		return this.studyElements;
	}

}
