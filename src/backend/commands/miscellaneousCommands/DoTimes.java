package backend.commands.miscellaneousCommands;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;
import backend.commands.GeneralCommands;

public class DoTimes extends GeneralCommands {

	public DoTimes(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		List<String> var = instructionStacks.getSecondCommandsList();
		Parser tempParser;
		try {
			tempParser = new Parser(instructionStacks.getLanguage());
			String varName = var.get(0).split(" ")[0];
			tempParser.parseInstruction(currentTurtle, "Set " + varName + " " + var.get(0).split(" ")[1]); // want to get variable name 
			Double limit = Double.parseDouble(tempParser.getVarVal(varName));
			for (double i = 1; i < (limit+1); i++) {
				tempParser.updateUserVars(varName, i);
				System.out.println("updated var: " + tempParser.getVarVal(":var"));
				for (String instruction : instructionStacks.getCommandsList()) {
					tempParser.parseInstruction(currentTurtle, instruction);
				}
			}
			double toReturn = tempParser.getReturnVal();
			instructionStacks.addDouble(toReturn);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | InstantiationException | ClassNotFoundException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

