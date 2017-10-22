package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * @author kelly
 * has the execute for when a left command is called
 *     peeks at the first value in the stack (parameter of degrees to turn left)
 *     rotates the turtle left by that number of degrees
 *     doesn't need to push anything to the stack bc the parameter returned is what was peeked (not popped!)
 * 	   returns the stack of parameters
 * 
 */
public class Left implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		currentTurtle.rotate(-1*vars.peek());
		return vars;
	}
}