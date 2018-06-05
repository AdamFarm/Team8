package course_search;

import java.sql.ResultSet;

public class StandardConcentration extends TreeSearchIS{

	public StandardConcentration(ResultSet rset, String concentration, int max_credit_hours, String current_quarter) {
		super(rset, concentration, max_credit_hours, current_quarter);
		
		this.treeRoot = CourseTree.getISSCTree();
		this.intro_count = 0;
		this.found_count = 4;
		this.adv_count = 0;
		this.major_elect_count = 7; // max 7
		this.open_elect_count = 1; // max 1
		this.cap_count = 1;
	}

}
