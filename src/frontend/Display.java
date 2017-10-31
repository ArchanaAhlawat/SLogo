package frontend;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Display extends Pane{
	

	
	public Display(DisplayTurtle displayTurtle,double X,double Y,double width,double height) {
		super(displayTurtle);
		this.getChildren().add(displayTurtle.getPath());
		this.setTranslateX(X);
		this.setTranslateY(Y);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
	}
	
	protected void changeColor(Color fill) {
		BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        this.setBackground(background);
	}

}
