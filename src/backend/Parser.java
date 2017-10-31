package backend;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * parses the instructions from the frontend
 * uses reflection to execute the instructions for the turtles
 * @author archana
 *
 */
public class Parser {
	private UserVariables userVariables = new UserVariables();
	public UserCommands userCommands = new UserCommands();
	TurtleTree currentTurtle;
	private double val = 1;
	private Map<String, String> langMap;
	private String language;
	private String lastTell = "";

	/**
	 * static map, would be better as a xml to read in
	 * @author kelly
	 */
	private static final Map<String, String[]> packageMap;
	static { //https://stackoverflow.com/questions/507602/how-can-i-initialise-a-static-map
		Map<String, String[]> myMap = new HashMap<>();
		myMap.put("backend.commands.booleanOperations.", new String[] {"And", "Equal", "GreaterThan", "LessThan", "Not", "NotEqual", "Or"});
		myMap.put("backend.commands.dispayCommands.", new String[] {"SetBackground", "SetPenColor", "SetPenSize", "SetShape", "SetPalette", "GetPenColor", "GetShape", "Stamp", "ClearStamps"});
		myMap.put("backend.commands.mathOperations.", new String[] {"ArcTangent", "Cosine", "Difference", "Minus", "NaturalLog", "Pi", "Power", "Product", "Quotient", "Random", "Remainder", "Sine", "Sum", "Tangent"});
		myMap.put("backend.commands.miscellaneousCommands.", new String[] {"MakeVariable", "Repeat", "DoTimes", "For", "If", "IfElse", "MakeUserInstruction"});
		myMap.put("backend.commands.multipleTurtleCommands.", new String[] {"ID", "Turtles", "Tell", "Ask", "AskWith"});
		myMap.put("backend.commands.turtleCommands.", new String[] {"Forward", "Backward", "Left", "Right", "SetHeading", "SetTowards", "SetPosition", "PenDown", "PenUp", "ShowTurtle", "HideTurtle", "Home", "ClearScreen"});
		myMap.put("backend.commands.turtleQueries.", new String[] {"XCoordinate", "YCoordinate", "Heading", "IsPenDown", "IsShowing"});
		myMap.put("backend.commands.", new String[] {"ID", "ProcessUserInstruction", "Tell"});
		packageMap = Collections.unmodifiableMap(myMap);
	}


	public Parser(String language) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		LangMaps maps = new LangMaps(language); // TODO: instantiate in driver later. JUST FOR TESTING
		langMap = maps.getMaps(language.toUpperCase());
		this.language = language;
	}

	public void parseInstruction(TurtleTree current, String inst) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		this.parseInstructionPrivate(current, inst);
		double actualReturnVal = this.getReturnVal();
		this.parseInstructionPrivate(current, lastTell);
		this.setReturnVal(actualReturnVal);
	}	
	
	private void setTell(String tell) {
		lastTell = tell;
	}
		// TODO: throw exceptions properly w try/catch
	private void parseInstructionPrivate(TurtleTree current, String inst) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		String commandsList = "";
		currentTurtle = current;
		System.out.println("NEW PASSED INST: " + inst);
		Stacks instructionStacks = new Stacks(language, userCommands, userVariables);
		instructionStacks.setLanguage(language);
		if (inst.toLowerCase().contains("tell")) {
			this.setTell(inst);
		}
		inst = inst.replace("\n", ", ");
		String[] instructionArray = inst.trim().split("\\s+");
		for (int i = instructionArray.length - 1; i > -1; i--) {
			if (userVariables.contains(instructionArray[i])) {
				instructionStacks.push(this.getVarVal(instructionArray[i]));
			}
			else if (instructionArray[i].matches("\\]")) { // identified beginning of list (back of list)
				System.out.println("found beginning of list");
				if (commandsList != "") { // we already have one set of commands
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
					System.out.println("FIRST list of commands");
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
			else if (! langMap.containsKey(instructionArray[i].toLowerCase().trim()) && ! userCommands.contains(instructionArray[i].toLowerCase().trim())) {
				userCommands.setToDefine(instructionArray[i].toLowerCase());
			}
			else if (userCommands.contains(instructionArray[i].toLowerCase().trim())) {
				instructionStacks.addToCommands(instructionArray[i].toLowerCase().trim());
				reflectAndExecute(instructionStacks, "ProcessUserInstruction"); // bad design? 
			}
			else {
				System.out.println("instruction: " + instructionArray[i]);
				reflectAndExecute(instructionStacks, instructionArray[i].toLowerCase());
			}
		}
	}

	/**
	 * @author archana
	 * @author kelly
	 * @param instructionStacks
	 * @param instruction
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	private void reflectAndExecute(Stacks instructionStacks, String instruction) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,InvocationTargetException {
		String location = instruction;
		if (langMap.containsKey(instruction)) {
			location = langMap.get(instruction);
		}
		Class<?> commandClass = Class.forName(getPackageName(location) + location);
		Constructor<?> cons = commandClass.getConstructor(Stacks.class, TurtleTree.class);
		Object commandInstance = cons.newInstance(instructionStacks, currentTurtle);
		Method commandMethod = commandClass.getMethod("execute", Stacks.class, TurtleTree.class);
		commandMethod.invoke(commandInstance, instructionStacks, currentTurtle);
		val = instructionStacks.getReturnVal();
		if (instruction.equals("ycor")) {
			val *= -1;
		}
		System.out.println("RETURN VAL IS " + val);
	}

	private String getPackageName(String instruction) {
		Set<String> myKeys = packageMap.keySet();
		for (String key : myKeys) {
			if (Arrays.asList(packageMap.get(key)).contains(instruction.trim())) {
				return key;
			}
		}
		return null;
	}

	public double getReturnVal() {
		return val;
	}
	
	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
		Parser p = new Parser("english");
		TurtleTree turtles = new TurtleManager();
		//turtles.addActiveTurtle();
		//turtles.addActiveTurtle();
		p.parseInstruction(turtles, "tell [ 2 ]");
		p.parseInstruction(turtles, "left 270");
		p.parseInstruction(turtles, "forward 50");
		//p.parseInstruction(turtles, "ask [ 1 2 ] [ fd 60 ]");
		p.parseInstruction(turtles, "AskWith [ greater? xcor 40 ] [ fd 40 ]");
		//p.parseInstruction(turtles, "Ask [ 1 ] [ fd 40 ]"); 
		//p.parseInstruction(turtles, "fd 40");
		// repeat 3 [ fd 54\nsum 2 4 ], DOTIMES [ :var 3 ] [ fd :var\nsum :var 4 ],
		//FOR [ :var 3 5 ] [ fd :var\nsum :var 4 ], IF 0 [ fd 54\nsum 2 4 ]
		// IFELSE 0 [ fd 54\nsum 2 4 ] [ fd 700\nsum 70 70 ], 
		//wow TO wow [ :hi 3\n:omg 8 ] [ fd 3\nsum 70 70 ]
		p.getReturnVal(); // if not zero, run commands.
	}
	
	public String getVarVal(String var) {
		return Double.toString(userVariables.getVarVal(var));
	}

	public void updateUserVars(String key, Double val) {
		userVariables.put(key, val);
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setReturnVal(double returnVal) {
		val = returnVal;
	}
	public List<String> getUserDefinedVars() { // this process needs to be updated! 
		return userVariables.getUserDefinedVars();
	}
	
	public List<String> getUserDefinedCommands() { // this process needs to be updated! 
		return userCommands.getUserDefinedCommands();
	}
}