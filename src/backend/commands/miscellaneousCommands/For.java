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
public class For extends GeneralCommands {

	public For(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		List<String> var = instructionStacks.getSecondCommandsList();
		Parser tempParser;
		try {
			tempParser = new Parser(currentTurtle, "ENGLISH");
			System.out.println("hey: " + var.get(0)); // :var 3 5
			String varName = var.get(0).split(" ")[0];
			tempParser.parseInstruction("Set " + varName + " " + var.get(0).split(" ")[1]); // want to get variable name 
			Double start = Double.parseDouble(tempParser.getVarVal(varName));
			Double limit = Double.parseDouble(var.get(0).split(" ")[2]);
			for (double i = start; i < (limit+1); i++) {
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
		}	
	}
}
