package Backend;

import java.util.Stack;

public class Forward implements Instruction {
	private int returnVal;
	
	public Stack<Integer> execute(Stack<Integer> Vars) {
		returnVal = Vars.pop();
		return Vars; // new Stack
	}
	
	public int getReturnValue() {
		return returnVal;
	}
}
