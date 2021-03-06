package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import backend.Driver;
import backend.Updates;
import frontend.DisplayTurtleManager;
import backend.Turtle;

public class Controller implements ControllerAPI {
	
	private Driver BEdriver;
	private DisplayTurtleManager displayTurtleManager;
	

	public Controller(DisplayTurtleManager FEdisplayTurtleManager) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		BEdriver = new Driver();
		displayTurtleManager = FEdisplayTurtleManager;
	
	}
	
	@Override
	public void createTurtleTree() {
		BEdriver.setTurtleTree(); // create new turtle tree
	}

	@Override
	public double setCommand(String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		double commandValue=BEdriver.setCommand(command);
		return commandValue;
		
	}

	public void reactivate(double id) {
		BEdriver.reactivate(id);
	}
	
	public void deactivate(double id) {
		BEdriver.deactivate(id);
	}
	
	public List<Turtle> getTurtles() {
		return BEdriver.getTurtles();
	}

	@Override
	public double getXCor() {
		return getUpdates().getXCor();
	}


	@Override
	public double getYCor() {
		// TODO Auto-generated method stub
		return getUpdates().getYCor();
	}


	@Override
	public double getTheta() {
		// TODO Auto-generated method stub
		return getUpdates().getTheta();
	}
	
	public Updates getUpdates() {
		return BEdriver.getTurtleUpdates();
	}


	@Override
	public double getTurtleVis() {
		// TODO Auto-generated method stub
		return getUpdates().getTurtleVis();
	}


	@Override
	public void setParserLanguage(String language) {
		BEdriver.setLanguage(language);
	}

	@Override
	public List<Double> getLinestoDraw() {
		return BEdriver.getLines();
	}

	@Override
	public List<String> getUserDefinedVars() {
		return BEdriver.getUserDefinedVars();
	}
	
	@Override
	public List<String> getUserDefinedCommands() {
		return BEdriver.getUserDefinedCommands();
	}
}
