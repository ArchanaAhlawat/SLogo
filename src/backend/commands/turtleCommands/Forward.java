package backend.commands.turtleCommands;

import java.util.Stack;

import backend.Turtle;
import backend.commands.Command;

public class Forward implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> Vars, Turtle currentTurtle) {
		currentTurtle.move(Vars.peek());
		return Vars; // new Stack
	}
}