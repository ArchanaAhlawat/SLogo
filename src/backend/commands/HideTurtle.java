package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * @author kelly
 * has the execute for when a hideturtle command is called
 *     does not need any parameters from the stack
 *     makes the turtle invisible (hidden)
 *     pushes the command return value (0) to the stack
 *     returns the stack of parameters
 *
 */
public class HideTurtle implements Command {
	
	private static final double ZERO = 0.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.visChange(ZERO));
		return vars;
	}
}