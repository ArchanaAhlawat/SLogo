package backend.commands.miscellaneousCommands;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.commands.GeneralCommands;

/**
 * @author archana
 *
 */
public class DoTimes extends GeneralCommands{

	public DoTimes(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		List<String> var = instructionStacks.getSecondCommandsList();
		Parser tempParser;
		try {
			tempParser = new Parser(currentTurtle, "ENGLISH");
			String varName = var.get(0).split(" ")[0];
			tempParser.parseInstruction("Set " + varName + " " + var.get(0).split(" ")[1]); // want to get variable name 
			Double limit = Double.parseDouble(tempParser.getVarVal(varName));
			for (double i = 1; i < (limit+1); i++) {
				tempParser.updateUserVars(varName, i);
				System.out.println("updated var: " + tempParser.getVarVal(":var"));
				for (String instruction : instructionStacks.getCommandsList()) {
					tempParser.parseInstruction(instruction);
				}
			}
			double toReturn = tempParser.getReturnVal();
			instructionStacks.addDouble(toReturn);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
