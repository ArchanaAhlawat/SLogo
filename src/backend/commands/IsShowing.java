package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a isshowing command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for the turtlevis value
 *     pushes if the turtle is visible or not to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class IsShowing implements Command {
	
	private static final String SHOWING = "turtleVis";
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.getAbsoluteOrientation(SHOWING));
		return vars;
	}
}