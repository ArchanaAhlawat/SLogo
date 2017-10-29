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
 * Parses the instructions passed from the frontend to the backend
 * Uses reflection to call the actual command/operation needed to be executed
 * Does this by keeping track of the instructions, parameters and variables
 * 
 * @author archana
 * @author kelly
 *
 */
public class Parser {
	//UserVariables userVariables = new UserVariables();
	Turtle currentTurtle;
	private double val = 1;
	private String commandsList;
	private Map<String, String> langMap;

	private static final Map<String, String[]> packageMap;
	static {
		Map<String, String[]> myMap = new HashMap<>();
		myMap.put("backend.commands.booleanOperations.", new String[] {"And", "Equal", "GreaterThan", "LessThan", "Not", "NotEqual", "Or"});
		myMap.put("backend.commands.dispayCommands.", new String[] {"SetBackground", "SetPenColor", "SetPenSize", "SetShape", "SetPalette", "GetPenColor", "GetShape", "Stamp", "ClearStamps"});
		myMap.put("backend.commands.mathOperations.", new String[] {"ArcTangent", "Cosine", "Difference", "Minus", "NaturalLog", "Pi", "Power", "Product", "Quotient", "Random", "Remainder", "Sine", "Sum", "Tangent"});
		myMap.put("backend.commands.miscellaneousCommands.", new String[] {"MakeVariable", "Repeat", "DoTimes", "For", "If", "IfElse", "MakeUserInstruction"});
		myMap.put("backend.commands.multipleTurtleCommands.", new String[] {"ID", "Turtles", "Tell", "Ask", "AskWith"});
		myMap.put("backend.commands.turtleCommands.", new String[] {"Forward", "Backward", "Left", "Right", "SetHeading", "SetTowards", "SetPosition", "PenDown", "PenUp", "ShowTurtle", "HideTurtle", "Home", "ClearScreen"});
		myMap.put("backend.commands.turtleQueries.", new String[] {"XCoordinate", "YCoordinate", "Heading", "IsPenDown", "IsShowing"});
		packageMap = Collections.unmodifiableMap(myMap);
	}


	public Parser(Turtle current, String language) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		currentTurtle = current;
		LangMaps maps = new LangMaps(language); // TODO: instantiate in driver later. JUST FOR TESTING
		langMap = maps.getMaps(language.toUpperCase());
	}

	// TODO: throw exceptions properly w try/catch
	public void parseInstruction(String inst) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		System.out.println("NEW PASSED INST: " + inst);
		Stacks instructionStacks = new Stacks();
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
			else if (instructionArray[i].matches("\\[")) continue;

			else if (instructionStacks.canBeAdded(instructionArray[i])) {
				instructionStacks.push(instructionArray[i]); // types are abstracted to Stacks class - good design
			}
			else {
				System.out.println("instruction: " + instructionArray[i]);
				reflectAndExecute(instructionStacks, instructionArray, i);
			}
		}
		//Stacks.clear();
	}

	private void reflectAndExecute(Stacks instructionStacks, String[] instructionArray, int i) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,InvocationTargetException {
		//Class<?> commandClass = Class.forName("backend.commands.booleanOperations." + langMap.get(instructionArray[i].toLowerCase()));
		//Class<?> commandClass = Class.forName("backend.commands.mathOperations." + langMap.get(instructionArray[i].toLowerCase()));
		//Class<?> commandClass = Class.forName("backend.commands.turtleCommands." + langMap.get(instructionArray[i].toLowerCase()));
		//Class<?> commandClass = Class.forName("backend.commands.turtleQueries." + langMap.get(instructionArray[i].toLowerCase()));
		//Class<?> commandClass = Class.forName("backend.commands.turtleCommands.oneParam." + langMap.get(instructionArray[i].toLowerCase()));
		String instruction = langMap.get(instructionArray[i].toLowerCase());
		Class<?> commandClass = Class.forName(getPackageName(instruction) + instruction);
		Constructor<?> cons = commandClass.getConstructor(Stacks.class, Turtle.class);
		Object commandInstance = cons.newInstance(instructionStacks, currentTurtle);
		Method commandMethod = commandClass.getMethod("execute", Stacks.class, Turtle.class);
		commandMethod.invoke(commandInstance, instructionStacks, currentTurtle);
		val = instructionStacks.getReturnVal();
		if (instructionArray[i].toLowerCase().equals("ycor")) {
			val *= -1;
		}
		System.out.println("RETURN VAL IS " + val);
	}

	private String getPackageName(String instruction) {
		Set<String> myKeys = packageMap.keySet();
		for (String key : myKeys) {
			if (Arrays.asList(packageMap.get(key)).contains(instruction)) {
				return key;
			}
		}
		return null;
	}

	public double getReturnVal() {
		return val;
	}

//	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
//		Parser p = new Parser(new Turtle(), "chinese");
//		p.parseInstruction("qianjin 40"); // repeat 3 [ fd 54\nsum 2 4 ], DOTIMES [ :var 3 ] [ fd :var\nsum :var 4 ], 
//		//FOR [ :var 3 5 ] [ fd :var\nsum :var 4 ], IF 0 [ fd 54\nsum 2 4 ]
//		// IFELSE 0 [ fd 54\nsum 2 4 ] [ fd 700\nsum 70 70 ], 
//		p.getReturnVal(); // if not zero, run commands.
//	}

	public String getVarVal(String var) {
		return Double.toString(UserVariables.getVarVal(var));
	}

	public void updateUserVars(String key, Double val) {
		UserVariables.put(key, val);
	}
}
