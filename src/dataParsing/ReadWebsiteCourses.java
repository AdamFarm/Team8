package dataParsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ReadWebsiteCourses implements ReadFile {
	
	ArrayList<String> WebsiteCourses; //used for cross-referencing
	String courseID; // not provided on website
	String acadGroup; // not sure if this is needed, not provided on website
	String catalogID;
	String quarterOffered; 
	double creditHrs; // not provided on website - needs to be updated
	String location; 
	String courseName;
	String description;
	HashMap<String, ArrayList<String>> prereqList; //stored by catalogID
	
	public ReadWebsiteCourses() {
		WebsiteCourses = new ArrayList<String>();
		prereqList = new HashMap<String, ArrayList<String>>();
	}
	
	@Override
	public ArrayList<String> getArray() {
		return WebsiteCourses;
	}

	@Override
	public void readFile(String file) {

		try {
			FileReader inputfile = new FileReader(file);
			BufferedReader reader = new BufferedReader(inputfile);
			String line;

			while ((line = reader.readLine()) != null) {
				ArrayList<String> array = new ArrayList<String>();
				
				StringTokenizer t = new StringTokenizer(line, "\t");
				catalogID = t.nextToken();
				courseName = t.nextToken();
				if (!courseName.equals("REMOVE")) {
					quarterOffered = t.nextToken();
					location = t.nextToken();
					location = location.substring(1, location.length()-1);
					String prereqs = t.nextToken();
					String[] prereqL = prereqs.split(", ");
					for (String s: prereqL) {
						if (s.charAt(0) == '\"') {
							String sub1 = s.substring(1, s.length());
							array.add(sub1);
						}
						else if (s.charAt(s.length()-1) == '\"') {
							String sub2 = s.substring(0, s.length()-1);
							array.add(sub2);
						}
						else { array.add(s); }
					}
					description = t.nextToken();
					description = description.substring(1, description.length() - 1);
					
					prereqList.put(catalogID, array);
				}
				
				if (!WebsiteCourses.contains(catalogID) && !courseName.equals("REMOVE")) {
					WebsiteCourses.add(catalogID);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(WebsiteCourses.size());
	}

}
