package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a power command is called
 *     pops two parameters off the stack, the base and the exponent
 *     pushes the value of the base to the exponent onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Power implements Command {

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double base = vars.pop();
		double exponent = vars.pop();
		vars.push(Math.pow(base,exponent));
		return vars;
	}
}
