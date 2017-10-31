package controller;

import java.util.List;

import backend.Turtle;
import frontend.DisplayTurtle;

public interface ControllerAPI {
	
	public double setCommand(String command);
	
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
