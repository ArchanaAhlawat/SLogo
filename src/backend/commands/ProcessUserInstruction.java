package backend.commands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.UserCommands;
import backend.api.Command;

public class ProcessUserInstruction implements Command {

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String key = instructionStacks.getCommand();
		String command = UserCommands.getCommand(key);
		System.out.println(command);
		String[] vars = command.substring(1).split("\\]");
		System.out.println(vars[0]);
		Parser tempParser = new Parser(currentTurtle, instructionStacks.getLanguage());
		for (String varAssignment : vars[0].split(", ")) {
			try {
				tempParser.parseInstruction("Set " + varAssignment.trim());
			} catch (InvocationTargetException | NoSuchMethodException | InstantiationException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String instruction = vars[1].trim().substring(1);
		String toPass = "REPEAT 1 [ " + instruction + " ]";
		try {
			tempParser.parseInstruction(toPass);
		} catch (InvocationTargetException | NoSuchMethodException | InstantiationException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		instructionStacks.addDouble(tempParser.getReturnVal());
	}

}
