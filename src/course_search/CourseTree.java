package course_search;

class CourseTree {
	
	//--------------------------------------------------------------------
	//	 			  All Concentrations : CS Masters
	//--------------------------------------------------------------------

	public static TreeNode<String> getCSTree() {
		TreeNode<String> root = new TreeNode<String>("root");

		// Add Computer Science Courses with No Prerequisites
		TreeNode<String> a1 = root.addChild("CSC 400");
		TreeNode<String> a2 = root.addChild("CSC 401");
		TreeNode<String> a3 = root.addChild("CSC 424");
		TreeNode<String> a4 = root.addChild("CSC 461");
		TreeNode<String> a5 = root.addChild("CSC 480");
		TreeNode<String> a6 = root.addChild("CSC 481");
		TreeNode<String> a7 = root.addChild("CSC 482");
		TreeNode<String> a8 = root.addChild("CSC 486");
		TreeNode<String> a9 = root.addChild("CSC 529");
		TreeNode<String> a10 = root.addChild("GEO 441");
		TreeNode<String> a11 = root.addChild("HCI 430");
		TreeNode<String> a12 = root.addChild("HCI 440");
		TreeNode<String> a13 = root.addChild("HCI 450");
		TreeNode<String> a14 = root.addChild("IS 511");
		TreeNode<String> a15 = root.addChild("IT 599");
		TreeNode<String> a16 = root.addChild("SE 477");
		TreeNode<String> a17 = root.addChild("TDC 478");
		TreeNode<String> a18 = root.addChild("IS 596");

		// Add Nodes with Prerequisites
		TreeNode<String> b2 = a2.addChild("CSC 402");
		TreeNode<String> b3 = a2.addChild("CSC 406");
		TreeNode<String> b4 = a2.addChild("CSC 431");
		TreeNode<String> b5 = a2.addChild("CSC 455");
		TreeNode<String> b6 = a2.addChild("CSC 478");
		TreeNode<String> b7 = a2.addChild("ECT 410");
		TreeNode<String> b8 = a2.addChild("ECT 455");
		TreeNode<String> b9 = a2.addChild("ECT 555");
		TreeNode<String> b10 = a2.addChild("ECT 587");
		TreeNode<String> b11 = a4.addChild("GAM 450");
		TreeNode<String> b12 = a4.addChild("GAM 453");
		TreeNode<String> b13 = a4.addChild("GAM 470");
		TreeNode<String> b14 = a4.addChild("GAM 475");
		TreeNode<String> b15 = a4.addChild("GAM 476");
		TreeNode<String> b16 = a4.addChild("GPH 469");
		TreeNode<String> b17 = a4.addChild("CSC 462");
		TreeNode<String> b18 = a6.addChild("CSC 528");
		TreeNode<String> b19 = a10.addChild("GEO 442");
		TreeNode<String> b20 = a12.addChild("HCI 422");

		TreeNode<String> c1 = b2.addChild("CSC 403");
		TreeNode<String> c2 = b3.addChild("CSC 407");
		TreeNode<String> c3 = b5.addChild("CSC 543");
		TreeNode<String> c4 = b14.addChild("GAM 575");
		TreeNode<String> c5 = b14.addChild("GAM 690");

		TreeNode<String> d1 = c1.addChild("CSC 421");
		TreeNode<String> d2 = c1.addChild("CSC 435");
		TreeNode<String> d3 = c1.addChild("CSC 440");
		TreeNode<String> d4 = c1.addChild("CSC 443");
		TreeNode<String> d5 = c1.addChild("CSC 447");
		TreeNode<String> d6 = c1.addChild("CSC 453");
		TreeNode<String> d7 = c1.addChild("CSC 458");
		TreeNode<String> d8 = c1.addChild("CSC 471");
		TreeNode<String> d9 = c1.addChild("CSC 472");
		TreeNode<String> d10 = c1.addChild("CSC 575");
		TreeNode<String> d11 = c1.addChild("CSC 577");
		TreeNode<String> d12 = c1.addChild("CSC 578");
		TreeNode<String> d13 = c1.addChild("CSC 487");
		TreeNode<String> d14 = c1.addChild("GAM 425");
		TreeNode<String> d15 = c1.addChild("SE 430");
		TreeNode<String> d16 = c1.addChild("SE 433");
		TreeNode<String> d17 = c1.addChild("SE 435");
		TreeNode<String> d18 = c1.addChild("SE 441");
		TreeNode<String> d19 = c1.addChild("SE 450");
		TreeNode<String> d20 = c1.addChild("SE 452");
		TreeNode<String> d21 = c1.addChild("SE 475");
		TreeNode<String> d22 = c2.addChild("CSC 438");
		TreeNode<String> d23 = c2.addChild("CSC 439");
		TreeNode<String> d24 = c2.addChild("CSC 475");
		TreeNode<String> d25 = c4.addChild("GAM 576");

		TreeNode<String> e1 = d1.addChild("CSC 525");
		TreeNode<String> e2 = d2.addChild("CSC 536");
		TreeNode<String> e3 = d2.addChild("SE 526");
		TreeNode<String> e4 = d5.addChild("CSC 436");
		TreeNode<String> e5 = d5.addChild("CSC 448");
		TreeNode<String> e6 = d6.addChild("CSC 553");
		TreeNode<String> e7 = d6.addChild("CSC 554");
		TreeNode<String> e8 = d6.addChild("CSC 555");
		TreeNode<String> e9 = d8.addChild("CSC 491");
		TreeNode<String> e10 = d19.addChild("CSC 552");
		TreeNode<String> e11 = d19.addChild("CSC 588");
		TreeNode<String> e12 = d19.addChild("SE 457");
		TreeNode<String> e13 = d19.addChild("SE 459");
		TreeNode<String> e14 = d19.addChild("SE 480");
		TreeNode<String> e15 = d19.addChild("SE 491");
		TreeNode<String> e16 = d19.addChild("SE 552");
		TreeNode<String> e17 = d19.addChild("SE 554");

		TreeNode<String> f1 = e15.addChild("SE 591");
		return root;

	}

