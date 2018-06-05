package dataParsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ReadQCourses2 implements ReadFile {

	ArrayList<String> Q_COURSES2;
	String courseID;
	String acadGroup; // not sure if this is needed
	String catalogID;
	String quarterOffered; //not included on this spreadsheet - will be blank for all
	double creditHrs;
	String location;
	String courseName;
	String description;
	HashMap<String, ArrayList<String>> prereqList; //stored by catalogID
	
	public ReadQCourses2() {
		Q_COURSES2 = new ArrayList<String>();
		prereqList = new HashMap<String, ArrayList<String>>();
	}
	
	@Override
	public ArrayList<String> getArray() {
		return Q_COURSES2;
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
				t.nextToken();
				t.nextToken();
				t.nextToken();
				catalogID = t.nextToken();
				t.nextToken();
				catalogID += t.nextToken();
				for (int i = 0; i <= 3; i++) {
					t.nextToken();
				}
				acadGroup = t.nextToken();
				t.nextToken();
				t.nextToken();
				t.nextToken();
				courseName = t.nextToken();
				description = t.nextToken();
				for (int i = 0; i <= 5; i++) {
					t.nextToken();
				}
				location = t.nextToken();
				t.nextToken();
				creditHrs = Double.parseDouble(t.nextToken());
				
				String prereq = description.substring(description.indexOf("):")+1, description.length());
				StringTokenizer tokenizer = new StringTokenizer(prereq, " ");
				ArrayList<String> arr = new ArrayList<String>();
				while (tokenizer.hasMoreTokens()) {
					String next = tokenizer.nextToken();
					if (next.contains("None")) { 
						arr.add("");
					}
					else if (next.equals("SE") || next.equals("IS") || next.equals("CNS") || next.equals("GAM") || next.equals("HIT") ||next.equals("IT") || next.equals("CSC") || next.equals("HCI") || next.equals("ECT") || next.equals("PM") || next.equals("MIS") || next.equals("TDC") ) {
						String num = tokenizer.nextToken();
						if (num.length() >= 3 && !num.contains("cor") && !num.contains("pro") && !num.contains("con") && !num.contains("rel") && !num.contains("fou")) {
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
				
				if (!Q_COURSES2.contains(catalogID)) {
					Q_COURSES2.add(catalogID);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//System.out.println(Q_COURSES2.size());
	}

}