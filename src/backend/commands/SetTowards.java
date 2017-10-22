package backend.commands;

import java.util.Stack;

import backend.Turtle;

/**
 * @author kelly
 *
 */
public class SetTowards implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double currentAngle = currentTurtle.getAbsoluteOrientation("theta");
		double newAngle = currentTurtle.angle(vars.pop(), vars.pop());
		currentTurtle.setHeading(newAngle);
		vars.push(newAngle - currentAngle);
		return vars;
	}
}