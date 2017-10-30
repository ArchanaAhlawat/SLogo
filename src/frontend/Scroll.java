package frontend;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;

public abstract class Scroll extends ScrollPane {
	
	private static final int LABEL_START = 5;
	private static final String NEW_LINE = "\n";
	
	protected Text curr;
	
	private ArrayList<Text> allHistory=new ArrayList<Text>();
	private String scrollLabel;
	protected Group scrollPaneRoot;
	
	protected VBox layout;
	private static final int VBOX_SPACING = 1;
	
	public Scroll(String label,int x,int y,int width,int height) {
		super(new Text(label));
		scrollPaneRoot=new Group();
		scrollLabel = label;
		allHistory.add(new Text(label));
		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setContent(scrollPaneRoot);
		layout = new VBox(VBOX_SPACING);
		
		scrollPaneRoot.getChildren().add(layout);
		formatHistoryEntry(0);
	}
	
	protected String formatCommand(String command) {
		return command + NEW_LINE;
	}
	
	protected void addToScrollPane(String command) {
		curr = new Text(command);
		allHistory.add(curr);
		formatHistoryEntry(allHistory.size()-1);
	}
	
	protected String getScrollLabel() {
		return scrollLabel;
	}
	
	protected void addToRoot(Text text) {
		layout.getChildren().add(text);
	}
	
	private void formatHistoryEntry(int number) {
		Text curr=allHistory.get(number);
		curr.wrappingWidthProperty().bind(this.widthProperty());
		addToRoot(curr);
		
	}
}
