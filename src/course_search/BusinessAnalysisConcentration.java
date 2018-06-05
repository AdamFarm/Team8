package course_search;

import java.sql.ResultSet;

public class BusinessAnalysisConcentration extends TreeSearchIS{

	public BusinessAnalysisConcentration(ResultSet rset, String concentration, int max_credit_hours,
			String current_quarter) {
		super(rset, concentration, max_credit_hours, current_quarter);
		
		this.treeRoot = CourseTree.getISBATree();
		this.intro_count = 0;
		this.found_count = 4;
		this.adv_count = 5;
		this.major_elect_count = 2; // max 2
		this.open_elect_count = 1; // max 1
		this.cap_count = 1;
	}
	
}
