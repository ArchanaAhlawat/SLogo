### Frontend 
* External 
    * The graphical interface will be a part of the Front End driver class, while the interpreter will be a part of the BackEnd driver class. They will be linked through the controller, which has access to the front end external API and backend external API. The controller will be able to communicate the necessary information between the back end and front end. 
    * Things that will be available are the raw input the user puts into the textbox and the command arguments that the interpreter will be able to parse. Errors involving incorrect/malformatted input strings will be thrown by the interpreter and displayed by the Front End error message class. In summary, the driver classes between the backend and frontend communicate through the controller
All of these methods will need to be public is noted

* Internal
    * We plan to provide paths for extension through our carefully-designed hierarchy and classes. We have Turtle class, Pen class, Textbox class, Error Message class and Front end driver class. These classes make our structure flexible. For example, we can easily change to a totally different turtle by creating a new turtle object. 
    * Basically, we are going to make specific implementation of subclasses close to modification because these are properties specific to a subclass and we do not want to someone outside to change it. For example, we are going to create a subclass of Pen class which will draw dotted line. This will be close to modification because it is the unique feature of this subclass. The method inside superclass such as Draw() (which means setting penUp or penDown) would be open to modification.
    * The specific Front end internal API would look like:
            * Turtle class<br/>
               * A function called stepTurtle (double displacement). It moves turtle by displacement amount in any direction. This function is needed to update location of turtle. This function needs to be package-friendly because it needs to be called outside Turtle class.
          * A function called turnTurtle(double degree). It turns the turtle a certain number of degrees clockwise or counterclockwise. This function is equivalent to a setter of turtle’s Direction instance variable. It will update direction of turtle. It needs to be package friendly.
          * A function called setHeadingTurtle(double degree). It turns the turtle towards an absolute heading. Similarly, the function needs to be package friendly.
      * Pen class
          * A function called draw(boolean instruction). This function will set whether the pen should be up or down according to user input. Thus, it needs to be package friendly. 
      * Textbox class
            * A function called clearText(). This function will clear the content inside textbox after ‘enter’ is pressed by user. This function has to be package friendly because it needs to be put inside Event Handler of the button. 
       * Error message class
           * A function called popUp(). This function will make the pop up window for error message. This function will be package friendly because it needs to be called inside Front end driver class when an error is received.




### Backend
* Driver Class
    * When language is clicked on the frontend (external api), use the correct resource language file to create the map of words in that language to instructions in english
    * Driver instantiated w constructor that takes in String language as an input.
Use reflection to call the method that the specific instruction in english corresponds to (internal api) in the Commands Class, ultimately returning a TurtleInfo object
Sends the TurtleInfo object in the correct order to the frontend to update the turtle’s graphical information (external api)
    * On a high level this just will set everything up and take in the string from the frontend and then interpret it using the parser (external). Internally, this calls the parser and makes all the api calls.

* TurtleInfo
    * Object that holds important turtle info that is passed to the front end via external API
    * Instance variables
        * Double x coordinate displacement
        * Double y coordinate displacement
        * Double rotation displacement
        * Double size (add later, a way to extend)
        * Boolean penup
        * String pencolor
        * Constructor sets up the object with all zeros (default values)
        * Info passed out (external api) to the front end with getters
        * Info passed in (internal api) from the Commands Class with setters<br/>
  
    * This is good because it allows for extension of parameters/turtle information that can be changed internally. This allows for easy extension to be able to add more parameters/information that can be changed via instructions. It also allows for the frontend externally to get the various displacements/changes to graphically update! These should probably be encapsulated so that the front end cannot change the values, but they do not affect anything in the backend currently (since the absolute locations/properties are not kept). So it should not make too much of a difference, but would be good practice. Errors might need to be thrown when instance variables are trying to be updated to wrong types or an instance variable is not created yet/the properties have not been updated.

* Commands Class (internal api)
    * Has the code/logic for running/executing each instruction
    * Creates a new TurtleInfo object
    * TurtleInfo info about movement (displacement) received by getting from MoveHelper class
Edits the specific values/instance variables within the TurtleInfo (internal api) using the TurtleInfo setters
    * Returns TurtleInfo Object
    * Errors will be thrown when the specific instruction is not defined. Uses the MoveHelper public methods to actually figure out what to do with the instructions (or these can be within this class).

* MoveHelper Class (possibly, internal api)
    * Is called in Commands class in the case of a move instruction
Contains methods to compute displacement from moving (ex. moveForward(), moveBackward(), etc.)
    * Has get methods to allow Commands class to access displacement values
These are used in the Commands Class and defines all of the instruction methods. These are only used locally to make the new TurtleInfo object and thus are in the internal api. There may be errors when a specific instruction isn’t defined. Another issue is if the parameters do not match. But other than that it should successfully create the object. This can also easily be extended with more methods for new instructions.