	//--------------------------------------------------------------------
	//	 Business Analysis/Systems Analysis Concentration : IS Masters
	//--------------------------------------------------------------------

	public static TreeNode<String> getISBATree() {
		TreeNode<String> root = new TreeNode<String>("root");

		TreeNode<String> f1 = root.addChild("CSC 451"); 
		TreeNode<String> f2 = root.addChild("IS 421");
		TreeNode<String> f3 = root.addChild("IS 430");
		TreeNode<String> a1 = root.addChild("CNS 440");
		TreeNode<String> a5 = root.addChild("IS 560");
		TreeNode<String> me1 = root.addChild("ECT 424");
		TreeNode<String> me2 = root.addChild("IS 444");
		TreeNode<String> me3 = root.addChild("HCI 440");
		TreeNode<String> me4 = root.addChild("IS 431");
		TreeNode<String> me5 = root.addChild("IS 440");
		TreeNode<String> me7 = root.addChild("IS 578");

		TreeNode<String> f4 = f1.addChild("IS 422");
		TreeNode<String> a2 = f2.addChild("IS 435");
		TreeNode<String> a3 = f3.addChild("IS 485");
		TreeNode<String> a4 = f3.addChild("IS 535");
		TreeNode<String> me6 = f3.addChild("IS 556");

		TreeNode<String> c1 = f3.addChild("IS 577");

		return root;
	}
	
	//--------------------------------------------------------------------
	//	 		Business Intelligence Concentration : IS Masters
	//--------------------------------------------------------------------

