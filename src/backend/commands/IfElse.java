package backend.commands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

public class IfElse implements Command{

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Parser tempParser = new Parser(instructionStacks.getLanguage());
		if (instructionStacks.popDouble() != 0) {
			for (String instruction : instructionStacks.getSecondCommandsList()) {
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
	}

}
