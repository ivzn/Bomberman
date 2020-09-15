package isu;

import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

public class DestWall {
	private Image inputWall;
	private ImageIcon wall;
	
	private int x;
	private int y;
	private int wallSize = 40;
	
	//Description: The constructor for the Destructible Wall class, it creates a new object with the other wall image 
	//Parameters: the x and y coordinates of the top left corner of the wall 
	//Return: N/A
	public DestWall(int x, int y)
	{
		inputWall = new ImageIcon("destWall.png").getImage().getScaledInstance(wallSize, wallSize, Image.SCALE_DEFAULT);
		wall = new ImageIcon(inputWall);
		this.x = x;
		this.y = y;
	}
		
	// getter methods
	public Image getDestWallImage () {
		return wall.getImage();
	}
	
	public int getDestWally () {
		return y;
	}
	
	public int getDestWallx() {
		return x;
	}

	
	/*	hashCode Method
	 * description: overrides hashSet to sort by x and y values
	 * returns: int 	
	 */

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	/*	equals Method
	 * description: overrides equals to compare x and y values
	 * returns: boolean 	
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DestWall other = (DestWall) obj;
		return x == other.x && y == other.y;
	}

}


