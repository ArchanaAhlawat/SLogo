package backend;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Parser {
	//UserVariables userVariables = new UserVariables();
	Turtle currentTurtle;
	private double val;
	private String commandsList;
	private Map<String, String> langMap;
	
	public Parser(Turtle current) {
		currentTurtle = current;
		LangMaps maps = new LangMaps(); // TODO: instantiate in driver later. JUST FOR TESTING
		langMap = maps.getMaps(Locale.ENGLISH.getCountry());
	}
	
	// TODO: throw exceptions properly w try/catch
	public void parseInstruction(String inst) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		Stacks instructionStacks = new Stacks();
		inst = inst.replace("\n", ", ");
		String[] instructionArray = inst.split(" ");
		for (int i = instructionArray.length - 1; i > -1; i--) {
			if (UserVariables.contains(instructionArray[i])) {
				System.out.println("assigned var: " + instructionArray[i]);
				instructionStacks.push(Double.toString(UserVariables.getVarVal(instructionArray[i])));
			}
		
			else if (instructionArray[i].matches("\\]")) { // identified beginning of list (back of list)
				System.out.println("beginning of list : " + instructionArray[i]);
				i--; // I think the list will be \n[\ncommand1\ncommand2\ncommand3\n]\n (cont)
				List<String> tempCommands = new ArrayList<String>();
				while (! instructionArray[i].matches("\\[")) {
					tempCommands.add(instructionArray[i]);
					i--;
				}
				Collections.reverse(tempCommands); // in correct order
				commandsList = String.join(" ", tempCommands);
				System.out.println("list: " + commandsList);
				instructionStacks.instantiateCommandsList(commandsList);
			}
			else if (instructionArray[i].matches("\\[")) continue;
			
			else if (instructionStacks.canBeAdded(instructionArray[i])) {
				instructionStacks.push(instructionArray[i]); // types are abstracted to Stacks class - good design
			}
			else {
				System.out.println("ok this should happen: " + instructionArray[i]);
				reflectAndExecute(instructionStacks, instructionArray, i);
			}
		}
	}

	private void reflectAndExecute(Stacks instructionStacks, String[] instructionArray, int i) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,InvocationTargetException {
		Class<?> commandClass = Class.forName("backend.commands." + langMap.get(instructionArray[i].toLowerCase()));
		Object commandInstance = commandClass.newInstance();
		Method commandMethod = commandClass.getDeclaredMethod("execute", Stacks.class, Turtle.class);
		commandMethod.invoke(commandInstance, instructionStacks, currentTurtle);
		val = instructionStacks.getReturnVal();
		System.out.println("RETURN VAL IS " + val);
	}
	
	public double getReturnVal() {
		return val;
	}
	
	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		Parser p = new Parser(new Turtle());
		p.parseInstruction("repeat 3 [ fd 54\nsum 2 4 ]");
		p.getReturnVal();
	}
}
