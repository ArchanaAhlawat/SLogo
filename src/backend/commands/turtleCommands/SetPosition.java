package backend.commands.turtleCommands;

import java.util.Stack;

import backend.Turtle;
import backend.commands.Command;

/**
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