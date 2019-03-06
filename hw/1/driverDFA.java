
public class driverDFA {
  public static void main(String[]args) {
    ManWolf DFA = new ManWolf();
    String input = args[0];
    DFA.start();
    DFA.process(input);
  }
}
