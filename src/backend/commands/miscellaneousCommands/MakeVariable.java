package backend.commands.miscellaneousCommands;

import backend.Stacks;
import backend.TurtleTree;
import backend.UserVariables;
import backend.commands.GeneralCommands;

public class MakeVariable extends GeneralCommands {

	public MakeVariable(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		String variable = instructionStacks.peekVariable(); // what does changing pop to peek change? 
		instructionStacks.putUserVar(variable, instructionStacks.peekDouble());
	}

}
