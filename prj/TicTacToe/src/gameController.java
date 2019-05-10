
public class gameController {
	
	
	//giving each state a variable 
	  //makes it easier to read
	  static final int q0 = 0;  //initial state
	  static final int q1 = 1;
	  static final int q2 = 2;
	  static final int q3 = 3;
	  static final int q4 = 4;
	  static final int q5 = 5;
	  static final int q6 = 6;
	  static final int q7 = 7;
	  static final int q8 = 8;
	  static final int q9 = 9;  
	  static final int q10 = 10;
	  static final int q11 = 11;
	  static final int q12 = 12;
	  static final int q13 = 13;
	  static final int q14 = 14;
	  static final int q15 = 15;
	  static final int q16 = 16;
	  static final int q17 = 17;
	  static final int q18 = 18;
	  static final int q19 = 19;  
	  static final int q20 = 20;
	  static final int q21 = 21;
	  static final int q22 = 22;
	  static final int q23 = 23;
	  static final int q24 = 24;
	  static final int q25 = 25;
	  static final int q26 = 26;
	  static final int q27 = 27;
	  static final int q28 = 28;
	  static final int q29 = 29;  
	  static final int q30 = 30;
	  static final int q31 = 31;
	  static final int q32 = 32;
	  static final int q33 = 33;
	  static final int q34 = 34;
	  static final int q35 = 35;
	  static final int q36 = 36;
	  static final int q37 = 37;
	  static final int q38 = 38;
	  static final int q39 = 39;  
	  static final int q40 = 40;
	  static final int q41 = 41;
	  static final int q42 = 42;
	  static final int q43 = 43;
	  static final int q44 = 44;
	  static final int q45 = 45;
	  static final int q46 = 46;
	  static final int q47 = 47;
	  
	  public static int state;
	  
	  public static int[][] deltaX = {
			  {q2, q1, q2},//q0
			  {q4, q3, q4},//q1
			  {q9, q13, q9},//q2
			  {q14, q6, q14},//q3
			  {q8, q31, q8},//q4
			  {q7, q42, q7},//q5
			  {q6, q6, q6},//q6
			  {q10, q10, q10},//q7
			  {q41, q5, q41},//q8
			  {q12, q31, q12},//q9
			  {q47, q20, q47},//q10
			  {q44, q39, q44},//q11
			  {q24, q40, q24},//q12
			  {q14, q14, q14},//q13
			  {q15, q15, q15},//q14
			  {q25, q16, q25},//q15
			  {q17, q17, q17},//q16
			  {q18, q18, q18},//q17
			  {q47, q19, q47},//q18
			  {q19, q19, q19},//q19
			  {q20, q20, q20},//q20
			  {q21, q21, q21},//q21
			  {q47, q23, q47},//q22
			  {q23, q23, q23},//q23
			  {q25, q25, q25},//q24
			  {q26, q26, q26},//q25
			  {q26, q27, q26},//q26
			  {q27, q28, q27},//q27
			  {q28, q29, q28},//q28
			  {q29, q29, q29},//q29
			  {q30, q21, q30},//q30
			  {q32, q40, q32},//q31
			  {q33, q38, q33},//q32
			  {q33, q34, q33},//q33
			  {q35, q35, q35},//q34
			  {q36, q36, q36},//q35
			  {q36, q37, q36},//q36
			  {q37, q37, q37},//q37
			  {q11, q34, q11},//q38
			  {q39, q39, q39}, //q39
			  {q25, q22, q25}, //q40
			  {q24, q42, q24}, //q47
			  {q43, q43, q43}, //q42
			  {q44, q40, q44}, //q43
			  {q45, q22, q45}, //q44
			  {q45, q46, q45}, //q45
			  {q46, q46, q46}, //q46
			  {q47, q47, q47} //q47 error state
			  
	  };
	  
	  public static int[][] deltaO = {
			  {q2, q2, q1},//q0
			  {q4, q4, q3},//q1
			  {q9, q9, q13},//q2
			  {q14, q14, q6},//q3
			  {q8, q8, q31},//q4
			  {q7, q7, q42},//q5
			  {q6, q6, q6},//q6
			  {q10, q10, q10},//q7
			  {q41, q41, q5},//q8
			  {q12, q12, q31},//q9
			  {q47, q47, q20},//q10
			  {q44, q44, q39},//q11
			  {q24, q24, q40},//q12
			  {q14, q14, q14},//q13
			  {q15, q15, q15},//q14
			  {q25, q25, q16},//q15
			  {q17, q17, q17},//q16
			  {q18, q18, q18},//q17
			  {q47, q47, q19},//q18
			  {q19, q19, q19},//q19
			  {q20, q20, q20},//q20
			  {q21, q21, q21},//q21
			  {q47, q47, q23},//q22
			  {q23, q23, q23},//q23
			  {q25, q25, q25},//q24
			  {q26, q26, q26},//q25
			  {q47, q47, q27},//q26
			  {q47, q47, q28},//q27
			  {q28, q28, q29},//q28
			  {q29, q29, q29},//q29
			  {q30, q30, q30},//q30
			  {q32, q32, q40},//q31
			  {q33, q33, q38},//q32
			  {q33, q33, q34},//q33
			  {q35, q35, q35},//q34
			  {q36, q36, q36},//q35
			  {q36, q36, q37},//q36
			  {q37, q37, q37},//q37
			  {q11, q11, q11},//q38
			  {q39, q39, q39}, //q39
			  {q25, q25, q22}, //q40
			  {q24, q24, q42}, //q41
			  {q43, q43, q42}, //q42
			  {q44, q44, q40}, //q43
			  {q45, q45, q44}, //q44
			  {q45, q45, q46}, //q45
			  {q47, q47, q47} //q47 error state
			  
	  };
	  public void start() {
		  state = q0;
		  System.out.println("-----------NEW INPUT STRING------------");
		  System.out.println("");
	  }
	  public boolean processX(String input) {
		String testString = nix('2',input);
		start();
	    for(int i = 0; i < testString.length(); i++) {
	      char c = testString.charAt(i);
	      try {
	    	System.out.println(c);
	        state = deltaX[state][c - '0'];
	        System.out.println("new state: " + state);
	      }catch(ArrayIndexOutOfBoundsException ex){
	    	state = q47;
	      }
	      if(isAccepting(state)) {
	    	return true;
	      }
	    }
	    return false;
	  }
	  public boolean processO(String in) {
		  String testString = nix('1',in);
		  System.out.println(testString);
		  start();
		   for(int i = 0; i < testString.length(); i++) {
		     char c = testString.charAt(i);
		     try {
		       System.out.println(c);
		       state = deltaO[state][c - '0'];
		       System.out.println("new state: " + state);
		     }catch(ArrayIndexOutOfBoundsException ex){
		       state = q47;
		     }
		     if(isAccepting(state)) {
		       return true;
		     }
		 }
		 return false;
	  } 
	  public boolean isAccepting(int s) {
		  return s == q6 || s == q19 || s == q46 || s == q37 || s == q39 || s == q20 || s == q23 || s == q29;
	  }
	public gameController() {
		start();
	}
	
	public String nix(char toRemove, String orig) {
		StringBuilder s = new StringBuilder(orig);
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == toRemove) {
				s.setCharAt(i, '0');
			}
		}
		return s.toString();
	}
}



