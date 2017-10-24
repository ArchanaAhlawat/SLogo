package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a sum command is called
 *     pops the two parameters from the stack
 *     pushes their sum onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Sum implements Command {

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double expr1 = vars.pop();
		double expr2 = vars.pop();
		vars.push(expr1+expr2);
		return vars;
	}

}
