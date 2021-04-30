The name of this project is "Work Out App". This was made by Team 08 of class CS 3443-003. The team members include Mahnoor Bokhari, Angelo Middleton, Kevin Garcia, Eric Por, and Austine Augustine.

Description: This app has 2 main functionalities: planning workouts and creating and managing a list of recipes.

The user will be prompted to a menu on app execution with a welcome page to the app, then they will have the options presented to go from the differing screens such as the home screen, tracker screen, and the recipe screen.

The recipe screen will have several options presented where the user will need to input the Recipe Name, and Recipe link to add new data to the internal list which tracks the recipes in total that the user has entered after pressing the furthest most right button, "add". The text field under search recipes allows the user to search for a particular item if they use the Recipe Name to search for said item. Show All Recipes does as intended and displays the list of the recipes including its link in the list view. And as for the remove, this removes an item from the list that the user has clicked which will be highlighted and then removed after pressing remove.

The Tracker button will display a calendar and a new workout button, the new workout button will open the workout.fxml and display said field in the open space below allowing the user to input data such as the workout, the reps, and the sets(basically add workout). This would be displayed in the list view below if the user clicks view workout. The remove workout button removes a workout that the user has clicked which will be highlighted. 



Known bugs: Whenever you press the "add" button while leaving the "Recipe Name" and "Recipe Link" TextFields empty, it empties both of the ListViews, and the "Show All Recipes" button does not work. If you add another recipe name and recipe link and then press "Add" again, this problem is fixed.
If you press "Remove" while there are no recipes in the text file, you will receive an error. This is fixed if you add another recipe, select it, then press the "Remove" button.
If you exit the app and start it up again, the content in the files will be deleted and you will have to re-enter everything.

The intended function of the home button was to bring the data forward from the recipes and tracker to the home page as an easy way to see what you have done whether that be a recent workout/recipe or one at random.

The intended function of the tracker was for the calendar to be incorporated into it with the workout and tracker. Where the user would enter a clickable calendar date, then proceed to the next area which would open the workout.java allowing the user to enter the data by adding and removing workouts.
As of right now, the calendar option is non-functional. The app is only able to store and access data for workouts and recipes, but not match them with a date.



INSTRUCTIONS TO USE:

If you are using Eclipse with Java 8, with JavaFX and SceneBuilder installed:
Go to File -> New -> Project -> JavaFX Project, then set up a new JavaFX Project.
Download all the files from GitHub, and go to your project folder -> src -> application, and copy and paste the files, except for Model.java.
Under “src”, create a package named “model”. Paste Model.java into this package.
If necessary, import the JavaFX User Library into the project.

Then you may run the application and use it. No files are required to test it.

To add a recipe: click on the “Recipes” tab, then type the name of the recipe and its link to the corresponding TextFields, then click the “Add” button.
To show all recipes: press the “Show All Recipes” button.
To search for a recipe: type your search text into the Search bar, then press “Search”.
To remove a recipe: select the recipe name from the list, then press “Remove”.

To add a workout: click on the “Tracker” tab, click on “New Workout”, then enter your workout description, the number of reps, and the number of sets. Press “add workout”.
To view all added workouts: click on the “view workouts” button.
To remove a workout: select the workout name from the list to be removed, then click “remove workout”.

