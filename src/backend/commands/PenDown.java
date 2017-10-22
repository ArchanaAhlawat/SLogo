package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * @author kelly
 * has the execute for when a pendown command is called
 *     doesn't need any input parameters from the stack
 *     sets the pen to down and tracks the trails drawn by the turtle in the next commands
 *     pushes the return value from the pendown command (1) to the stack
 * 	   returns the stack of parameters
 * 
 */
public class PenDown implements Command {
	
	private static final double ONE = 1.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push((double) currentTurtle.penChange(ONE));
		return vars;
	}
}