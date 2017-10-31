package backend.commands.miscellaneousCommands;

import java.util.Arrays;
import java.util.List;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.UserCommands;
import backend.commands.GeneralCommands;

/**
 * @author archana
 *
 */
public class MakeUserInstruction extends GeneralCommands {

	public MakeUserInstruction(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		List<String> vars = instructionStacks.getSecondCommandsList();
		List<String> commands = instructionStacks.getCommandsList();
		String newCommand = Arrays.toString(vars.toArray()) + " " + Arrays.toString(commands.toArray());
		instructionStacks.putUserCommands(instructionStacks.getTBDefined(), newCommand);
		instructionStacks.addDouble(1);
		// TODO return val is 0 if user defined command can't be defined.
	}


}
