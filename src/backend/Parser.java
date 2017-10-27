package backend;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Parser {
	private UserVariables userVariables = new UserVariables();
	//public UserCommands userCommands = new UserCommands(); // for now static 
	Turtle currentTurtle;
	private double val = 1;
	private String commandsList;
	private Map<String, String> langMap;
	private Stacks instructionStacks;
	private String language;
	
	public Parser(Turtle current, String language) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		currentTurtle = current;
		LangMaps maps = new LangMaps(language); // TODO: instantiate in driver later. JUST FOR TESTING
		langMap = maps.getMaps(language.toUpperCase());
		this.language = language;
	}
	
	// TODO: throw exceptions properly w try/catch
	public void parseInstruction(String inst) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		System.out.println("NEW PASSED INST: " + inst);
		Stacks instructionStacks = new Stacks();
		instructionStacks.setLanguage(language);
		inst = inst.replace("\n", ", ");
		String[] instructionArray = inst.trim().split("\\s+");
		for (int i = instructionArray.length - 1; i > -1; i--) {
			if (UserVariables.contains(instructionArray[i])) {
				instructionStacks.push(this.getVarVal(instructionArray[i]));
			}
			else if (instructionArray[i].matches("\\]")) { // identified beginning of list (back of list)
				if (commandsList != null) { // we already have one set of commands
					i--;
					List<String> tempCommands = new ArrayList<String>();
					while (! instructionArray[i].matches("\\[")) {
						tempCommands.add(instructionArray[i]);
						i--;
					}
					Collections.reverse(tempCommands); // in correct order
					commandsList = String.join(" ", tempCommands);
					System.out.println("second list (of commands or vars): " + commandsList);
					instructionStacks.instantiateSecondCommandsList(commandsList);
				} // lots of repeated code to refactor 
				else { 
					i--;
					List<String> tempCommands = new ArrayList<String>();
					while (! instructionArray[i].matches("\\[")) {
						tempCommands.add(instructionArray[i]);
						i--;
					}
					Collections.reverse(tempCommands); // in correct order
					commandsList = String.join(" ", tempCommands);
					instructionStacks.instantiateCommandsList(commandsList);
				}
			}
			else if (instructionStacks.canBeAdded(instructionArray[i])) {
				instructionStacks.push(instructionArray[i]);
			}
			else if (! langMap.containsKey(instructionArray[i].toLowerCase().trim()) && ! UserCommands.contains(instructionArray[i].toLowerCase().trim())) {
				UserCommands.setToDefine(instructionArray[i].toLowerCase());
			}
			else if (UserCommands.contains(instructionArray[i].toLowerCase().trim())) {
				instructionStacks.addToCommands(instructionArray[i].toLowerCase().trim());
				reflectAndExecute(instructionStacks, "ProcessUserInstruction"); // bad design? 
			}
			else {
				System.out.println("instruction: " + instructionArray[i]);
				reflectAndExecute(instructionStacks, instructionArray[i].toLowerCase());
			}
		}
		//Stacks.clear();
	}

	private void reflectAndExecute(Stacks instructionStacks, String instruction) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,InvocationTargetException {
		String location = instruction;
		if (langMap.containsKey(instruction)) {
			location = langMap.get(instruction);
		}
		Class<?> commandClass = Class.forName("backend.commands." + location);
		Object commandInstance = commandClass.newInstance();
		Method commandMethod = commandClass.getMethod("execute", Stacks.class, Turtle.class);
		commandMethod.invoke(commandInstance, instructionStacks, currentTurtle);
		val = instructionStacks.getReturnVal();
		if (instruction.equals("ycor")) {
			val *= -1;
		}
		System.out.println("RETURN VAL IS " + val);
	}
	
	public double getReturnVal() {
		return val;
	}
	
	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
		Parser p = new Parser(new Turtle(), "english");
		p.parseInstruction("wow TO wow [ :hi 3\n:omg 8 ] [ fd :hi\nsum :omg 70 ]"); // repeat 3 [ fd 54\nsum 2 4 ], DOTIMES [ :var 3 ] [ fd :var\nsum :var 4 ], 
		//FOR [ :var 3 5 ] [ fd :var\nsum :var 4 ], IF 0 [ fd 54\nsum 2 4 ]
		// IFELSE 0 [ fd 54\nsum 2 4 ] [ fd 700\nsum 70 70 ], 
		//wow TO wow [ :hi 3\n:omg 8 ] [ fd 3\nsum 70 70 ]
		p.getReturnVal(); // if not zero, run commands.
	}
	
	public String getVarVal(String var) {
		return Double.toString(UserVariables.getVarVal(var));
	}
	
	public void updateUserVars(String key, Double val) {
		UserVariables.put(key, val);
	}
	
	public String getLanguage() {
		return language;
	}
}
