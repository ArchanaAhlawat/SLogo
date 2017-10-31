
## API changes for frontend

We decided to refactor the controller class. This is turn made it easier to transfer information from the front end to the back end and vice versa. Now our front end driver class is cleaner.

## API changes for backend

The backend external api has changed by passing all of the absolute information from the Turtle to the frontend via a Updates class. This better protects our Turtle class and makes it immutable through the frontend. We decided to use the absolute information, and not changes/displacements to get rid of some of the logic in the frontend and just have the frontend set the turtle orientation and scene properties.

The backend internal api was pretty much the same with the Commands being an Interface that is implemented by all of the specific commands.

