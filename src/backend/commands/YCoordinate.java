package backend.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleManager;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a ycor command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for its ycor value
 *     pushes if the turtle's ycor to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class YCoordinate implements Command {
	
	private static final String YCOR = "ycor";
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.getAbsoluteOrientation(YCOR));
	}

}