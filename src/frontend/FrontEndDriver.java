package frontend;

import controller.Controller;

import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class FrontEndDriver extends Application {




private static final int BOTTOM_LAYOUT_X = 50;
	private static final int BUTTONS_Y = 30;
	private static final int BOTTOM_BUTTONS_Y = 620;
	private static final int SAVE_BUTTON_WIDTH = 80;
	private static final int SAVE_BUTTON_HEIGHT = 40;
	
	private static final int HBOX_SPACING = 20;
	private static final int SUBMIT_BUTTON_WIDTH = 80;
	private static final int SUBMIT_BUTTON_HEIGHT = 40;
	private static final int COMMANDWIDTH = 350;
	private static final int COMMANDHEIGHT = 40;
	private static final int TURTLEAREA_TEXTFILED_SPACE = 50;
	private static final int GRID_X1 = 50; // this should be the left-most line coordinate of the turtle grid
	private static final int GRID_X2 = 500; // this should be the right-most line coordinate of the turtle grid
	private static final int GRID_Y1 = 100; // this should be the top-most line coordinate of the turtle grid
	private static final int GRID_Y2 = 500; // this should be the bottom-most line coordinate of the turtle grid
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
	protected static final int BUTTON_WIDTH = 150;
	protected static final int BUTTON_HEIGHT = 40;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/buttons_labels";
	private static final Color DEFAULT_TURTLEAREA_COLOR = Color.HONEYDEW;
	public static final double TURTLESIZE = 50;
	public static final double ORIGIN_X = (GRID_X2 - GRID_X1 - TURTLESIZE) / 2;
	public static final double ORIGIN_Y = (GRID_Y2 - GRID_Y1 - TURTLESIZE) / 2;

	protected Display turtleArea;
	private TurtlePath turtlePath;
	private Stage window;
	private Group root;
	private ResourceBundle myResources;
	private TextArea command;
	private History commandHistory;
	private ReturnValue returnValue;
	private UserDefinedVariables userDefinedVariables;
	private History userDefinedCommands;
	private DisplayTurtleManager displayTurtleManager;
	private LanguageChooser languageChooser;
	private double commandValue;
	private Controller myController;
	private int count=0;
	private BackgroundPicker b2;





	@Override
	public void start(Stage primaryStage) throws Exception {
		myController = new Controller(displayTurtleManager);
		myController.createTurtleTree();
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		window = primaryStage;
		HBox layout = new HBox(VBOX_SPACING);
		HBox layout2=new HBox(VBOX_SPACING);
		HBox bottomlayout=new HBox(VBOX_SPACING);

		addLabelsForButtons(layout2);
		root = new Group();
		Scene startScene = new Scene(root, WIDTH, HEIGHT);
		//startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		DisplayTurtle firstTurtle = new DisplayTurtle();
		turtleArea = new Display(firstTurtle, GRID_X1, GRID_Y1, GRID_WIDTH, GRID_HEIGHT);
		displayTurtleManager = new DisplayTurtleManager(firstTurtle);
		addAllButtons(layout);

   
        addBottomButtons(bottomlayout);
		addCommandLine();

		returnValue = new ReturnValue(myResources.getString("Return"), HISTORY_X, RETURN_Y, HISTORY_WIDTH,
				RETURN_HEIGHT);
		commandHistory = new History(myResources.getString("History"), HISTORY_X, HISTORY_Y, HISTORY_WIDTH,
				HISTORY_HEIGHT, displayTurtleManager, returnValue, myController,turtleArea);
		userDefinedVariables = new UserDefinedVariables(myResources.getString("UserV"), HISTORY_X, UserV_Y, HISTORY_WIDTH,
				UserV_HEIGHT, displayTurtleManager, returnValue, myController,turtleArea,window);
		userDefinedCommands = new History(myResources.getString("UserC"), HISTORY_X, UserC_Y, HISTORY_WIDTH,
				UserC_HEIGHT, displayTurtleManager, returnValue, myController,turtleArea);
		root.getChildren().addAll(layout, layout2,bottomlayout, commandHistory, returnValue, userDefinedVariables,
				userDefinedCommands, turtleArea);

		window.setTitle("SLogo");
		window.setScene(startScene);
		window.show();
		
	    KeyboardHandler keyboardHandler=new KeyboardHandler(root,this);
	    keyboardHandler.execute();
		
		

		
	}
	



	private void addLabelsForButtons(HBox hb) {
		hb.setTranslateY(5);

		Label l1=addLabel("ImageLabel");	
		Label l2=addLabel("BackgroundLabel");
		Label l3=addLabel("PenLabel");
		Label l4=addLabel("LanguageLabel");
		Label l5=addLabel("NewLabel");
		hb.getChildren().addAll(l1,l2,l3,l4,l5);

	}

	private Label addLabel(String name) {
		Label l = new Label(myResources.getString(name));
		l.setPrefWidth(BUTTON_WIDTH);
		return l;
	}

	private void addCommandLine() {

		command = new TextArea();
		command.setPromptText(myResources.getString("Prompt"));
		command.setPrefHeight(COMMANDHEIGHT);
		command.setPrefWidth(COMMANDWIDTH);
		command.setFocusTraversable(false);

		SubmitButton b = addSubmitButton();

		HBox hb = new HBox(command, b);
		hb.setSpacing(HBOX_SPACING);
		hb.setTranslateX(GRID_X1);
		hb.setTranslateY(GRID_Y2 + TURTLEAREA_TEXTFILED_SPACE);
		root.getChildren().add(hb);
	}

	private SubmitButton addSubmitButton() {
		SubmitButton b = new SubmitButton(myResources.getString("Submit"), SUBMIT_BUTTON_WIDTH, SUBMIT_BUTTON_HEIGHT);
		b.setOnAction(e -> {
			String currentCommand = command.getText();
			executeCommand(currentCommand);
			command.clear();
		});
		return b;
	}

	private void executeCommand(String currentCommand) {
		executeCommandOnly(currentCommand);
		commandHistory.addHistory(currentCommand);
		returnValue.addReturnValue(commandValue);
		List<String> variablesList=myController.getUserDefinedVars();
		if (variablesList.size()!=count) {
			for (int i=count;i<variablesList.size();i++) {
				String curr=variablesList.get(i);
				userDefinedVariables.addHistory(curr);
			}
			count=variablesList.size();
		}
		
		

	}

	protected void executeCommandOnly(String currentCommand) {
		commandValue = myController.setCommand(currentCommand);

        displayTurtleManager.updateTurtles(myController.getTurtles(),turtleArea);

	}
	
	
	private void addBottomButtons(HBox layout) {
		layout.setTranslateX(BOTTOM_LAYOUT_X);
		layout.setTranslateY(BOTTOM_BUTTONS_Y);
		SaveButton b1=new SaveButton(myResources.getString("Save"),SAVE_BUTTON_WIDTH,SAVE_BUTTON_HEIGHT);
		ResumeButton resumeB=new ResumeButton(myResources.getString("Resume"),SAVE_BUTTON_WIDTH,SAVE_BUTTON_HEIGHT);
		b1.setOnAction(e -> b1.save(languageChooser,b2));
		resumeB.setOnAction(e -> resumeB.resume(b1));
		layout.getChildren().addAll(b1,resumeB);
		
		


		


	}

	protected void addAllButtons(HBox layout) {
		layout.setTranslateY(BUTTONS_Y);
		TurtleImageButton b1 = new TurtleImageButton(myResources.getString("SetImage"), BUTTON_WIDTH, BUTTON_HEIGHT);
		b1.setOnAction(e -> displayTurtleManager.setImages(b1.chooseTurtleImage(displayTurtleManager.getAnActiveTurtle())));
		 b2 = createBackgroundPicker();
		PenPicker b3 = new PenPicker(Color.BLACK, BUTTON_WIDTH, BUTTON_HEIGHT, turtlePath);
		languageChooser = new LanguageChooser(myResources.getString("Languages"), BUTTON_WIDTH, BUTTON_HEIGHT);
		languageChooser.getIndex().addListener(
				(observable, oldIndex, newIndex) -> myController.setParserLanguage(languageChooser.getCurrentLanguage(newIndex)));
		HelpButton b5 = new HelpButton(myResources.getString("Help"), BUTTON_WIDTH, BUTTON_HEIGHT);
		b5.setOnAction(e -> b5.GoToHelpPage(myResources.getString("HelpPage"), this));
		NewWorkSpaceButton b6=new NewWorkSpaceButton(myResources.getString("new"),BUTTON_WIDTH,BUTTON_HEIGHT); 
		b6.setOnAction(e -> b6.createNewWorkSpace());
		layout.getChildren().addAll(b1,b2,b3,languageChooser,b6,b5);

	}
	
	
	
	
	protected BackgroundPicker createBackgroundPicker() {
	   
		return new BackgroundPicker(DEFAULT_TURTLEAREA_COLOR, BUTTON_WIDTH, BUTTON_HEIGHT, turtleArea);
	}
	
	public static void main(String[] args) {
		launch(args);
	}




}

