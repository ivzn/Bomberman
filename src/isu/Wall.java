package isu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//Indestructible static wall class
public class Wall extends JPanel {
	private Image inputWall;
	private ImageIcon wall;

	private int wallSize = 40;


	//Description: The constructor for the Wall class, it creates a new wall object with the wall image 
	//Parameters: none
	//Return: N/A
	public Wall()
	{
		inputWall = new ImageIcon("wall.png").getImage().getScaledInstance(wallSize, wallSize, Image.SCALE_DEFAULT);
		wall = new ImageIcon(inputWall);
	}

	// getter method
	public Image getWallImage() {
		return wall.getImage();
	}

}


