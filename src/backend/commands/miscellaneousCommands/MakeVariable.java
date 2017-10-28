package backend.commands.miscellaneousCommands;

import backend.Stacks;
import backend.Turtle;
import backend.UserVariables;
import backend.commands.GeneralCommands;

public class MakeVariable extends GeneralCommands {

	public MakeVariable(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		String variable = instructionStacks.peekVariable(); // what does changing pop to peek change? 
		UserVariables.put(variable, instructionStacks.peekDouble());
	}

}
