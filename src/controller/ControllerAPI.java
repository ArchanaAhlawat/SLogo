package controller;

import java.util.List;

import frontend.Turtle;

public interface ControllerAPI {
	
	public double setCommand(String command);
	
	public double getReturnValue();
	
	public double getXCor();
	
	public double getYCor();
	
	public double getTheta();
	
	public double getTurtleVis();
	
	public void setParserLanguage(String language);
	
	public List<Double> getLinestoDraw();

	void createTurtleTree();
	
}
