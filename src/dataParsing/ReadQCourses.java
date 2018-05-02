package dataParsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ReadQCourses implements ReadFile {

	ArrayList<String> Q_COURSES; //used for cross-referencing
	String courseID;
	String acadGroup; // not sure if this is needed
	String catalogID;
	String quarterOffered; // this needs to be the way we determine quarters offered - NOT COMPLETED
	double creditHrs;
	String location; //not included on this spreadsheet - all will be blank
	String courseName;
	String description;
	HashMap<String, ArrayList<String>> prereqList; //stored by catalogID


	public ReadQCourses() {
		Q_COURSES = new ArrayList<String>();
		prereqList = new HashMap<String, ArrayList<String>>();
	}
	
	@Override
	public ArrayList<String> getArray() {
		return Q_COURSES;
	}

	@Override
	public void readFile(String file) {
		try {

			FileReader inputfile = new FileReader(file);
			BufferedReader reader = new BufferedReader(inputfile);
			String line;

			while ((line = reader.readLine()) != null) {
				StringTokenizer t = new StringTokenizer(line, "\t");
				courseID = t.nextToken();
				acadGroup = t.nextToken();
				catalogID = t.nextToken() + t.nextToken();
				if (!Q_COURSES.contains(catalogID)) {
					Q_COURSES.add(catalogID);
				}
				t.nextToken();
				quarterOffered = t.nextToken();
				for (int i = 0; i <= 3; i++) {
					t.nextToken();
				}
				creditHrs = Double.parseDouble(t.nextToken());
				for (int i = 0; i <= 5; i++) {
					t.nextToken();
				}
				courseName = t.nextToken();
				t.nextToken();
				description = t.nextToken();

				String prereq = description.substring(description.indexOf(":")+1, description.length());
				StringTokenizer tokenizer = new StringTokenizer(prereq, " ");
				ArrayList<String> arr = new ArrayList<String>();
				while (tokenizer.hasMoreTokens()) {
					String next = tokenizer.nextToken();
					if (next.contains("None")) { 
						arr.add("");
					}
					else if (next.equals("SE") || next.equals("IS") || next.equals("CNS") || next.equals("GAM") || next.equals("HIT") ||next.equals("IT") || next.equals("CSC") || next.equals("HCI") || next.equals("ECT") || next.equals("PM") || next.equals("MIS") || next.equals("TDC") ) {
						String num = tokenizer.nextToken();
						if (num.length() >= 3 && !num.contains("cor") && !num.contains("pro")) {
							num = num.substring(0, 3);
							arr.add(next + " " + num);
						}
					}
					else if (next.contains("Successful")) {
						arr.add("Remove. Dissertation not in requirements");
					}
					else if (next.contains("Instructor") || next.contains("Advanced") || next.contains("Completion")) {
						arr.add("See advisor");
					}
				}
				prereqList.put(catalogID, arr);
				//System.out.printf("Course: %s, Prereqs: %s\n", catalogID, arr.toString());
			}
		reader.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

	//System.out.println(Q_COURSES.size()); //prints size of ArrayList containing all courses
}

}