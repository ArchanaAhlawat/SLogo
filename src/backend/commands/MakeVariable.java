package backend.commands;

import backend.Stacks;
import backend.Turtle;
import backend.UserVariables;

public class MakeVariable implements Command {

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		String variable = instructionStacks.popVariable();
		UserVariables.put(variable, instructionStacks.peekDouble());
	}

}
