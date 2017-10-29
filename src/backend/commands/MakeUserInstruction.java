package backend.commands;

import java.util.Arrays;
import java.util.List;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.UserCommands;
import backend.api.Command;

public class MakeUserInstruction implements Command{

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		List<String> vars = instructionStacks.getSecondCommandsList();
		List<String> commands = instructionStacks.getCommandsList();
		String newCommand = Arrays.toString(vars.toArray()) + " " + Arrays.toString(commands.toArray());
		UserCommands.put(UserCommands.getTBDefined(), newCommand);
		instructionStacks.addDouble(1);
		// TODO return val is 0 if user defined command can't be defined.
	}

}
