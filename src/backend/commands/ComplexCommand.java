package backend.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

public abstract class ComplexCommand implements Command {
	protected String[] getVars(Stacks instructionStacks, Turtle currentTurtle) {
		List<String> var = instructionStacks.getSecondCommandsList();
		String[] varSplit = var.get(0).split(" ");
		return varSplit;
	}
	
	protected double copiedCode(Stacks instructionStacks, TurtleTree currentTurtle, String specificCommand, int start, int limit, String varName) throws IllegalAccessException,
		Parser tempParser = new Parser(currentTurtle);
		tempParser.parseInstruction(currentTurtle, "Set " + varName + " " + varSplit[1]);
		Double parameter = Double.parseDouble(tempParser.getVarVal(varName));
		Double start;
		Double limit;
		if (specificCommand.equals("For")) {
			Double possibleParameter = Double.parseDouble(varSplit[2]);
			start = parameter;
			limit = possibleParameter;
		}
		else {
			start = 1.0;
			limit = parameter;
		}
		for (double i = start; i < (limit+1); i++) {
			tempParser.updateUserVars(varName, i);
			for (String instruction : instructionStacks.getCommandsList()) {
				tempParser.parseInstruction(currentTurtle, instruction);
			}
		}
		double toReturn = tempParser.getReturnVal();
		return toReturn;
	}
}
