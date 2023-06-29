# CS160LAB_JavaCo
/**
 *  Program Java Co. Menu Lab Project: README.md
 *
 * This file acts as an instruction manual for the program. Please read through to get a clear understanding.
 *  
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  /
# Context
This was my CS160L Summer2023 Lab project. 
For approximately 6 weeks, we were tasked to create a coffee ordering interface using the concepts we learned with each progressing week.

# Instructions
The Main.java class is the main interaction hub for the ordering interface. Run the Main.java file in an IDE or compile it in a
terminator of choice.
  --- Since Intellij was the native IDE used to code, I would HIGHLY recommend using this as the main interface to run my codes!

  Please download all files also for proper compilation. This includes given .txt files and .jpg files.

  When first loaded, the Inventory.txt will be read and printed out. This is the inventory currently available.
  --- Inventory.txt is automatically overwritten per successful order
  --- If so desired, the number of ingredients can be changed, but please do not change the ingredient names as this is how the program
  reads the inventory.txt
  --- Please also keep '=' as this is how ingredients and quantities are split.

  From there, the user can navigate through the menu.
  1.) Add an order -- Utilizes buildOrder() to build a new CoffeeOrder and add it to orders 
  2.) Reload inventory -- Calls readInventory(inventoryFile) and store the results in inventory, then print the current inventory for the user */
  3.) Update Inventory -- Calls writeInventory(inventoryFile) to manually update overwrite Inventory.txt
  4.) Update Order Log -- Calls writeOrderLog(logFile) to manually update OrderLog.txt
  5.) Quit the Application -- Terminate the user input loop and exit the program. Before exiting, the inventory should be updated and any remaining orders are to be logged 

  The provided code does handle exceptions (i.e InputMismatchException) to loop if an invalid option was inputted.

# Contribution
I'm always looking to improve so if you do somehow find this and see a bug, please contact me ! I would love to fix it
  
# Acknowledgments:
 
Despite the majority of my code being written by myself, I had a lot of outside help during the progression of my project.

Patricia Kraft - The professor leading the CS160 SUM2023 class
Erin Ratelle - The TA leading the CS160L SUM2023 class (my code followed the guidelines and code solutions posted by Erin)
Steven Nguyen -  The TA leading the CS160 SUM2023 class
Joshua Concepcion - My project partner that I collaborated for the beginning of this project

For my "twist" theses were the refences I used
This class was largely inspired from the following YouTube video:  
@see <a href= "https://www.youtube.com/watch?v=FdQX8sUNO-s&ab_channel=WinstonLievsay"> Reference video by: Winston Lievsay  </a> 

This reference was also good for looking up additional information on GUI 
@see <a href= "https://www.geeksforgeeks.org/jlabel-java-swing/"> GeeksforGeeks: Java Swing </a>

This reference was also used for making my Gui 
@see <a href= "https://www.geeksforgeeks.org/creating-frames-using-swings-java/"> GeeksforGeeks: Creating Frames using Swings in Java</a>
