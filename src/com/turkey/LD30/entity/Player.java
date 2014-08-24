package com.turkey.LD30.entity;

import java.awt.event.KeyEvent;

import GameAPI.entity.Entity;
import GameAPI.game.Game;
import GameAPI.graphics.Animation;
import GameAPI.graphics.Image;
import GameAPI.listeners.ScreenKeyListener;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Tile;
import GameAPI.util.Location;
import GameAPI.util.Location.Direction;

import com.turkey.LD30.game.Gameclass;
import com.turkey.LD30.resources.Resources;

public class Player extends Entity
{

	private Animation north, east, south, west, current;
	private Direction facing = Direction.North;
	private boolean isMoving = false;
	private boolean canMove = true;

	private boolean bonusSkin = false;
	private boolean skinwitch = false;
	private int countThree = 0;

	private Image stillImage = Resources.playerNS;

	private int speed = 2;

	private int switchTime = 20, count = 0, countTwo = 0;
	private boolean hasSwitched = false;


	public Player(Game g)
	{
		super(Resources.playerNS, 16, g);

		north = new Animation(new Image[]{Resources.playerNOne, Resources.playerNTwo}, true);
		east = new Animation(new Image[]{Resources.playerEOne, Resources.playerETwo}, true);
		south = new Animation(new Image[]{Resources.playerSOne, Resources.playerSTwo}, true);
		west = new Animation(new Image[]{Resources.playerWOne, Resources.playerWTwo}, true);
		current = north;
	}

	public void update()
	{
		if(!canMove)
			return;
		if(!game.canMoveTo(new Location(x, y), 16))
		{
			if(super.getLocation().divide(Tile.SIZE, Tile.SIZE).equals(new Location(18, 10)) && ((Gameclass)game).getCurrentLevel() == 3 && ((Gameclass)game).isinOverWorld())
			{
				((Gameclass)game).nextLevel();
			}
			else
			{
				ScreenManager.getInstance().setCurrentScreen("End Screen");
			}
		}

		if(ScreenKeyListener.isKeyPressed(KeyEvent.VK_SPACE) && !hasSwitched)
		{
			((Gameclass)game).swapWorlds();
			hasSwitched = true;
		}

		isMoving = false;
		if((ScreenKeyListener.isKeyPressed(KeyEvent.VK_UP) || ScreenKeyListener.isKeyPressed(KeyEvent.VK_W)) && (game.canMoveTo(new Location(x, y-speed), width) && y > -1))
		{
			isMoving = true;
			facing = Direction.North;
			y-=speed;
			if(current != north)
			{
				north.setState(current.getState());
				current = north;
			}
		}
		if((ScreenKeyListener.isKeyPressed(KeyEvent.VK_DOWN) || ScreenKeyListener.isKeyPressed(KeyEvent.VK_S)) && (game.canMoveTo(new Location(x, y+speed), width) && y < 620))
		{
			isMoving = true;
			facing = Direction.South;
			y+=speed;
			if(current != south)
			{
				south.setState(current.getState());
				current = south;
			}
		}
		if((ScreenKeyListener.isKeyPressed(KeyEvent.VK_RIGHT) || ScreenKeyListener.isKeyPressed(KeyEvent.VK_D)) && (game.canMoveTo(new Location(x+speed, y), width) && x < 784))
		{
			isMoving = true;
			facing = Direction.East;
			x+=speed;
			if(current != east)
			{
				east.setState(current.getState());
				current = east;
			}
		}
		if((ScreenKeyListener.isKeyPressed(KeyEvent.VK_LEFT) || ScreenKeyListener.isKeyPressed(KeyEvent.VK_A)) && (game.canMoveTo(new Location(x-speed, y), width) && x > -1))
		{
			isMoving = true;
			facing = Direction.West;
			x-=speed;
			if(current != west)
			{
				west.setState(current.getState());
				current = west;
			}
		}

		if(((int)x/Tile.SIZE) == 24 && ((int)y/Tile.SIZE) == 9)
		{
			((Gameclass)game).nextLevel();
		}

		if(hasSwitched)
		{
			count++;
			if(count == switchTime)
			{
				count = 0;
				hasSwitched = false;
			}
		}
		countTwo++;
		if(countTwo == 20)
		{
			current.nextImage();
			countTwo = 0;
		}
		if(!isMoving)
		{
			if(facing.equals(Direction.North))
				stillImage = Resources.playerNS;
			if(facing.equals(Direction.East))
				stillImage = Resources.playerES;
			if(facing.equals(Direction.South))
				stillImage = Resources.playerSS;
			if(facing.equals(Direction.West))
				stillImage = Resources.playerWS;
		}
		
		if(ScreenKeyListener.isKeyPressed(KeyEvent.VK_F1) && !skinwitch && (Gameclass.gethighestLevel() == Gameclass.getNumberOfLevels()))
		{
			bonusSkin = !bonusSkin;
			skinwitch = true;
			if(bonusSkin)
				speed = 4;
			else
				speed = 2;
		}
		if(skinwitch)
		{
			countThree++;
			if(countThree > 20)
			{
				skinwitch = false;
				countThree = 0;
			}
		}
	}

	public void render()
	{
		if(bonusSkin)
		{
			if(facing.equals(Direction.North))
				this.image = Resources.playerTwoN;
			if(facing.equals(Direction.East))
				this.image = Resources.playerTwoE;
			if(facing.equals(Direction.South))
				this.image = Resources.playerTwoS;
			if(facing.equals(Direction.West))
				this.image = Resources.playerTwoW;
		}
		else
		{
			if(isMoving)
				this.image = current.getCurrentImage();
			else
				this.image = stillImage;
		}

	}

	public void stop()
	{
		canMove = false;
	}

	public void start()
	{
		canMove = true;
	}

}
