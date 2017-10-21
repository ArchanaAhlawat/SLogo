package Backend;

import java.util.Stack;

public class Sum implements Instruction {
	private int returnVal;
	
	public Stack<Integer> execute(Stack<Integer> Vars) {
		returnVal = Vars.pop() + Vars.pop();
		Vars.push(returnVal);
		return Vars;
	}

	public int getReturnValue() {
		return returnVal;
	}

}