	public static TreeNode<String> getISBITree() {
		TreeNode<String> root = new TreeNode<String>("root");

		TreeNode<String> i1 = root.addChild("IT 411");
		TreeNode<String> i2 = root.addChild("CSC 401");
		TreeNode<String> i3 = root.addChild("IT 403");
		TreeNode<String> f1 = root.addChild("CSC 451"); 
		TreeNode<String> f2 = root.addChild("IS 421");
		TreeNode<String> f3 = root.addChild("IS 430");
		TreeNode<String> me1 = root.addChild("CSC 424");
		TreeNode<String> me2 = root.addChild("GEO 441");
		TreeNode<String> me3 = root.addChild("IS 452");
		
		TreeNode<String> f4 = f1.addChild("IS 422");
		TreeNode<String> x1 = f2.addChild("IS 435");
		TreeNode<String> a2 = i3.addChild("CSC 423");
		TreeNode<String> a3 = f1.addChild("IS 549");
		TreeNode<String> me4 = f3.addChild("IS 556");
		TreeNode<String> me5 = f1.addChild("IS 550");
		
		TreeNode<String> a1 = x1.addChild("IS 574");
		
		TreeNode<String> c1 = f3.addChild("IS 577");
		
		return root;
	}

	//--------------------------------------------------------------------
	//	 	Database Administration Concentration : IS Masters
	//--------------------------------------------------------------------

	public static TreeNode<String> getISDATree() {
		TreeNode<String> root = new TreeNode<String>("root");
		
		TreeNode<String> i1 = root.addChild("IT 411");
		TreeNode<String> i2 = root.addChild("CSC 401");
		TreeNode<String> f1 = root.addChild("CSC 451"); 
		TreeNode<String> f2 = root.addChild("IS 421");
		TreeNode<String> f3 = root.addChild("IS 430");
		TreeNode<String> me1 = root.addChild("CNS 440");
		TreeNode<String> me2 = root.addChild("IS 452");
		TreeNode<String> me3 = root.addChild("IS 505");
		TreeNode<String> me4 = root.addChild("IS 536");
		
		TreeNode<String> f4 = f1.addChild("IS 422");
		TreeNode<String> a1 = f1.addChild("IS 549");
		TreeNode<String> a2 = f1.addChild("CSC 454");
		TreeNode<String> a3 = f1.addChild("CSC 452");
		TreeNode<String> me5 = f1.addChild("IS 550");
		
		TreeNode<String> a4 = a2.addChild("CSC 554"); 
		
		TreeNode<String> c1 = f3.addChild("IS 577");

		return root;
	}

	//--------------------------------------------------------------------
	//	 	 IT Enterprise Management Concentration : IS Masters
	//--------------------------------------------------------------------

	public static TreeNode<String> getISITTree() {
		TreeNode<String> root = new TreeNode<String>("root");
		
		TreeNode<String> f1 = root.addChild("CSC 451"); 
		TreeNode<String> f2 = root.addChild("IS 421");
		TreeNode<String> f3 = root.addChild("IS 430");
		TreeNode<String> a1 = root.addChild("ECT 424");
		TreeNode<String> me1 = root.addChild("CNS 440");
		TreeNode<String> me2 = root.addChild("IS 440");
		TreeNode<String> me3 = root.addChild("IS 444");
		TreeNode<String> me4 = root.addChild("CSC 482");
		TreeNode<String> me5 = root.addChild("IS 500");
		TreeNode<String> me6 = root.addChild("IS 505");
		TreeNode<String> me7 = root.addChild("IS 536");
		TreeNode<String> me9 = root.addChild("IS 560");
		TreeNode<String> me10 = root.addChild("IS 579");
		
		TreeNode<String> f4 = f1.addChild("IS 422");
		TreeNode<String> a2 = f3.addChild("IS 556");
		TreeNode<String> a3 = f3.addChild("IS 570");
		TreeNode<String> a4 = f3.addChild("IS 535");
		TreeNode<String> me8 = f1.addChild("IS 550");

		TreeNode<String> c1 = f3.addChild("IS 577");

		return root;
	}

	//--------------------------------------------------------------------
	//	 			 Standard Concentration : IS Masters
	//--------------------------------------------------------------------

