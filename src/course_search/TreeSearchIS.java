package course_search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TreeSearchIS {
	
	HashMap<String, String[]> courses = new HashMap<String, String[]>();
	ArrayList<String> list = new ArrayList<String>();

	TreeNode<String> openElectiveTreeRoot = CourseTree.getOpenElectivesIS();
	
	ResultSet rset;
	String concentration, current_quarter;
	int max_credit_hours, intro_count, found_count, adv_count, major_elect_count, open_elect_count, cap_count;
	TreeNode<String> treeRoot;

	int year = 2018;
	ArrayList<String> quarters = new ArrayList<String>();
	int quarterNum;
	int current_credit_hours = 4;
	String quarterFinal = current_quarter+" "+year+"/"+(year+1);

	public TreeSearchIS(ResultSet rset, String concentration, int max_credit_hours, String current_quarter) {
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
			if (rset.getString(6).contains("Information Systems")) {
				String[] data = new String[3];
				data[0] = rset.getString(5);
				data[1] = rset.getString(8);
				data[2] = rset.getString(10);
				courses.put(rset.getString(1), data);
			}
		}
		TreeNode<String> root = treeRoot.findTreeNode("root");
		root.meta_data = "visited";
		traverse(root);
		if (open_elect_count != 0) {
			TreeNode<String> r = openElectiveTreeRoot.findTreeNode("root");
			r.meta_data = "visited";
			traverseOpenElectiveTree(openElectiveTreeRoot);
		}
		
		System.out.println(list);
	}

	public void traverse(TreeNode<String> f) {
		if (f.meta_data.equals("visited")) {
			for (TreeNode<String> c : f.children) {
				c.meta_data = "visited";
				//intro courses
				if (courses.get(c.toString()) != null
						&& courses.get(c.toString())[1].contains("Introductory")
						&& intro_count != 0) {
					intro_count--;
					addCreditHours();
					list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
				}

				//foundation courses
				else if (courses.get(c.toString()) != null
						&& courses.get(c.toString())[1].contains("Foundation")
						&& found_count != 0) {
					found_count--;
					addCreditHours();
					list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
				}

				//advanced courses
				else if (courses.get(c.toString()) != null
						&& courses.get(c.toString())[1].contains("Advanced")
						&& adv_count != 0) {
					adv_count--;
					addCreditHours();
					list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
				}

				//major elective courses
				else if (courses.get(c.toString()) != null
						&& courses.get(c.toString())[1].contains("Major Elective")
						&& major_elect_count != 0) {
					major_elect_count--;
					addCreditHours();
					list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
				}

				//capstone
				else if (courses.get(c.toString()) != null
						&& courses.get(c.toString())[1].contains("Capstone")
						&& cap_count != 0) {
					cap_count--;
					addCreditHours();
					list.add(c.toString()+": "+current_quarter+" "+year+"/"+(year+1));
				}

				traverse(c);
			}
		}
	}

	public void traverseOpenElectiveTree(TreeNode<String> f) {
		if (f.meta_data.equals("visited")) {
			for (TreeNode<String> c : f.children) {
				c.meta_data = "visited";
				if (courses.get(c.toString()) != null 
						&& open_elect_count != 0
						&& !list.toString().contains(c.toString())) {
					open_elect_count--;
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
