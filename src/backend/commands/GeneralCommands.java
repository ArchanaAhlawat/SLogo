package backend.commands;

import java.lang.reflect.InvocationTargetException;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * GeneralOperations class
 * Most operations still take two parameters that need to be popped off the stack to do the update and the result returned to the stack
 * Has static final values that are used throughout the hierarchy
 * @author kelly
 * 
 */
public abstract class GeneralCommands implements Command {
	
	protected static final double ZERO = 0.0;
	protected static final double ONE = 1.0;
	protected static final double NEGATE = -1.0;
	
	protected double expr1;
	protected double expr2;
	protected Stacks instructionStacks;
	protected TurtleTree currentTurtle;
	
	public GeneralCommands(Stacks myStack, TurtleTree myTurtle) {
		instructionStacks = myStack;
		currentTurtle = myTurtle;
	}
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
		setParams();
		addReturn(doUpdate());
	}
	
	protected void setParams() {
		expr1 = instructionStacks.popDouble();
		expr2 = instructionStacks.popDouble();
	}

	protected double doUpdate() {
		//do nothing
		return 10.0;
	}
	
	protected void addReturn(double returnVal) {
		instructionStacks.addDouble(returnVal);
	}
}
