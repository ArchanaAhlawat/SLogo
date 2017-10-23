package backend;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

public class Parser {
	//UserVariables userVariables = new UserVariables();
	Turtle currentTurtle;
	private double val;
	
	public Parser(Turtle current) {
		currentTurtle = current;
	}
	
	// TODO: throw exceptions properly w try/catch
	public void parseInstruction(String inst) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		LangMaps maps = new LangMaps(); // TODO: instantiate in driver later. JUST FOR TESTING
		Map<String, String> langMap = maps.getMaps(Locale.ENGLISH.getCountry());
		
		Stacks instructionStacks = new Stacks();
		
		//Stack<Double> instructionStack = new Stack<Double>();
		String[] instructionArray = inst.split(" ");
		for (int i = instructionArray.length - 1; i > -1; i--) {
			if (UserVariables.contains(instructionArray[i])) {
				instructionStacks.push(Double.toString(UserVariables.getVarVal(instructionArray[i])));
			}
			else if (instructionStacks.canBeAdded(instructionArray[i])) {
				instructionStacks.push(instructionArray[i]); // types are abstracted to Stacks class - good design
			}
			else {
				
				Class<?> commandClass = Class.forName("backend.commands." + langMap.get(instructionArray[i].toLowerCase()));
				Object commandInstance = commandClass.newInstance();
				Method commandMethod = commandClass.getDeclaredMethod("execute", Stacks.class, Turtle.class);
				commandMethod.invoke(commandInstance, instructionStacks, currentTurtle);
				val = instructionStacks.getReturnVal();
				System.out.println("RETURN VAL IS " + val);
			}
		}
	}
	
	public double getReturnVal() {
		return val;
	}
	
	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		Parser p = new Parser(new Turtle());
		p.parseInstruction("Forward Make :hi 50");
		p.getReturnVal();
	}
}
