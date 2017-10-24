package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a not command is called
 *     pops a parameters off the stack
 *     pushes if it is zero onto the stack (inverting the value)
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Not implements Command {

	private static final double ZERO = 0.0;
	private static final double ONE = 1.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double expr = vars.pop();
		if (expr == ZERO) {
			vars.push(ONE);
		}
		else {
			vars.push(ZERO);
		}
		return vars;
	}
}
