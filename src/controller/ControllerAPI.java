package controller;

import java.util.List;

import frontend.Turtle;

public interface ControllerAPI {
	
	public double setCommand(String command);
	
	public Turtle getTurtle(List<Object> newTurtle);
	
	public double getReturnValue();
	
	public double getXCor();
	
	public double getYCor();
	
	public double getTheta();
	
	public double getTurtleVis();
	
}
