package course_search;

import java.sql.ResultSet;

public class ITEnterpriseManagementConcentration extends TreeSearchIS {

	public ITEnterpriseManagementConcentration(ResultSet rset, String concentration, int max_credit_hours,
			String current_quarter) {
		super(rset, concentration, max_credit_hours, current_quarter);

		this.treeRoot = CourseTree.getISITTree();
		this.intro_count = 0;
		this.found_count = 4;
		this.adv_count = 4;
		this.major_elect_count = 3; // max 3
		this.open_elect_count = 1; // max 1
		this.cap_count = 1;
	}

}
