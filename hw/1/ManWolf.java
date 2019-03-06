
public class ManWolf {
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
  static final int q9 = 9;  //accepting state
  static final int q10 = 10;//error state

  public static int state;
  public static int[][] delta = {
    {q1, q10, q10, q10}, //from q0
    {q0, q10, q10, q2},  //from q1
    {q10, q3, q4, q1},   //from q2
    {q5, q2, q10, q10},  //from q3
    {q6, q10, q2, q10},  //from q4
    {q3, q10, q7, q10},  //from q5
    {q4, q7, q10, q10},  //from q6
    {q10, q6, q5, q8},   //from q7
    {q9, q10, q10, q7},  //from q8
    {q8, q10, q10, q10}, //from q9(accepting state)
    {q10, q10, q10, q10} //from q10(Error State, wasn't sure if I needed this, but it didn't break anything..)

  };
  public void start() {
	  state = q0;
  }
  public void process(String input) {
    for(int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      try {
        state = delta[state][convert(c)];
      }
      catch(ArrayIndexOutOfBoundsException ex){
        state = q10;
      }

    }
    if(accepted()) {
    	System.out.println("This is a solution");
    }else {
    	System.out.println("This is not a solution.");
    }
  }
  public boolean accepted() {
    return state == q9;
  }
  public int convert(char x) {
	  //since the characters aren't digits, c-'0' doesn't give the right value
    //so I decided to just make a helper method with the value of each character
    //set it's index within a row
	  int g = 0;
	  int w = 1;
	  int c = 2;
	  int n = 3;
    switch(x) {
      case 'g': return g;
      case 'c': return c;
      case 'w': return w;
      case 'n': return n;
    }
    return -1;
  }

}
