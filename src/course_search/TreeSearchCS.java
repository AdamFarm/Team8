package course_search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TreeSearchCS {
	
	ResultSet rset;
	
	HashMap<String, String[]> courses = new HashMap<String, String[]>();
	TreeNode<String> treeRoot = CourseTree.getCSTree();
	ArrayList<String> list = new ArrayList<String>();

	int intro_count = 0; // max 6
	int found_count = 0; // max 5
	int conc_count = 0; // max 4
	int elect_count = 0; // max 4
	
//	NOT NEEDED - BUT THESE ARE THE CONCENTRATION OPTIONS
//	//  int max_credit_hours = 12;
//	//	String concentration = "Software Engineering";
//	//	String concentration = "Theory"; 
//	//  String concentration = "Data Science";
//	//  String concentration = "Database Systems";
//	//	String concentration = "Artificial Intelligence";
//	//	String concentration = "Game and Real-Time Systems";
//	//	String concentration = "Human-Computer Interaction";
//	//	String concentration = "Software and Systems Development";
//  //	String current_quarter = "Fall"; //update
	
	String concentration, current_quarter;
	int max_credit_hours;

	int year = 2018;
	ArrayList<String> quarters = new ArrayList<String>();
	int quarterNum;
	int current_credit_hours = 4;
	String quarterFinal = current_quarter+" "+year+"/"+(year+1);

	public TreeSearchCS(ResultSet rset, String concentration, int max_credit_hours, String current_quarter) {
		this.rset = rset;
		this.concentration = concentration;
		this.max_credit_hours = max_credit_hours;
		this.current_quarter = current_quarter;
		
		quarters.add("Summer"); quarters.add("Fall");  quarters.add("Winter"); quarters.add("Spring");
		for (String q: quarters) {
			if (q.equals(current_quarter)) {
				quarterNum = quarters.indexOf(q);
			}
		}
	}

	public void getCourses(ResultSet rset) throws SQLException{ 
		while (rset.next()) {
			if (rset.getString(6).contains("Computer Science")) {
				String[] data = new String[3];
				data[0] = rset.getString(5);
				data[1] = rset.getString(8);
				data[2] = rset.getString(10);
				courses.put(rset.getString(1), data);
			}
		}
		TreeNode<String> r = treeRoot.findTreeNode("root");
		r.meta_data = "visited";
		traverse(r);
		traverse(r);
		if (intro_count != 6 || found_count != 5 || conc_count != 4 || elect_count != 4) {
			if (quarterNum < 3) {
				quarterNum++;
				current_quarter = quarters.get(quarterNum);
			}
			else {
				quarterNum = 0;
				year++;
				current_quarter = quarters.get(quarterNum);
			}
			current_credit_hours = 4;
			traverse(r);
		}
		//		while (intro_count != 6 || found_count != 5 || conc_count != 4 || elect_count != 4) {
		//			if (quarterNum < 3) {
		//				quarterNum++;
		//				current_quarter = quarters.get(quarterNum);
		//			}
		//			else {
		//				quarterNum = 0;
		//				year++;
		//				current_quarter = quarters.get(quarterNum);
		//			}
		//			current_credit_hours = 4;
		//			traverse(r);
		//		}

		System.out.println(list);
	}

	public void traverse(TreeNode<String> f) {
		if (f.meta_data.equals("visited")) {
			for (TreeNode<String> c : f.children) {
				c.meta_data = "visited";
				if (courses.get(c.toString()) != null 
						&& courses.get(c.toString())[1].contains("Introductory") 
						&& intro_count != 6
						&& courses.get(c.toString())[2].contains(current_quarter)) { 
					intro_count++;
					addCreditHours();
					list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
				}
				else if (courses.get(c.toString()) != null 
						&& courses.get(c.toString())[1].contains("Foundation") 
						&& found_count != 5
						&& courses.get(c.toString())[2].contains(current_quarter)) {
					if (!list.toString().contains(c.toString())) {
						found_count++;
						addCreditHours();
						list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
					}
				}
				else if (courses.get(c.toString()) != null 
						&& courses.get(c.toString())[1].contains(concentration) 
						&& conc_count != 4
						&& courses.get(c.toString())[2].contains(current_quarter)) {
					conc_count++;
					addCreditHours();
					list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
				}
				else if (courses.get(c.toString()) != null 
						&& elect_count != 4
						&& courses.get(c.toString())[2].contains(current_quarter)) {
					elect_count++;
					addCreditHours();
					list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
				}
				traverse(c);
			}
		}
	}

	public void addCreditHours() {
		if (current_credit_hours < max_credit_hours) {
			current_credit_hours += 4;
		}
		else {
			if (quarterNum < 3) {
				quarterNum++;
				current_quarter = quarters.get(quarterNum);
			}
			else {
				quarterNum = 0;
				year++;
				current_quarter = quarters.get(quarterNum);
			}
			current_credit_hours = 4;
		}
	}
}
