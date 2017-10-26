package frontend;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;

public abstract class Scroll extends ScrollPane{
	
	private static final int LABEL_START = 5;
	private static final String NEW_LINE = "\n";
	
	private ArrayList<Text> allHistory=new ArrayList<Text>();
	private String scrollLabel;
	private Group root;
	
	
	public Scroll(String label,int x,int y,int width,int height) {
		super(new Text(label));
		root=new Group();
		scrollLabel = label;
		allHistory.add(new Text(label));
		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setContent(root);
		formatHistoryEntry(0);
			
		
		
		
	}

	public void formatHistoryEntry(int number) {
		Text curr=allHistory.get(number);
		curr.wrappingWidthProperty().bind(this.widthProperty());
		curr.setTranslateX(LABEL_START);
		curr.setTranslateY(number*20);
		root.getChildren().add(curr);
	}
	
	protected String formatCommand(String command) {
		return command + NEW_LINE;
	}
	
	protected void addToScrollPane(String command) {
		Text curr=new Text(command);
		allHistory.add(curr);
		formatHistoryEntry(allHistory.size()-1);
	}
	
	
	
	protected String getScrollLabel() {
		return scrollLabel;
	}
}
