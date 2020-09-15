package isu;

import java.awt.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class Player {
	private int x;
	private int y;
	private int speed = 4;

	private Image upImage;
	private Image downImage;
	private Image rightImage;
	private Image leftImage;
	private Image currentImage;

	private int playerNum;

	private int arrayLocationRow;
	private int arrayLocationCol;

	private int lives;
	private String direction = "stay";
	private int points;

	//Description: The constructor for the Player class, it creates a new player object and determines if its player 1 or 2 to do different task 
	//Parameters: the player number and the number of pixels it travels every tick
	//Return: N/A
	public Player(int player, int speed)
	{
		playerNum = player;
		if (playerNum == 1)
			player1();
		else 
			player2();
	}

	//Description: This initializes player 1's character images, spawning location, points and lives
	//Parameters: none
	//Return: N/A
	private void player1()
	{
		upImage = new ImageIcon("back.png").getImage();
		downImage = new ImageIcon("front.png").getImage();
		rightImage = new ImageIcon("right.png").getImage();
		leftImage = new ImageIcon("left.png").getImage();
		currentImage = downImage;

		x = 45;
		y = 45;

		arrayLocationRow = 1;
		arrayLocationCol = 1;
		this.lives = 3;
		points = 0;
	}
	//Description: The same as player 1 but opposite side of the map and images
	//Parameters: none
	//Return: N/A
	private void player2()
	{
		upImage = new ImageIcon("back blue.png").getImage();
		downImage = new ImageIcon("front blue.png").getImage();
		rightImage = new ImageIcon("right blue.png").getImage();
		leftImage = new ImageIcon("left blue.png").getImage();
		currentImage = downImage;

		x = 605;
		y = 605;

		arrayLocationRow = 15;
		arrayLocationCol = 15;
		this.lives = 3;
		points = 0;

	}

	// getter methods
	public int getArrayLocationRow () {
		return arrayLocationRow;
	}

	public int getArrayLocationCol() {
		return arrayLocationCol;
	}

	public int getLives() {
		return this.lives;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	public int getPoints() {
		return points;
	}
	public Image getLivesImage()
	{
		return downImage;
	}

	//Description: Returns whether or not a player still has lives remaining.
	//Parameters: none
	//Return: boolean
	public boolean livesStatus() {
		if (lives > 0) {
			return true;
		}
		else {
			return false;
		}
	}



	// setter methods
	public void minusLives() {
		this.lives -=1;
	}
	public void addPointsBlock()//Adds 5 points for destroying breakable walls 
	{
		this.points += 5;
	}
	public void addPointsEnemy() //Adds 20 points for destroying breakable walls 
	{
		this.points += 20;
	}
	public void addPointsPlayer() //Adds 50 points for destroying breakable walls 
	{
		this.points += 50;
	}

	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}


	//Description: This updates the position of each player and changes their x and y
	//Parameters: the 2D integer array with the board and what's on it
	//Return: N/A
	public void updatePos(int[][] locArr)
	{
		//This makes sure they don't move out of bounds
		if((y - speed) < 45)
			y = 45;

		if ((y + speed) > 610)
			y = 610;

		if ((x-speed) < 45) 
			x = 45;

		if ((x+speed) > 610) 
			x = 610;

		//This calculates their array location based on their x and y
		arrayLocationRow = ((y+1)/40);
		arrayLocationCol = ((x+1)/40);


		//These controls their movements whenever its directions is set to something through key presses it updates the direction variable in the object
		//that tells it to move in a certain direction
		//This code is repeated for all directions
		if(direction.equals("up"))
		{
			int tempArrRow = (y-speed)/40;//the row that is "speed" pixels above it
			//Checks if 5 pixels in front of the top 2 corners are walls, if they are not then it moves up
			if(locArr[tempArrRow][arrayLocationCol] != 1 && locArr[tempArrRow][arrayLocationCol] !=2 
					&& locArr[tempArrRow][(x+29)/40] != 1 && locArr[tempArrRow][(x+29)/40] != 2)
			{
				y-=speed;
			}

		}
		if(direction.equals("down"))
		{
			int tempArrRow = (y+29+speed)/40;
			if (locArr[tempArrRow][arrayLocationCol] != 1 && locArr[tempArrRow][arrayLocationCol] !=2 
					&& locArr[tempArrRow][(x+29)/40] != 1 && locArr[tempArrRow][(x+29)/40] != 2)
			{
				y+=speed;
			}

		}
		if(direction.equals("right"))
		{
			int tempArrCol = (x+29+speed)/40;
			if (locArr[arrayLocationRow][tempArrCol] != 1 && locArr[arrayLocationRow][tempArrCol] !=2 
					&& locArr[(y+29)/40][tempArrCol] != 1 && locArr[(y+29)/40][tempArrCol] != 2)
			{
				x+=speed;
			}

		}
		if(direction.equals("left"))
		{
			int tempArrCol = (x-speed)/40;
			if (locArr[arrayLocationRow][tempArrCol] != 1 && locArr[arrayLocationRow][tempArrCol] !=2 
					&& locArr[(y+29)/40][tempArrCol] != 1 && locArr[(y+29)/40][tempArrCol] != 2)
			{
				x-=speed;
			}
		}


	}
	//Description: This updates the image every time they change direction
	//Parameters: the direction
	//Return: N/A
	public void setCurrentImage(String dir)
	{
		if (dir.equals("up"))
			currentImage = upImage;
		else if (dir.equals("down"))
			currentImage = downImage;
		else if (dir.equals("right"))
			currentImage = rightImage;
		else if (dir.equals("left"))
			currentImage = leftImage;
	}

	//Description: This draws the player object to the board and sizes it 30 by 30 pixels at its x and y coordinates
	//Parameters: the graphics
	//Return: N/A
	public void drawPlayer(Graphics g, ImageObserver observer)
	{
		g.drawImage(currentImage, x, y, 30, 30, observer);
	}

}







