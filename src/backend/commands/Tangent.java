package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a tangent command is called
 *     pops a parameter off the stack, the number of degrees
 *     pushes the tangent of this onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Tangent implements Command {
	private static final double RADTODEG = 180.0/Math.PI;
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double tan = Math.tan(vars.pop()*RADTODEG);
		vars.push(tan); //Math.random() is 0.0 (inclusive) to 1.0 (exclusive)
		return vars;
	}
}
