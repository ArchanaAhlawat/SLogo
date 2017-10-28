package controller;

import java.util.List;

public interface FEControllerAPI {
	
	public String getCommand();
	
	public String getParserLanguage(Number newIndex);
	
	public double getXCor();
	
	public double getYCor();
	
	public double getTheta();
	
	public double getTurtleVis();

}
