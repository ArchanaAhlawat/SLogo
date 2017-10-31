package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import backend.Driver;
import backend.Updates;
import frontend.DisplayTurtle;
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
	public double setCommand(String command) {
		
		try {
			double commandValue=BEdriver.setCommand(command);
			return commandValue;
		} catch (IllegalAccessException
				| IllegalArgumentException
				| InvocationTargetException
				| NoSuchMethodException
				| SecurityException
				| InstantiationException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
		
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
	
}
