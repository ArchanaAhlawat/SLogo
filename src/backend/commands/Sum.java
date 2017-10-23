package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;

public class Sum implements Command {
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double sum = instructionStacks.popDouble() + instructionStacks.popDouble();
		instructionStacks.addDouble(sum);
	}
}