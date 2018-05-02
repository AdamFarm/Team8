package dataParsing;

import java.util.ArrayList;

public class DataParser {

	ReadFile fileReader;
	
	public DataParser() {
		//set default read
		fileReader = new ReadQCourses();
	}
	
	public void setReadFile(ReadFile reader) {
		fileReader = reader;
	}
	
	public void performRead(String file) {
		fileReader.readFile(file);
	}
	
	public ArrayList<String> getArray() {
		return fileReader.getArray();
	}
	
	public static void main(String[] args) {
		DataParser dataParser = new DataParser();
		
		dataParser.setReadFile(new ReadQCourses());
		dataParser.performRead("src/Q_COURSES.txt");
		ArrayList<String> q = dataParser.getArray();
		
		
		dataParser.setReadFile(new ReadQCourses2());
		dataParser.performRead("src/Q_COURSES2.txt");
		ArrayList<String> q2 = dataParser.getArray();
		
		dataParser.setReadFile(new ReadWebsiteCourses());
		dataParser.performRead("src/WebsiteCoursesUPDATED.txt");
		ArrayList<String> w = dataParser.getArray();
		
	}
}
