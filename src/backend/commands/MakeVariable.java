package backend.commands;

import backend.Stacks;
import backend.TurtleTree;
import backend.UserVariables;
import backend.api.Command;

public class MakeVariable implements Command {

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		String variable = instructionStacks.peekVariable(); // what does changing pop to peek change? 
		UserVariables.put(variable, instructionStacks.peekDouble());
	}

}
