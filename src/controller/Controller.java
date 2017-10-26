package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import backend.Driver;
import frontend.Turtle;

public class Controller implements ControllerAPI {
	
	private Driver BEdriver = new Driver();

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
	public Turtle getTurtle(List<Object> newTurtle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getReturnValue() {
		// TODO Auto-generated method stub
		//return BackEndDriver.getRetVal();
		return 0;
	}
}
