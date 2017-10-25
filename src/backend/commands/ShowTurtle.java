package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a showturtle command is called
 *     does not need any parameters from the stack
 *     makes the turtle visible (shown)
 *     pushes the command return value (1) to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class ShowTurtle implements Command {
	
	private static final double ONE = 1.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.visChange(ONE));
		return vars;
	}
}