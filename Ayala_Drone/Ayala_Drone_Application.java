/*
 * Author Name: Jose Ayala
 * Date: 1/28/2022
 * Program Name: Ayala_Drone
 * Purpose: Simulation using button, drone movement in x, y,z location
*/

import java.util.Scanner;

public class Ayala_Drone_Application {
	
	// Menu Constants
	private static final int MOVE_UP = 1;
	private static final int MOVE_DOWN = 2;
	private static final int MOVE_FORWARD = 3;
	private static final int MOVE_BACKWARD = 4;
	private static final int TURN_LEFT = 5;
	private static final int TURN_RIGHT = 6;
	private static final int DISPLAY_POSITION = 7;
	private static final int EXIT_NAVIGATION = 8;
	
	// Scanner object for user input.
	private static Scanner keyboard;

	// Main Method
	public static void main(String[] args) {

		// Scanner object for user input.
		keyboard = new Scanner(System.in);
		
		int userMenuChoice = 0;
		Ayala_Drone ayalaDrone = new Ayala_Drone();

		while (userMenuChoice != EXIT_NAVIGATION) {

			// Display the menu when the application starts.
			userMenuChoice = displayMenu();

			// Actions based on user menu choice
			switch (userMenuChoice) {
				case MOVE_UP:
					ayalaDrone.moveUp();
					System.out.println("\r\nYou have moved up 1 position.\r\n");
					break;
				case MOVE_DOWN:
					ayalaDrone.moveDown();
					System.out.println("\r\nYou have moved down 1 position.\r\n");
					break;
				case MOVE_FORWARD:
					ayalaDrone.moveForward();
					System.out.println("\r\nYou have moved forward 1 position.\r\n");
					break;
				case MOVE_BACKWARD:
					ayalaDrone.moveBackward();
					System.out.println("\r\nYou have moved backward 1 position.\r\n");
					break;
				case TURN_LEFT:
					ayalaDrone.moveLeft();
					System.out.println("\r\nYou have moved left 1 position.\r\n");
					break;
				case TURN_RIGHT:
					ayalaDrone.moveRight();
					System.out.println("\r\nYou have moved right 1 position.\r\n");
					break;
				case DISPLAY_POSITION:
					System.out.println(ayalaDrone.toString());
					break;
				case EXIT_NAVIGATION:
					System.out.println("\r\nThank you for using the Ayala_Drone application!");
					keyboard.close();
					System.exit(0);
					break;
			}
		}
	}
	
	// Creates the display menu and captures the user input.
	public static int displayMenu() {

		int userMenuChoice = 0;
		String userInput;

		do {
			System.out.println("Which direction would you like to move the drone?");
			System.out.println(MOVE_UP + " - Move Up ");
			System.out.println(MOVE_DOWN + " - Move Down");
			System.out.println(MOVE_FORWARD + " - Move Forward");
			System.out.println(MOVE_BACKWARD + " - Move Backward");
			System.out.println(TURN_LEFT + " - Turn Left");
			System.out.println(TURN_RIGHT + " - Turn Right");
			System.out.println(DISPLAY_POSITION + " - Display Position");
			System.out.println(EXIT_NAVIGATION + " - Exit Navigation");
			
			userInput = keyboard.nextLine();
			
			try 
			{ 
				userMenuChoice = Integer.parseInt(userInput);
			}  
			catch (NumberFormatException e)  
			{ 
				System.out.println(displayErrorMessage());
				continue;
			}
			
			if (userMenuChoice < MOVE_UP || userMenuChoice > EXIT_NAVIGATION) {
				System.out.println(displayErrorMessage());
			}

		} while (userMenuChoice < MOVE_UP || userMenuChoice > EXIT_NAVIGATION);

		return userMenuChoice;
	}
	
	// Returns an error message
	public static String displayErrorMessage() {
		return "\r\nERROR: INVALID VALUE (Enter a number between " + MOVE_UP + " - "
				+ EXIT_NAVIGATION + ")\r\n";
	}

}
