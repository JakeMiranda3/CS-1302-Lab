[33mcommit bf4cb4fb6713faf80e441f09f826418533582c64[m[33m ([m[1;36mHEAD[m[33m -> [m[1;32mmain[m[33m)[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Fri Dec 6 03:45:06 2024 -0500

    Updated GUI to Remove Task
    
    1. Implemented appropriate methods in the view model to support removing the currently selected Task from the Task Manager.
    A. Added a ObjectProperty in the ViewModel to hold the value of the selectedTask.
    B. Added a remove task method to remove the currently selected task in the list view.
    C. The method checks the currently selected task and makes sure its not null then removes the task.
    2. Implemented appropriate bindings in MainWindow to support removing the currently selected Task when the button is pressed.
    A. In the MainWindow the remove task event handler to handle the button calls the method to remove the task in ViewModel.
    B. If nothing is selected, an Alert pop up appears asking the user to select a task to remove.

[33mcommit 8386422b3199b66fd3ab0df3d0026757085ff5f9[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Fri Dec 6 02:36:27 2024 -0500

    Updated GUI to Add Task
    
    1.Implemented appropriate properties and methods in the view model to support adding a task given the title and description.
    A. Added a String property for task title and task description.
    B. Then added a addTask method which got the title and description properties and checked preconditions and then created a new Task.
    C. Then added the new task to the task manager.
    2. Updated AddTaskWindow to bind onto the appropriate properties and methods from view model.
    A. Did this by creating FX ids for the textfield and textarea for the the title and description.
    B. I then binded the Task Title and Description and the Title and Description text properties.
    C. Then I put the addTask button in an event handler which added the task and then closed the AddTaskWindow when completed.

[33mcommit 5dcbb408f0bf45401c84a5cf2c3c14d6a8289f9b[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Fri Dec 6 01:21:20 2024 -0500

    Updated GUI to Cancel Add Task Window
    
    1.Updated AddTaskWindow to close itself when the cancel button is pressed.
    2. Did this by adding FXIds to both the Cancel button and Anchor pane.
    3. I then in the bind method used the event handler to call the close window button to close the window when the button is pressed.

[33mcommit 520328f32f43f7a2c2eda11dc2ae3ee959044def[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Fri Dec 6 01:04:17 2024 -0500

    Updated GUI to Display Add Task Window
    
    1. Updated the MainWindow to display the AddTaskWindow as a modal dialogue when the + button is pressed.
    A. In main added a new TASK_WINDOW_TITLE name and a TASK_GUI_RESOURCE to use in MainWindow.
    B. This allowed me to set up the button to open another window.
    C. This refrenced my new class AddTaskWindow which has a method that sets up binding for view model.
    D. Then put this all together in an event handler using the add task button to open the new window.

[33mcommit 1c4481c83e42ab3de1ee9d4a3a64422d02ae49d5[m[33m ([m[1;31morigin/main[m[33m, [m[1;31morigin/HEAD[m[33m)[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Fri Dec 6 00:01:02 2024 -0500

    Updated GUI to Support Saving a Set of Tasks
    
    1. Implemented appropriate additions to the viewmodel and bindings for File > Save Tasks menu item,
    to save display a file picker then save the current set of tasks to the file selected.
    A. Gave a FXID to the Menu Item Save. Made a private helper method for both save and load to clean up the initialize.
    B. In MainWindow I also implemented this and made sure to catch any exceptions that can be thrown.
    2. In ViewModel I then called this save method to the original method from TaskManagerPersistenceManager.
    3. Made sure if the user does not select a file, then the system doesnt perform any action.
    4. Made sure if the user selects a file which cant be written over, then the system should display an error stating the file can't be overwritten.
    A. First to do this, I did research on the FileWriter and came across the method "canWrite()" which tests whether the application can modify the file.
    B. I then used this implementation in the TaskManagerPersistenceManager to throw a SecurityException if the file cant be written in.
    C. Then implemented this in MainWindow by having an alert box display to the user if they came across this problem.
    5. Then tested the SaveTaskManager from ViewModel, which test null and empty data file, when tasks are in task manager, and when the file is locked.

[33mcommit a5ff61ad3f27e7399f1e5dde431e43797785efd6[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Dec 5 21:37:55 2024 -0500

    Updated GUI to Support Loading a Set of Task
    
    1.Implemented appropriate additions to the viewmodel and bindings for the File:: Load Tasks menu item to display a file picker,
    then load the selected tasks if it contains the appropriate format.
    2. Made sure if the user does not select a file, then the system doesnt perform any action.
    3. Made sure if the user selects a file which is not in a valid format, then the system displays a pop-up window indicating the selected file is not in the right format.
    4. Then tested loading the task through view model.
    A. Tested for empty and null file, and empty task in file, which all throw IllegalArgumentExceptions.
    B. Tested for one and two tasks in file, which results in loading those task in the appropriate format.

[33mcommit b6c8f4effb72346ee81c069054d1f5e1364a385e[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Dec 5 19:02:46 2024 -0500

    Updated GUI to Support Displaying a set of Tasks
    
    1. Created a viewmodel class to store a list of tasks in a list property to sucessfully bind the view.
    2. In View Model I made the constructor add two default task to the list for when the system launches.
    3. Then in MainWindow I binded the ListView of task and the list property of task so they would display on the gui.
    4. I noticed a problem with the gui, which I had to add a toString in the Task to return the title of the task.
    5. Testing both ViewModel and Task
    A. I tested the ViewModel to make sure it created a list with 2 default task.
    B. I tested the toString to make sure it returned the title of the task.

[33mcommit b22fd69cfd5870f9b3ae9ebfedfd44dbed8aa30f[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Dec 5 15:58:07 2024 -0500

    Loading and Saving Tasks
    
    1. Implemented a class TaskManagerPersistenceManager which has methods to save and load TaskManagerData from specified files.
    2. The first method in this class is a static method which saves task manager data.
    A. This method takes in a TaskManager and a String of the dataFile name, which both have precondition checks for null and empty.
    B. This static method writes the title in the first line then goes to the next line and writes the description and continue.
    3. The second method in this class is a static method which loads task manager data.
    A. This method takes in a String of a dataFile name, which has the precondition checks for null and empty.
    B. This method goes through the file and loads in the tasks to the task manager.

[33mcommit f0ae91d57e64dac3b20818b792996a7f3a6396c7[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Dec 5 10:41:09 2024 -0500

    Managing Tasks
    
    1. Implemented a class which supports storing the set of tasks in the system
    2. This class includes being able to add and remove tasks
    3. Then added two test classes for the removing and adding methods
    4. Tested when removing null, one, and two task.
    5. Tested when adding null, one, and two task.

[33mcommit 66dba68eb6527264a5ee686bf17b8f100e7d22e4[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Dec 5 09:20:19 2024 -0500

    Storing Task
    
    1. Implemented a class which supports storing a task. This includes a title and a description for the task.
    A. Title and description have preconditions which they cant be empty or null.
    2. Added a test package and then had a test class, so I can test the constructor.
    A. Tested when Title is empty and null, description is empty and null, and a valid title and description.

[33mcommit 25b3a703c94c6ce04cb3201caa6f0e99c71a9ebf[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Dec 5 08:51:19 2024 -0500

    Added Project 3 to the Repo
    
    1. Added project 3 to the repo
    2. Added the githubrepolink.txt file to the project

[33mcommit f87bb4b1d4d3b0ca2709811b1a95d5cbc25c3e9d[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 20 22:12:04 2024 -0500

    Added githubrepolink and log.txt to Lab 9
    
    1. Added githubrepolink to lab 9
    2. Added log.txt to Lab 9

[33mcommit 5b6adac403d0a502cbaee92b6ac70f356c0883cc[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 20 21:58:35 2024 -0500

    Implemented Enable/Disable Generate Password
    
    1.Updated the GUI to enable/disable the generate password button based on the current input being empty or not.
    2. Created a private helper method to set up the enabling of controls.
    3. Then binded the generatePasswordButton disable property to minimumLength.textProperty.isEmpty().
    4. Then called this method in the initialize method.

[33mcommit 72d17bca99c2dddc1a5f5b6275e76c3660452aab[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 20 20:32:55 2024 -0500

    Implented Menu
    
    1. Updated the Password Generator system to have a simple Menu
    2.Did this by adding a menu bar with a file menu and two menu items: About and Close.
    A. About, when clicked displayed an information pop up that described the purpose of the project and my name.
    B. Close, exited the application.

[33mcommit f8ef23b4a0d660580cd18947b2c5c7908bce8a48[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Nov 14 15:15:41 2024 -0500

    Added Lab 9 to Repo
    
    1. Downloaded lab 9 started and added to repo.

[33mcommit 7937100b7f45a991027a0b129154935bda9c6cf5[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Nov 14 00:12:56 2024 -0500

    Added githubrepolink and log.txt to Lab 8
    
    1. Added githubrepolink to lab 8
    2. Added log.txt to Lab 8

[33mcommit 12347588fd45b24afcc446b99c57525ff19e847c[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 13 23:56:42 2024 -0500

    Stored List of Passwords
    
    1. Updated the GUI to have a listview instead of a textarea.
    A. Did this by first getting rid of the textarea in scene builder and adding a listview instead.
    B. I then got rid of any text property for the output and any methods that contained this.
    C. I added a ListProperty in the viewmodel and updated the generatePassword method to add the password to the front of the list.
    2. Updated test cases to follow the new method behavior
    A. Edited the test cases in GeneratePassword view model to check the list property instead of the textproperty.
    B. Since we are now storing the passwords in a listview I decided to add a test case that worked with adding multiple valid inputs,
    which then stored them in the list.

[33mcommit 2ba0465cfcf9843974f6b48d3a6807ebe81ce808[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 13 22:54:41 2024 -0500

    Implemented Input Validation
    
    1.Added a helper method to set up the listener for validation
    A. Saw that only one validation is needed as there is one text box that the user will be entering text in.
    B. Added the addlistener in the method with a regular expression to make sure the new value matches it.
    C. Added a errorText label for the user when typing the minimum length.

[33mcommit 4f4a7b9011e120038344fe6fc281842c783054d5[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Nov 7 15:28:00 2024 -0500

    Added Lab 8 to Repo
    
    1. Downloaded and added lab 8 to repo.

[33mcommit 3c6f34f96facd31d2b487e4608204e70c6cdaad7[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 6 20:34:53 2024 -0500

    Added githubrepolink and log.txt to Lab
    
    1. Added githubrepolink to lab 7.
    2. Added log.txt to lab 7.

[33mcommit 26b71f93c0be7853fcea84c410bf2ef6c9a432c9[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 6 20:24:31 2024 -0500

    Binded View to ViewModel
    
    1. Implemented databinding and calls in the MainWindow class to utilize the ViewModel class that was implemented before.
    2. Added a MainWindow constructor to instantiate MainWindowViewModel.
    3. Added a bindComponentsToViewModel method to bind all of the properties.
    A. Binded errorText and output.
    B. Bidirectional binded all checkboxes, and minimum length as its user input.
    4. Fixed the initialize to call the bindComponentsToViewModel method.

[33mcommit e46c5d57a9fb215de46fd518c8dd976ac80fd04a[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 6 19:44:05 2024 -0500

    Tested ViewModel
    
    1. Added a view_model package nested inside the test package to allow better organization.
    2. I then added a TestGeneratePassword test to test scenarios for the method generatePassword in the MainWindowViewModel.
    A. This included for IllegalArgumentException and NumberFormatException, which instead of assertThrows, I did assertEquals to check the errorText message is the same.
    3. While testing I noticed a bug where I wasnt including the random seed to happen in my method.
    A. To fix this I created a Random() object then called it inside the password object paramater.

[33mcommit f0428c8355b9d5a3a8a66e6628b0a311e2e1ad42[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 6 17:34:15 2024 -0500

    Implemented View Model
    
    1. Implemented a new class named MainWindowViewModel to follow naming paterns from in class activity.
    2. In the MainWindowViewModel constructor I I initialized 6 variables to correspond to the MainWindow.
    A. I have String and Boolean properties to match the MainWindow functionality
    3. Added getters for each variable so they can be accessed in the view when binding.
    4. Added the generate password method to generate the password according from user input.
    A. Implemented as closly as possible from the generate password method in the MainWindow.
    B. This included try catch blocks to catch any exceptions that can be thrown when generating the password.

[33mcommit a60977ab034930c4013bdece3940f42d29f49cf8[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Nov 6 16:06:32 2024 -0500

    Added Lab 7 to the Repo
    
    1. Downloaded and added Lab 7 to Repo

[33mcommit 4a6c57b894d8c2c2a42709bf0d596fd1ef96fb7c[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Mon Nov 4 02:04:27 2024 -0500

    Added log.txt to Project 2
    
    1. Generated a file named log.txt containing a copy of my commit history.
    2. Added that file containing my commit history to my project.

[33mcommit 93339bae4304d05c68c5a3e1bff3fd6c04a4cf11[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Mon Nov 4 01:57:00 2024 -0500

    Connected GUI to Business Logic to Display Recipes
    
    1.Implemented Main Window to display an appropriate error message if no ingredient is selected
    2.Implemented in MainWindow to read all recipes from files, then remove all recipes from the list which do not include the currently selected ingredient,
    convert the list of recipes remaining into a String, and display the string representation of the list of recipes in the recipies list Text Area.

[33mcommit 4b2a15c78aed092fe0dff1bd779ae6541f297d66[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Mon Nov 4 00:51:05 2024 -0500

    Updated Business Logic to Display Recipes
    
    1.Added a static method that converts a list of recipes to a String, which includes a blank line between each recipe.
    A. Then tested the method by checking when the list of recipes are null, empty, one recipe, and multiple.
    2. Added a class to load recipes from a file named LoadRecipesFromFile.
    A. Added a method that returns a list of recipes loaded from a file, if the file wasnt found or was empty it returned an empy list.
    B. This method required a lot of stripping and storing values which I then tested.
    C. I tested if there was no recipe in file, one recipe, and two recipes.
    3. I then added a method that returns a list of recipes with a specific ingredient included from a file.
    A. This method was a lot trickier as I went about it multiple different ways before finally finding a way that worked.
    I used the previous method that was just implemented and loaded the recipe list from it.
    By doing so I was able to already have the preconditions in their, where if the file was not found or was empty then it returned a empty list.
    B. I then tested this method by testing no recipe in file, no recipe in file has the specific ingredient, one recipe in file has specific ingredient,
    one recipe in file has specific with multiple ingredients in recipe, and two recipes in file that contain the specific ingredient.

[33mcommit 333dba979984b4d6949cea32d8ccae8b6448c75e[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Nov 3 20:48:58 2024 -0500

    Updated GUI to Display Available Recipes
    
    1. Added a TextArea to display the recipes.
    2. Added a button to trigger displaying the recipes.

[33mcommit e2fe24f5788be08da3b1a6839e0964a7eb6b64c0[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Nov 3 20:10:22 2024 -0500

    Connected GUI to Business Logic to Add Recipe
    
    1. Implemented MainWindow to support adding a selected ingredient to the ListView for a recipe when the add ingredient recipe button is pressed.
    A. Got the ingredient that is currently selected and checked if it was null, if it wasnt it got added to recipe, however if it was null a show and wait error would be triggered.
    2. Implemented Mainwindow to create a Recipe object with the name and list of ingredients provided in the TextField and ingredients ListView.
    A. Got the name of the recipe and list of ingredients then in a try block I created a new Recipe.
    B. I then had multiple catch blocks to catch any exceptions that may get thrown and handled properly by triggering a show and wait errorPopup.

[33mcommit d49bbb4a64c77e1c684d65799001c8862f336a84[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Nov 3 19:09:53 2024 -0500

    Updated Business Logic to Add Recipe
    
    1. Implemented a class to store and manage the information for a recipe.
    A. Created a Recipe class that stores and manages the information for a recipe.
    B. Then wrote a new test case to test the constructor when name is either empty or null, ingredients is empty or null, and when a valid recipe is created.
    2. Implemented a utility class to manage converting recipes to String.
    A. Created a utility class that converts a recipe to a string.
    B. Then wrote a new test case to test the recipeToString method when recipe is null, one ingredient, and two ingredients.
    3. Implemented a class to write a recipe to a file.
    A. Created a RecipeToFile class that supports writing a recipe to file.
    B. Then wrote a new test case to test concerns, while testing I noticed a bug that would happen with my test cases,
    which resulted in me writing a @BeforeEach to create a new empty file. This is so when I test, it uses a new file instead of one that has recipe's already in it.
    C. I tested when there is a null recipe, one recipe, multiple recipes, and when theres duplicate recipes which would result in an IllegalStateException.

[33mcommit 0efd42bd32814ae5857db7bb7f794e71b3da5161[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Nov 3 00:19:13 2024 -0400

    Updated GUI to Add Recipe
    
    1. Supported displaying ingredients in a recipe by adding a ListView to store ingredients for the recipe.
    2. Supported adding selected ingredients to the recipe by adding a button to add currently selected ingredients from the pantry to the recipe ListView.
    3. Supported naming a new recipe by adding a Textfield and a label with the text "Recipe Name".
    4. Supported adding a recipe to the recipe book by adding a button to add a recipe with the current list of ingredients and name.

[33mcommit 47eb0121a53320760a6e3ce590fab809952df819[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sat Nov 2 23:00:29 2024 -0400

    Added Test Cases To Comparators
    
    1. Made new test packages to organize the test cases by class.
    A. Added a testCompare class that tested IngredientNameComparator.
    B. Tested when ingredients were null when being compared.
    C. Then tested the output integers for each scenario when names are equal, first ingredient already in right spot, and when the ingredient needs to go to the first spot.
    2. I then created a new TestToString class to test the toString() in the IngredientNameComparator.
    A. Tested the output when toString() is called which results in "Name".
    3. Added a testCompare class that tested IngredientTypeComparator.
    A. Tested when ingredients were null when being compared.
    B. Tested the output integers for each scenario when types are equal, first ingredient already in right spot, and when the ingredient needs to go to the first spot.
    4. Created a new TestToString class to test the toString() in the IngredientTypeComparator.
    A. Tested the output when toString() is called which results in "Type".
    5. Fixed compareTo methods.
    A. I changed my compareTo methods in both classes to compareToIgnoreCase, as I noticed a bug when manually testing the gui that didn't sort the ingredients properly.

[33mcommit 60d1508ac7850d8fa8d3e9c7e40917197e64024a[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Oct 31 14:06:28 2024 -0400

    Connected GUI to Business Logic to Sort
    
    1. Implemented a toString() in IngredientTypeComparator to return "Type".
    2. Implemented a toString() in IngredientNameComparator to return "Name".
    3. Implemented MainWindow to initialize the sort criteria combobox to store a Type and Name Comparator.
    4. Added a method to be triggered when a sort criteria is selected that will sort the list of ingredients using the currently selected sort critera.
    5. This allowed the system to be able to update adding and removing ingredients to ensure the list is sorted after it has been updated.

[33mcommit 3ebca54f4b090b3f4aca4a0f80352c1adf8b1def[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Oct 31 13:22:37 2024 -0400

    Updated Business Logic to Sort By Type Or Name
    
    1. Implemented a TypeComparator class that implements the Comparator<Ingredient> interface.
    A. Did this to be able to compare ingredient objects based on their type.
    2. Implemented a NameComparator class that implements the Comparator<Ingredient> interface.
    B. Did this to be able to compare ingredient objects based on their name.

[33mcommit 655d02abcaf94e5e327037f3ee8a0def984f40da[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Oct 31 12:02:56 2024 -0400

    Updated GUI
    
    1. Updated the GUI to support selecting a sort criteria.
    A. I did this by adding a combo box and a label above named "Sort By".

[33mcommit 609c75659af635c790688ea580ed7a950172b8f3[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Oct 24 13:07:50 2024 -0400

    Added Project 2 to the Repo
    
    1. Added project 2 to the repo
    2. Added the githubrepolink.txt file to the project

[33mcommit 697873cded59efb21d36cf440abb4a84fdc40e8d[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Oct 16 20:24:04 2024 -0400

    Added log.txt to Lab 6
    
    1. Generated a file named log.txt containing a copy of my commit history.
    2. Added that file containing my commit history to my project.

[33mcommit bf77635e3a8bd19bfee21885cf81ad7a8ef94f65[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Oct 16 20:12:30 2024 -0400

    Sorting Bill Items by Cost in MainWindow
    
    1. Added a combo box to the gui to choose between ascending and descending.
    A. In the initialize I set the values to be acsending and descending so the user can choose.
    2. Added a change order method in mainwindow to sort and update receipt.
    A. I noticed my sort wasn't working so I had to add a sort method in the Bill class.
    B. Then in the MainWindow I implemented this change to sort the values and then update the receipt.

[33mcommit 32ac206f156dd4d36dbae93eb7093d9fe55ca622[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Tue Oct 15 23:43:59 2024 -0400

    Sorting Bill Items by Cost Implementation
    
    1. Created a new BillAscendingCostComparator class to sort the bill in ascending order based on the cost of bill items.
    2. Created a new BillDescendingCostComparator class to sort the bill in descending order based on the cost of the bill items.

[33mcommit 43991ba54a962459f61cb478b103cb8ea0d06b4f[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Tue Oct 15 23:06:35 2024 -0400

    Implementing Multiple Formats in MainWindow
    
    1. Added a ComboBox to the gui
    A. Did this so the user can choose to save the bill in either csv or tsv formats.
    2. Changed the savaBillData to get the value of the combo box and save it in that format.
    3. Updated the Initialize
    A. added the CSV and TSV to the combo box to be able to choose between the two.
    B. Also implemented it to load the bill data from either format depending on what is saved

[33mcommit f0ee8ba46f1272d0e2af4c6df15b13ad970067d1[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Oct 10 16:11:56 2024 -0400

    Implementing Multiple Formats
    
    1. Made a abstract class
    A. stripped down save and load
    2. Made a CSVBillPersistenceManager class
    A. Extends to Abstract class to be able to override the save and load methods.
    B. Ensured its comma seperated.
    C. Added a toString to return "CSV" so it can say which type it is using.
    3. Made a TSVBillPersistenceManager
    A. Extends to Abstract class to be able to override the save and load methods.
    B. Changed the save and load methods from CSV to TSV, to ensure its tab seperated.
    C. Added a toString to return "TSV" so it can say which type it is using.

[33mcommit 4b56af418014d2e9bd3a499c242068d7a2ac317f[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Oct 10 15:28:13 2024 -0400

    Added Lab 6 to the Repo
    
    1. Downloaded and added Lab 6 to the repository

[33mcommit bce5b824c0f97617611c9eba51f6d8047173efa4[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Oct 6 20:33:26 2024 -0400

    Testing Load Bill Data
    
    1. Implemented the test cases to ensure the method loadBillData is working.
    A. Upon adding testing I enountered where my method could go wrong so I added a if statement,
     in my loadBillData method to make sure reader has next line before doing anything else inside the try block.
    2. I checked for 5 conditions: empty file, one bill item in file, multiple bill items in file, one bill item in file with invalid amount, and one bill item in file with invalid name.

[33mcommit 260347805ba91b1be2b4373abe197e29bfe9c25b[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Oct 6 19:24:14 2024 -0400

    Implementation of Load Bill Data
    
    1. Implemented the method loadBillData in the BillPersistenceManager class.
    A. I did this by using a scanner to read through the file.
    B. In the try block I first set the server name by using the first line of the file.
    C. Then inside the for loop I started the lineNumber at 2 as the first line was already read.
    D. While inside the for loop I get the nextLine and strip and split the string into two parts.
    E. The two parts are the name and the amount of the item.
    2. Added and Implemented a button to load the bill data in the MainWindow.
    A. In the loadBillData method in the MainWindow I used a try block to catch the FileNotFoundException and IOException

[33mcommit d43469626b3616f8b8242b6fdb3d5c08aa5eeb20[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Oct 6 17:57:02 2024 -0400

    Testing Save Bill Data
    
    1. Implemented test cases to ensure the method saveBillData is working.
    2. I checked for 5 conditions: null bill, no items in bill, server name in bill, one item in bill, and multiple items in bill.

[33mcommit 3e215482fc4ba9c38f2f7cb7344e1a1691913010[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Oct 6 17:18:14 2024 -0400

    Implementation of Sava Bill Data
    
    1. In the Bill Persistence Manager class I implemented the functionality of the saveBillData method.
    A. Checked for null and then implemented a try block.
    B. In the try block I have a for each loop to go through and write each bill item name and amount seperated by a comma.
    2. Implemented the saveBillData in the MainWindow.
    A. Did a try block for saving the bill and a catch block to catch an IOException and alert the user with a show and wait if it cant save data to file.

[33mcommit d30bf63fce3f2ec3354cd0fb2fc7ed3cc6625500[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Sun Oct 6 16:39:23 2024 -0400

    Added the Fixed Lab 5 to Repo
    
    1. When I looked into my lab 5 I was missing classes and the whole file looked wrong.
    2. So I downloaded it again added the fixed one to the repo.

[33mcommit 969cccb3fb185a30211f475cebdc4199b3ab6d44[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Tue Oct 1 14:00:41 2024 -0400

    Added Lab 5 to the Repo
    
    1. Deleted the original bill file using git rm, and then moved the new bill folder to the repo.

[33mcommit 64896bec374f7990e24c1d1ff62dcd4a23c593a0[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 21:24:59 2024 -0400

    Added log.txt to Project
    
    1. Generated a file named log.txt containing a copy of my commit history.
    2. Added that file containing my commit history to my project.

[33mcommit 43a6d9242b489560b8fc78e8d61bb7db649bf390[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 21:04:26 2024 -0400

    Connect Business Logic and UI to Update Quantity
    
    1. Implemented the method in the MainWindow class for displaying the count of food in the pantry to display a popup window of sum quantity of all food in pantry.
    2. In this method I ensured that if the list was empty a error pop up would show and wait to the user displaying the error.
    3. However, If the list contained food It would show and wait an information alert box displaying the quantity of food in the pantry.

[33mcommit 83a140e33d0f3a5c53e9b429039ac1deb608a450[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 20:17:57 2024 -0400

    Fixed UI and UnitTesting Names
    
    1. After rereading the subtask C instructions I noticed I didnt need the textfield to display the pantry quantity,
            so I deleted it and updated my MainWindow to support the fix.
    2. Updated package and class names of the Unit Test to follow correct coding practice.

[33mcommit ae75a66d67fe4da1c5f31ba98d5dfae2f0be7632[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 20:09:23 2024 -0400

    Business Logic for Counting Pantry
    
    1. Created a utility class called CountPantry and added a static method in their to count pantry food quantity.
    2. In that static method I have it pass through a list of Food and check for null and size equaling zero to ensure the list exist and has values.
    3. I then created a for each loop to interate through the list and count the quantity of food.
    4. I then implemented test cases to ensure the static method works properly and checks the preconditions.

[33mcommit 7d49d7b9f2b8c924c1d2210122c479a58ebbcf9c[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 19:23:37 2024 -0400

    Implementing UI for Counting Pantry
    
    1. Updated the MainWindow to support viewing the count of items in the pantry.
    2. I added a textfield to dispaly the items and made that textfield uneditable.
    3. I also added a button to press to count the number of items in the pantry.

[33mcommit 1880be1e0a922c8292da5f9f838649194d2c7aa2[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 18:59:43 2024 -0400

    Implement UI for Removing Food
    
    1. Implemented the method in MainWindow associated with removing food from the pantry.
    2. Also implemented a show and wait error popup if the user doesnt select a food to remove.

[33mcommit 52a8a5d965b95431961e187439ee5809cd798b7f[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 18:54:11 2024 -0400

    UI for Removing Food
    
    1. Updated the MainWindow to support remove selected food.
    2. I did this by adding a button component to the gui and an associated method in the MainWindow class.

[33mcommit 404e94733e99e5ba9b4e7588312c5f1ce96769f3[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 17:52:43 2024 -0400

    Connect Business Logic and UI to Update Quantity
    
    1. Implemented methods in the Mainwindow class for setting, incrementing, and decrementing the quantity.
    2. Setting the quantity should read the quantity from the textfield and then set the quantity for the food currently selected in the listview.
    A. Should check if user is selecting something in the listview and if not should have a show and wait error popup.
    B. Should then set the quantity to the food object and refresh the pantry list to display the updated listview.
    3. Incrementing the quantity should increment the quantity for the food currently selected in the listview.
    A. Should check if the user is selecting something in the listview and if not should have a show and wait error popup.
    B. If the user does have something selected it should increase the quantity by one and then refresh the pantry list to display the updated listview.
    4. Decrementing the quantity should decrement the quantity for the food currently selected in the listview.
    A. Should check if user is selecting something in the listview and if not should have a show and wait error popup.
    B. If the user does have something selected it should decrease the quantity by one and then refresh the pantry list to display the updated listview.
    C. If the user tries to decrease quantity, by going past zero it should have a show and wait error popup.

[33mcommit 9dbb310ae8342e2b9ece132e0ea0c4cb41809c55[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 16:31:18 2024 -0400

    Business Logic for Updating Quantity of Food
    
    1. Updated the Food class to support updating quantity of food in the pantry.
    2. I did this by implementing a method that allows setting the quantity.
    A. This includes passing a value through a parameter to get the quantity value.
    B. The value must be greater than or equal to zero as you cant have a negative number of food in the pantry.
    C. Also Implemented Unit testing to test the setQuantity is following the precondition and working.
    3. Added a method that allows incrementing the quantity.
    A. This method increments the quantity by one each time it is called.
    B. Implemented Unit testing for this method, to test each call of the method increased the quantity by one.
    4. Added a method that allows decrementing the quantity.
    A. This method decrements the quantity by one each time it is called.
    B. However, this is only true if the quantity is not equal to zero as you cant have a negative number of food in pantry.
    C. Implemented Unit testing for this method, to ensure the precondition is working and the method itself is decreasing by one each time it is called.

[33mcommit d2a264619f4db508ec896a57ea3cd002e3471cb3[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 15:42:16 2024 -0400

    Implementing UI for Updating Quantity
    
    1. Updated the MainWindow fxml and codebehind class to support the following:
    A. Setting the quantity, added a label, textfield, and a button for setting the quantity of food.
    B. Incrementing the quantity, added a button for the user, which I will later add a method to be able to click and increase by one.
    C. Decrementing the quantity, added a button for the user, which I will later add a method to be able to click and decrease by one.

[33mcommit cc1f15f36f156e37b2e666deebd68515ad94433c[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 25 00:23:15 2024 -0400

    Connect UI to Business Logic for Adding Food
    
    1. Updated the MainWindow class to implement the method for adding a food item.
            I did this by setting the types for ComboBox and ListView.
    2. I then set up the comboBox by adding the given types of food from the instructions,
            so when adding a food item the food object is created from using the name from the textfield and type from the combobox.
    3. I then implemented the addFood method to be able to add food to the listview.
    A. I did this by first getting the food name and type from the textField and combobox.
    B. Then I added a try and catch to handle the possibility of an IllegalArgumentException, by alerting the user with a show and wait errorPopup.
    C. If the user passes through the try block, it will then add the food name and quantity to the pantry.

[33mcommit 13a2fc26858691aad0836995751297237a8a039d[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Tue Sep 24 23:06:16 2024 -0400

    Business Logic for Storing Food Test Cases
    
    1. Created a nested test package for the Food class in the model package.
    2. Then created two separate test Clases to keep the testing seperate.
    3. Tested the Constructor of the Food Class to ensure the name and type were getting initialized, and that the quantity was being set to zero.
    4. Then Tested the toString method to ensure it was printing correctly.

[33mcommit d88516dfd0941c6af1c096876d0971a5efa0f928[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Tue Sep 24 13:57:42 2024 -0400

    Implementing the Business Logic for Storing a Food
    1. Added a data class that will store the information for a single Food
    A. This includes the food name, type, and quantity to store information.
    B. Made the name and type final variables as they should not be allowed to change.
    2. Added getters for each field to get the information about the food.
    3. Added a toString that returns the name of the food and quantity.

[33mcommit 4b2ede3851ae99cc5fecae58a28e4d36c45eed73[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Tue Sep 24 00:02:25 2024 -0400

    Adding UI Components for Adding Food
    
    1. Updated the MainWindow fxml and code behind class to support the folllowing components.
    A. Created a label and textfield for entering the name for a new food.
    B. Created a label and combo box for entering the type for a new food.
    C. Added a button to the gui for submitting information for a new food.
    D. Added a listview to enable the user to select a food from the pantry.

[33mcommit 8d53980edf365846e8ffdc3ee244b0b70e91e10f[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 19 16:10:59 2024 -0400

    Updated Class Paths
    
    1. Updated the naming conventions of the project to make more sense.
    2. Updated the naming convention of the package to be project 1 so it can compile.
    3. Updated the MainWindow.fxml AnchorPane to refrence the fx:controller project1 so it can run.
    4. Updated the WINDOW_TITLE in the Main class to "Pantry Tracker" which fits better for the project.

[33mcommit 35d7dd3e584d95dc4b3e58b32d70ef4a5f820640[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 19 15:24:38 2024 -0400

    Added Project 1 to the Repo
    
    Added the JavaFx Sample code to the local repo

[33mcommit a05f34ee0a3983b49dd7e15f6537cea10af8b322[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 19 00:52:45 2024 -0400

    Implemented Test Cases and Fixed Static Methods
    
    1. After rereading the lab instructions it said "static method which accepts an Array of BillItem Objects as input",
            so just in case I changed my paramaters from passing through a bill object into passing an Array of BillItems.
    
    2. Implementing the test cases I wanted to test anything that the static method would include.
    A. TestGetSubtotal, I wanted to check the items name and amount in the bill and the sub total.
    B. TestGetTax, I wanted to check the items name, amount, sub total, and tax. I checked sub total in this case,
            because the tax is derived from the sub total so ensuring there both right is key.
    C. TestGetTip, I wanted to check the items name, amount, sub total, and tip. This followed the same structure as the sub total,
            where the tip is derived from the sub total.
    D. TestGetTotal, I wanted to check everything: items name, amount, sub total, tax, tip, and total. This is because the total derives from everyother value added up together,
            so ensuring each piece of information is correct ensures the static method getTotal works.

[33mcommit af5b194192cf1e554d9502669790dcb8195e0ddc[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 18 23:55:55 2024 -0400

    Static Bill Calculations
    
    1. Changed the methods of the get subtotal, tax, tip, and total for an Array of BillItem objects in a bill
            to be static in a seperate class. I did this so it can get called without needing a specific bill object.
    
    2. I havent deleted the original methods in the Bill class as I want to test the static methods and ensure my implmentation is correct.

[33mcommit 4f0475fae01f6d7985eabf6a0bda1dfc740cab7d[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 12 16:17:36 2024 -0400

    Fixed Converted the Fields of BillItem Class to Final
    
    1. Changed the variables name and amount to be final.
            This will ensure once the field is set in the BillItem constructor it can't be changed.

[33mcommit ce8f4ccd79d43409a7eb0f6950d7496236236290[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 12 15:50:36 2024 -0400

    Converted The fields of BillItem Class to Final
    1. Changed the variables name and amount to be final.
            This will ensure once the field is set in the BillItem constructor it can't be changed.

[33mcommit 6657cfc8f142df8a90c1d66519b22d471fd49f74[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 12 15:45:49 2024 -0400

    Added Fixed Lab 4 to Repo

[33mcommit 42712e02b2ddf748b1f5ee74af462b76c1b33dab[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 12 15:33:26 2024 -0400

    Added Lab 4 to the Repo

[33mcommit 17bd5ecd9cf1ef1ec6a2e1278e052eeee6beed43[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Wed Sep 11 20:34:09 2024 -0400

    Added Testing for the CalculateAverage method
    
    1. When I added test cases I realized I had to change how the method calculateAverage worked.
            Instead of passing through a ListView I decided to pass through an ArrayList of Students to make it testable.
            I changed a few lines in my MainWindow code to compensate this by adding a ArrayList variable and storing the ListView items in there.
    2. When it came to creating the test cases I felt the only necessary test cases was when there was zero, one, and multiple students in the list.
            I then checked not only the average being correct but the name and grade of each student and how big the list was.

[33mcommit d4dfc44db3470a572cc02ba870151dd4aefc471c[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Tue Sep 10 22:49:56 2024 -0400

    Corrected and Fixed the Implementation of Getting Average Grade
    
    1. Instead of getting the average of students in the view package I created a AverageCalculator class in the model package.
            In this class I created a static method to calculate and return the average grade of students.
    
    2. To fully implement this new class, I got rid of the old getAverage private helper method in the MainWindow class.
            I then called this static method in the MainWindow class to calculate the average grade of students.

[33mcommit e4ab72b23fc23c28664fe88b84d4baf9a83ebe21[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Tue Sep 10 12:31:29 2024 -0400

    Displaying Average Grade For Studens
    
    1. To clear the code up I made the getAverage a private helper method,
            I did this so I can call this method in both add and remove Student.
            I wanted the textField for studentAverage to update whenever a students get added or removed.
    
    2. In my getAverage method I did a for each loop to iterate over the list of students and get their total grade.
            I then got the average and did Math.round to get the average to two decimal places.

[33mcommit 2d1f935e0e9c5d1418f8dab504fcabc9126a5e2b[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 5 21:23:36 2024 -0400

    Test Cases
    
    1. Made Test cases for the Student constructor including ranges and null checks.
    2. Also implemented the Math.round function so grades have two decimal places.

[33mcommit 0d70ce42caa1712755e50afe84baf45e1bfe6584[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 5 20:29:57 2024 -0400

    Added checkGrade and Implemented Preconditions
    
    1. I added a getGrade method in the Student class, so I am able to store the grade of a student.
    2. I added the method checkGrade in the MainWindow class to be able to dispaly the grade of the selected student with the use of a button.
    3. I also implemented preconditions to the Student constructor to ensure the grade range of 0<= grade <= 100.

[33mcommit 17412e43556d0cfbb3e75c0f6624a4ef7edb4822[m
Author: Jake T Miranda <jmirand3@my.westga.edu>
Date:   Thu Sep 5 16:35:50 2024 -0400

    Added lab 3 to the Repo and Made Changes to Code
    
    1. Added a remove student to remove the selected student
    2. Added catch exceptions

[33mcommit f2f75054eb8929131d2ea65a705fff4808a42ed4[m
Author: JakeMiranda3 <jmirand3@my.westga.edu>
Date:   Thu Sep 5 15:34:17 2024 -0400

    Initial commit
