/*
 * Author Name: Jose Ayala
 * Date: 1/28/2022
 * Program Name: Ayala_Drone
 * Purpose: Simulation using button, drone movement in x, y,z location
*/

public class Ayala_Drone {
	
	// Drone Coordinates
	private int x_coordinate;
	private int y_coordinate;
	private int z_coordinate;

	// Initialize Coordinate Variables
	public Ayala_Drone() {
		x_coordinate = 0;
		y_coordinate = 0;
		z_coordinate = 0;
	}

	// Method to move left
	public int moveLeft() {
		return x_coordinate -= 1;
	}

	// Method to move right
	public int moveRight() {
		return x_coordinate += 1;
	}

	// Method to move up
	public int moveUp() {
		return y_coordinate += 1;
	}

	// Method to move down
	public int moveDown() {
		return y_coordinate -= 1;
	}

	// Method to move backward
	public int moveBackward() {
		return z_coordinate -= 1;
	}

	// Method to move forward
	public int moveForward() {
		return z_coordinate += 1;
	}

	@Override
	public String toString() {

		return "\r\nAyala_Drone" + "[ x_position = " + x_coordinate + ", y_position = " + y_coordinate
				+ ", z_position = " + z_coordinate + " ]\r\n";
	}
}
