package Backend;

import java.util.Stack;

public interface Instruction {
	public int returnVal = 0;
	
	public Stack<Integer> execute(Stack<Integer> Vars);
	
	public int getReturnValue();
	
}
