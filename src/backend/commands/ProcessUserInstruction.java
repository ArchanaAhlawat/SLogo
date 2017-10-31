package backend.commands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.UserCommands;
import backend.api.Command;

/**
 * @author archana
 *
 */
public class ProcessUserInstruction extends GeneralCommands {

	public ProcessUserInstruction(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		String key = instructionStacks.getCommand();
		String command = instructionStacks.getUserCommands(key);
		System.out.println(command);
		String[] vars = command.substring(1).split("\\]");
		System.out.println(vars[0]);
		Parser tempParser;
		try {
			tempParser = new Parser(instructionStacks.getLanguage());
			for (String varAssignment : vars[0].split(", ")) {
				try {
					tempParser.parseInstruction(currentTurtle, "Set " + varAssignment.trim());
				} catch (InvocationTargetException | NoSuchMethodException | InstantiationException
						| ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String instruction = vars[1].trim().substring(1);
			String toPass = "REPEAT 1 [ " + instruction + " ]";
			tempParser.parseInstruction(currentTurtle, toPass);
			instructionStacks.addDouble(tempParser.getReturnVal());
		} catch (InvocationTargetException | NoSuchMethodException | InstantiationException
				| ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
