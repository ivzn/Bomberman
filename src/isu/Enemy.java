package isu;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.*;

import javax.swing.ImageIcon;

public class Enemy {

	private static LinkedList<Enemy> enemyList = new LinkedList<Enemy>();

	private static int maxNumEnemies;
	private static int totalNumEnemies = 0;
	private int x;
	private int y;

	private int arrayLocationRow;
	private int arrayLocationCol;

	private Image rightImage;
	private Image leftImage;
	private Image currentImage;

	private String direction = "up";

	//Description: The constructor for the enemy class, it creates a new enemy object and determines if its the orange or blue one and initialises its location
	//Parameters: the row and col location and a random 1 or 2 to determine what colour
	//Return: N/A
	public Enemy(int arrayLocationRow, int arrayLocationCol, int enemyType)
	{
		this.arrayLocationRow = arrayLocationRow;
		this.arrayLocationCol = arrayLocationCol;
		this.x = arrayLocationCol*40;
		this.y = arrayLocationRow*40;
		if(enemyType == 1)
			orange();
		else if(enemyType == 2)
			blue();
		enemyList.add(this);
		totalNumEnemies++;
	}

	//Description: Gives it the orange images 
	//Parameters: nothing
	//Return: N/A
	private void orange()
	{
		rightImage = new ImageIcon("OranR.png").getImage();
		leftImage = new ImageIcon("OranL.png").getImage();
		currentImage = leftImage;

	}

	//Description: Gives it the blue images 
	//Parameters: nothing
	//Return: N/A
	private void blue()
	{
		rightImage = new ImageIcon("BlueR.png").getImage();
		leftImage = new ImageIcon("BlueL.png").getImage();
		currentImage = leftImage;
	}

	//getters
	public static LinkedList<Enemy> getEnemyList()
	{
		return enemyList;
	}
	public int getArrayLocationRow () {
		return arrayLocationRow;
	}

	public int getArrayLocationCol() {
		return arrayLocationCol;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	public static int getMaxNumEnemies() 
	{
		return maxNumEnemies;
	}
	public static int getTotalNumEnemies() 
	{
		return totalNumEnemies;
	}

	//Setters
	public static void setMaxNumEnemies(int num) 
	{
		maxNumEnemies = num;
	}
	public void setDirection(String direction)
	{
		this.direction = direction;

	}

	//Description: Identical to the player class updatePosition code that determines how it moves
	//Parameters: 2D integer array to keep track of everything
	//Return: N/A
	public void updateEnemyPos(int[][] locArr)
	{
		if((y - 5) < 45)
			y = 45;

		if ((y + 5) > 610)
			y = 610;

		if ((x - 5) < 45) 
			x = 45;

		if ((x + 5) > 610) 
			x = 610;

		arrayLocationRow = ((y+1)/40);
		arrayLocationCol = ((x+1)/40);

		if(direction.equals("up"))
		{
			int tempArrRow = (y-5)/40;
			if(locArr[tempArrRow][arrayLocationCol] != 1 && locArr[tempArrRow][arrayLocationCol] !=2 
					&& locArr[tempArrRow][(x+29)/40] != 1 && locArr[tempArrRow][(x+29)/40] != 2)
			{
				y-=5;
			}

		}
		if(direction.equals("down"))
		{
			int tempArrRow = (y+29+5)/40;
			if (locArr[tempArrRow][arrayLocationCol] != 1 && locArr[tempArrRow][arrayLocationCol] !=2 
					&& locArr[tempArrRow][(x+29)/40] != 1 && locArr[tempArrRow][(x+29)/40] != 2)
			{
				y+=5;
			}

		}
		if(direction.equals("right"))
		{
			currentImage = rightImage;
			int tempArrCol = (x+29+5)/40;
			if (locArr[arrayLocationRow][tempArrCol] != 1 && locArr[arrayLocationRow][tempArrCol] !=2 
					&& locArr[(y+29)/40][tempArrCol] != 1 && locArr[(y+29)/40][tempArrCol] != 2)
			{
				x+=5;
			}

		}
		if(direction.equals("left"))
		{
			currentImage = leftImage;
			int tempArrCol = (x-5)/40;
			if (locArr[arrayLocationRow][tempArrCol] != 1 && locArr[arrayLocationRow][tempArrCol] !=2 
					&& locArr[(y+29)/40][tempArrCol] != 1 && locArr[(y+29)/40][tempArrCol] != 2)
			{
				x-=5;
			}
		}
	}

	//Description: Draws the enemy at the current location
	//Parameters: graphics
	//Return: N/A
	public void drawEnemy(Graphics g, ImageObserver o)
	{
		g.drawImage(currentImage, x, y, 30, 30, o);
	}


}


