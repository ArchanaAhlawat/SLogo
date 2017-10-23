package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a random command is called
 *     pops a parameter off the stack, the max
 *     pushes a random non-negative number less than max onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Random implements Command {

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double max = vars.pop();
		vars.push(Math.random()*max); //Math.random() is 0.0 (inclusive) to 1.0 (exclusive)
		return vars;
	}
}
