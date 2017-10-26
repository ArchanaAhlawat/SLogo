package frontend;

import java.awt.image.BufferedImage;
import backend.Driver;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FrontEndDriver extends Application {
	

	private static final int BUTTONS_Y = 30;
	private static final int HBOX_SPACING = 20;
	private static final int SUBMIT_BUTTON_WIDTH = 80;
	private static final int SUBMIT_BUTTON_HEIGHT = 40;
	private static final int COMMANDWIDTH = 350;
	private static final int COMMANDHEIGHT = 40;
	private static final int TURTLEAREA_TEXTFILED_SPACE = 50;
	private static final int GRID_X1 = 50;	//this should be the left-most line coordinate of the turtle grid
	private static final int GRID_X2 = 500;	//this should be the right-most line coordinate of the turtle grid
	private static final int GRID_Y1 = 100;	//this should be the top-most line coordinate of the turtle grid
	private static final int GRID_Y2 = 500;	//this should be the bottom-most line coordinate of the turtle grid
	private static final int GRID_WIDTH = GRID_X2 - GRID_X1;
	private static final int GRID_HEIGHT = GRID_Y2 - GRID_Y1;
	private static final int HISTORY_WIDTH = 350;
	private static final int HISTORY_HEIGHT = 200;
	private static final int RETURN_HEIGHT = 70;
	private static final int RETURN_Y = 440;
	private static final int HISTORY_Y = 100;
	private static final int HISTORY_X = 600;
	private static final int UserV_Y = 320;
	private static final int UserC_Y = 530;
	private static final int UserC_HEIGHT = 150;
	private static final int UserV_HEIGHT = 100;
	
	private static final int VBOX_SPACING = 7;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	private static final int BUTTON_WIDTH = 200;
	private static final int BUTTON_HEIGHT = 40;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/buttons";
	private static final String DEFAULT_TURTLE_DIRECTORY = "src/resources/turtle.png";
	private static final int TURTLESIZE = 50;
	private static final Color DEFAULT_TURTLEAREA_COLOR = Color.HONEYDEW;

    private Display turtleArea;
	private DisplayTurtle displayTurtle;
	private TurtlePath turtlePath;
	private Stage window;
	private Group root;
	private ResourceBundle myResources;
	private TextArea command;
	private History commandHistory;
	private ReturnValue returnValue;
	private History userDefinedVariables;
	private History userDefinedCommands;
	private double commandValue;
	
	private Driver BEdriver = new Driver();
	
	public static final double ORIGIN_X = (GRID_X2 - GRID_X1 - TURTLESIZE)/2;
	public static final double ORIGIN_Y = (GRID_Y2 - GRID_Y1 - TURTLESIZE)/2;
	
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		window = primaryStage;
		HBox layout = new HBox(VBOX_SPACING);
		HBox layout2=new HBox(VBOX_SPACING);
		addLabelsForButtons(layout2);
		
		
		root = new Group();
		
		
		Scene startScene= new Scene(root, WIDTH, HEIGHT);
		addTurtleImage();
		turtleArea= new Display(displayTurtle,DEFAULT_TURTLEAREA_COLOR,GRID_X1,GRID_Y1,GRID_WIDTH,GRID_HEIGHT);
		addAllButtons(layout);
		
		turtlePath = new TurtlePath(ORIGIN_X,ORIGIN_Y);
		addCommandLine(); 
		commandHistory = new History(myResources.getString("History"),HISTORY_X,HISTORY_Y,HISTORY_WIDTH,HISTORY_HEIGHT);
		returnValue = new ReturnValue(myResources.getString("Return"),HISTORY_X, RETURN_Y,HISTORY_WIDTH,RETURN_HEIGHT);
		userDefinedVariables=new History(myResources.getString("UserV"),HISTORY_X,UserV_Y,HISTORY_WIDTH,UserV_HEIGHT);
		userDefinedCommands=new History(myResources.getString("UserC"),HISTORY_X,UserC_Y,HISTORY_WIDTH,UserC_HEIGHT);
		root.getChildren().addAll(layout,layout2,turtlePath,turtleArea,commandHistory,returnValue,userDefinedVariables,userDefinedCommands);
	
		window.setTitle("SLogo");
		window.setScene(startScene);
		window.show();
		
	}
	
	private void addLabelsForButtons(HBox hb) {
		hb.setTranslateY(5);
		Label l1=addLabel("ImageLabel");	
		Label l2=addLabel("BackgroundLabel");
		Label l3=addLabel("PenLabel");
		Label l4=addLabel("LanguageLabel");
		
		hb.getChildren().addAll(l1,l2,l3,l4);
	}
	
	private Label addLabel(String name) {
		Label l=new Label(myResources.getString(name));
		l.setPrefWidth(BUTTON_WIDTH);
		return l;
	}
	
	private void addCommandLine() {
		
		command = new TextArea ();
		command.setPromptText(myResources.getString("Prompt"));
		command.setPrefHeight(COMMANDHEIGHT);
		command.setPrefWidth(COMMANDWIDTH);
		
		Button b=addSubmitButton();
		
		HBox hb = new HBox();
		hb.getChildren().addAll(command,b);
		hb.setSpacing(HBOX_SPACING);
		hb.setTranslateX(GRID_X1);
		hb.setTranslateY(GRID_Y2+TURTLEAREA_TEXTFILED_SPACE);
		root.getChildren().add(hb);
		
	}
	
	private Button addSubmitButton() {
		SubmitButton b = new SubmitButton(myResources.getString("Submit"),SUBMIT_BUTTON_WIDTH,SUBMIT_BUTTON_HEIGHT);
		b.setOnAction(e ->{
			if (!command.getText().equals(null)) {
				String currentCommand=command.getText();
			
				try {
					commandValue=BEdriver.setCommand(currentCommand);
					
					
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException | InstantiationException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				commandHistory.addHistory(currentCommand);
				returnValue.addReturnValue(commandValue);
				command.clear();
				}
		});
		return b;
	}

	private void addTurtleImage() {
		File file = new File(DEFAULT_TURTLE_DIRECTORY);
        Image image = new Image(file.toURI().toString());
		displayTurtle = new DisplayTurtle(image,ORIGIN_X,ORIGIN_Y,TURTLESIZE);
	}

	private void addAllButtons(HBox layout) {
		
		layout.setTranslateY(BUTTONS_Y);
		Button b1=turtleImageButton();
		final BackgroundPicker b2 = new BackgroundPicker(DEFAULT_TURTLEAREA_COLOR,BUTTON_WIDTH,BUTTON_HEIGHT,turtleArea);
		final PenPicker b3= new PenPicker(Color.BLACK,BUTTON_WIDTH,BUTTON_HEIGHT,turtlePath);
		ChoiceBox b4=setUpLanguage();
		Hyperlink b5=helpButton();
		layout.getChildren().addAll(b1,b2,b3,b4,b5);
	}
	
	private ChoiceBox setUpLanguage() {
		ChoiceBox<String> cb=makeChoiceBox();
		cb.setPrefWidth(BUTTON_WIDTH);
		cb.setPrefHeight(BUTTON_HEIGHT);
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      @Override
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		        String language=cb.getItems().get((Integer) number2);
		      }
		    });
		
        return cb;
		
	} 
	
	private Button turtleImageButton() {
		
		TurtleImageButton b = new TurtleImageButton(myResources.getString("SetImage"),BUTTON_WIDTH,BUTTON_HEIGHT);
		
		b.setOnAction(e ->{
			displayTurtle.setImage(b.chooseTurtle(displayTurtle));
		});
		
		return b;
		
	}
	
	private ChoiceBox<String> makeChoiceBox() {
		ChoiceBox<String> cb = new ChoiceBox<String>();
		cb.setItems(FXCollections.observableArrayList(
				"Chinese","English","French","German","Italian","Portuguese","Russian","Spanish")
		);
		
		cb.setValue("English");
		return cb;
		
	}
	
	private Hyperlink helpButton() {
		
		final Hyperlink help = new Hyperlink(myResources.getString("Help"));
		help.setPrefHeight(BUTTON_HEIGHT);
		help.setPrefWidth(BUTTON_WIDTH);
		help.setAlignment(Pos.CENTER);
		help.setOnAction(new EventHandler<ActionEvent>() {

			 @Override
		        public void handle(ActionEvent e) {
		   
		            try {
		            	   getHostServices().showDocument(myResources.getString("HelpPage"));

		            } catch (final Exception exc) {
		                System.out.println("Error: the following link could not be open:" + help.getText());
		            }
		        }});
		 
		return help;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
