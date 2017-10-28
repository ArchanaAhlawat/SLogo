package backend.commands.miscellaneousCommands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

public class If implements Command{

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		if (instructionStacks.popDouble() != 0) {
			Parser tempParser = new Parser(instructionStacks.getLanguage());
			for (String instruction : instructionStacks.getCommandsList()) {
				try {
					tempParser.parseInstruction(currentTurtle, instruction);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException | InstantiationException
						| ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			double toReturn = tempParser.getReturnVal();
			instructionStacks.addDouble(toReturn);
		}
		else {
			instructionStacks.addDouble(0.0);
		}
	}

}

