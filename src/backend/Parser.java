package backend;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

public class Parser {
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
			if (instructionStacks.canBeAdded(instructionArray[i])) {
				instructionStacks.push(instructionArray[i]);
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
		p.parseInstruction("Forward Sum 50 5");
		p.getReturnVal();
	}
}
