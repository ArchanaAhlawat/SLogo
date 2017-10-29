package controller;

import java.util.List;

import backend.Turtle;
import frontend.DisplayTurtle;

public interface ControllerAPI {
	
	public double setCommand(String command);
	
	public double getReturnValue();
	
	public double getXCor();
	
	public double getYCor();
	
	public double getTheta();
	
	public double getTurtleVis();
	
	public void setParserLanguage(String language);
	
	public List<Double> getLinestoDraw();
	
	public void setActiveTurtles(List<Turtle> activeTurtles);
	
}
