package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;

public class Forward implements Command {
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		currentTurtle.move(instructionStacks.peekDouble());
	}
}