package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import backend.Turtle;
import frontend.DisplayTurtle;

public interface ControllerAPI {
	
	public double setCommand(String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException;
	
	public double getXCor();
	
	public double getYCor();
	
	public double getTheta();
	
	public double getTurtleVis();
	
	public void setParserLanguage(String language);
	
	public List<Double> getLinestoDraw();

	void createTurtleTree();
	
	public List<String> getUserDefinedVars();

	List<String> getUserDefinedCommands();
}
