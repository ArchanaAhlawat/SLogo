package frontend;

import javafx.scene.layout.Pane;

import javafx.scene.control.ScrollPane;

public class LayoutPane {
	
	public static final String PANE = "javafx.scene.layout.Pane";
	public static final String SCROLLPANE = "javafx.scene.control.ScrollPane";
	
	private Class specificPane;
	
	public LayoutPane(String paneType,double x,double y,double width,double height) {
		try {
			specificPane = Class.forName(paneType);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Pane tempPane = new Pane();
			specificPane = tempPane.getClass();
		}
		
	}
	
	protected Class getSpecificPane() {
		return specificPane;
	}
	
	public static void main(String[] args) {
		LayoutPane layoutPane = new LayoutPane(PANE,0,0,0,0);
		Class specificPane = layoutPane.getSpecificPane();
	}

}
