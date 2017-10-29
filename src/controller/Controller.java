package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import backend.Driver;
import backend.Updates;
import frontend.Turtle;

public class Controller implements ControllerAPI {
	
	private Driver BEdriver = new Driver();
	

	public Controller() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		BEdriver = new Driver();
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

	@Override
	public double getReturnValue() {
		// TODO Auto-generated method stub
		//return BackEndDriver.getRetVal();
		return 0;
	}


	@Override
	public double getXCor() {
		// TODO Auto-generated method stub
		System.out.println("controller XCor: " + getUpdates().getXCor());
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
		// TODO Auto-generated method stub
		return BEdriver.getLines();
	}
}
