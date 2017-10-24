package backend.commands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;

public class If implements Command{

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		if (instructionStacks.popDouble() != 0) {
			Parser tempParser = new Parser(currentTurtle);
			for (String instruction : instructionStacks.getCommandsList()) {
				try {
					tempParser.parseInstruction(instruction);
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
