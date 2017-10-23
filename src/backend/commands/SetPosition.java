package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a setposition command is called
 *     pops two parameters needed off the stack to be used to set the position
 *     makes the turtle move to that absolute location
 *     pushes the distance moved to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class SetPosition implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double distance = currentTurtle.setXY(vars.pop(), vars.pop());
		vars.push(distance);
		//TODO: would you get concurrent modification exception if you popped inside of your push?
		//made it two lines to just be safe..
		return vars;
	}
}