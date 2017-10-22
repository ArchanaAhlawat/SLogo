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
		Stack<Double> instructionStack = new Stack<Double>();
		String[] instructionArray = inst.split(" ");
		for (int i = instructionArray.length - 1; i > -1; i--) {
			if (isNumeric(instructionArray[i])) {
				instructionStack.push(Double.parseDouble(instructionArray[i]));
			}
			else {
				Class<?> commandClass = Class.forName("backend.commands." + langMap.get(instructionArray[i].toLowerCase()));
				Object commandInstance = commandClass.newInstance();
				Method commandMethod = commandClass.getDeclaredMethod("execute", Stack.class, Turtle.class);
				Stack<Double> copyStack = new Stack<Double>();
				copyStack.addAll(instructionStack);
				Stack<Double> newStack = (Stack<Double>) commandMethod.invoke(commandInstance, copyStack, currentTurtle);
				instructionStack = newStack; // invoke method must return new stack. TODO: maybe bad design to pass stack directly
				System.out.println(instructionStack.peek());
				val = instructionStack.peek();
				System.out.println("RETURN VAL IS " + val);
			}
		}
	}
	
	public double getReturnVal() {
		System.out.println("HELLO " + val);
		return val;
	}
	
	private boolean isNumeric(String possibleInt) {
		 return possibleInt.matches("-?\\d+(\\.\\d+)?");
	}
	
//	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//		Parser p = new Parser(new Turtle());
//		p.parseInstruction("Forward 50");
//		p.getReturnVal();
//	}
}
