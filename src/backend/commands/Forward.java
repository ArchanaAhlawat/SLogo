package backend.commands;

import java.util.Stack;

import backend.Turtle;

public class Forward implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		currentTurtle.move(vars.peek());
		return vars; // new Stack
	}
}