	public static TreeNode<String> getISSCTree() {
		TreeNode<String> root = new TreeNode<String>("root");
		
		TreeNode<String> f1 = root.addChild("CSC 451"); 
		TreeNode<String> f2 = root.addChild("IS 421");
		TreeNode<String> f3 = root.addChild("IS 430");
		TreeNode<String> me1 = root.addChild("CNS 440");
		TreeNode<String> me2 = root.addChild("IS 452");
		TreeNode<String> me4 = root.addChild("IS 536");
		TreeNode<String> me5 = root.addChild("CSC 424");
		TreeNode<String> me6 = root.addChild("IS 440");
		TreeNode<String> me7 = root.addChild("IS 444");
		TreeNode<String> me8 = root.addChild("CSC 482");
		TreeNode<String> me9 = root.addChild("IS 536");
		TreeNode<String> me10 = root.addChild("IS 560");
		TreeNode<String> me11 = root.addChild("IS 579");
		TreeNode<String> me12 = root.addChild("GEO 441");
		TreeNode<String> me13 = root.addChild("IS 452");
		
		TreeNode<String> f4 = f1.addChild("IS 422");
		TreeNode<String> me14 = f3.addChild("IS 556");
		TreeNode<String> me15 = f3.addChild("IS 570");
		TreeNode<String> me16 = f3.addChild("IS 535");
		TreeNode<String> me17 = f1.addChild("IS 550");
		
		TreeNode<String> c1 = f3.addChild("IS 577");

		return root;
	}
	
	//--------------------------------------------------------------------
	//	  Open Elective Courses for Information Systems Masters Program
	//--------------------------------------------------------------------
	
	public static TreeNode<String> getOpenElectivesIS() {
		TreeNode<String> root = new TreeNode<String>("root");

		TreeNode<String> o1 = root.addChild("CSC 482");
		TreeNode<String> o2 = root.addChild("CSC 486");
		TreeNode<String> o3 = root.addChild("CSC 529");
		TreeNode<String> o4 = root.addChild("ECT 424");
		TreeNode<String> o5 = root.addChild("CNS 440");
		TreeNode<String> o6 = root.addChild("CSC 424");
		TreeNode<String> o7 = root.addChild("CSC 451");
		TreeNode<String> o8 = root.addChild("CSC 461");
		TreeNode<String> o9 = root.addChild("CSC 480");
		TreeNode<String> o10 = root.addChild("CSC 481");
		TreeNode<String> o11 = root.addChild("GEO 441");
		TreeNode<String> o12 = root.addChild("IS 500");
		TreeNode<String> o13 = root.addChild("IS 505");
		TreeNode<String> o14 = root.addChild("IS 511");
		TreeNode<String> o15 = root.addChild("IS 536");
		TreeNode<String> o16 = root.addChild("IT 599");
		TreeNode<String> o17 = root.addChild("IS 560");
		TreeNode<String> o18 = root.addChild("IS 578");
		TreeNode<String> o19 = root.addChild("IS 579");
		TreeNode<String> o20 = root.addChild("IS 596");
		TreeNode<String> o21 = root.addChild("HCI 430");
		TreeNode<String> o22 = root.addChild("HCI 440");
		TreeNode<String> o23 = root.addChild("HCI 450");
		TreeNode<String> o24 = root.addChild("IS 421");
		TreeNode<String> o25 = root.addChild("IS 430");
		TreeNode<String> o26 = root.addChild("IS 431");
		TreeNode<String> o27 = root.addChild("IS 440");
		TreeNode<String> o28 = root.addChild("IS 444");
		TreeNode<String> o29 = root.addChild("IS 452");
		TreeNode<String> o30 = root.addChild("IS 455");
		TreeNode<String> o31 = root.addChild("IS 482");
		TreeNode<String> o32 = root.addChild("SE 477");
		TreeNode<String> o33 = root.addChild("TD 478");
		
		return root;
	}

}
