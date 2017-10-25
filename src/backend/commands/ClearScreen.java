package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a clearscreen command is called
 *     does not need any parameters from the stack
 *     moves the turtle to home and clears all of the trails
 *     pushes the distance moved by the turtle to the stack
 * 	   returns the stack of parameters
 * 
 *  @author kelly
 * 
 */
public class ClearScreen implements Command {
	
	private static final double ZERO = 0.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.clearScreen());
		return vars;
	}
}