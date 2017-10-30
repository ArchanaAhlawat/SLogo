package backend.commands.multipleTurtleCommands;

import java.util.List;

import backend.Stacks;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public class Ask extends GeneralCommands {

	public Ask(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		List<String> commands = instructionStacks.getCommandsList(); // commands
		List<String> turtleIDs = instructionStacks.getSecondCommandsList(); // turtle IDs
		
	}

}
