package backend.commands;

import java.util.Stack;

import backend.Turtle;

public class Forward implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> Vars, Turtle currentTurtle) {
		currentTurtle.move(Vars.peek());
		return Vars; // new Stack
	}
}