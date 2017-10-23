package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a home command is called
 *     does not need any parameters from the stack
 *     moves the turtle to home (0,0)
 *     pushes the distance moved by the turtle to the stack
 * 	   returns the stack of parameters
 * 
 * @author kelly
 * 
 */
public class Home implements Command {
	
	private static final double ZERO = 0.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.home());
		return vars;
	}
}