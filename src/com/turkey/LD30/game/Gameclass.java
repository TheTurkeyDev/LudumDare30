package com.turkey.LD30.game;

import GameAPI.entity.Entity;
import GameAPI.game.Game;
import GameAPI.main.GameAPI;
import GameAPI.map.MapLoader;
import GameAPI.screen.ScreenManager;
import GameAPI.util.Location;

import com.turkey.LD30.entity.Player;
import com.turkey.LD30.levels.Level;
import com.turkey.LD30.resources.Resources;

public class Gameclass extends Game
{

	private Level[] levels;
	private static int numOfLevels = 10;
	private static int highestLevel = 1;

	private static int numberOfSwaps = 0;
	
	private static boolean levelselected = false;

	private boolean ow = true;

	private int level = 1;

	private Entity player;

	public Gameclass()
	{
		super(GameAPI.width, GameAPI.height);
		levels = new Level[numOfLevels];
		for(int i = 0; i < numOfLevels; i++)
		{
			levels[i] = new Level(new MapLoader(Resources.owImages[i]).loadMap(), new MapLoader(Resources.uwImages[i]).loadMap(), i+1);
		}
		load(1);

	}

	public void load(int startAt)
	{
		if(startAt == 1)
			levelselected = false;
		else
			levelselected = true;
		ow = true;
		numberOfSwaps = 0;
		level = startAt;
		this.setCurrentMap(levels[level-1].getOverWorld());
		player = new Player(this);
		player.setLocation(new Location(8, 296));
		this.addEntity(player);
	}

	public void swapWorlds()
	{
		if(ow)
		{
			ow = false;
			this.setCurrentMap(levels[level-1].getUnderWorld());
		}
		else
		{
			ow = true;
			this.setCurrentMap(levels[level-1].getOverWorld());
		}
		numberOfSwaps++;
	}

	public void nextLevel()
	{
		ow = true;
		levels[level].swapsUsed(numberOfSwaps);
		numberOfSwaps=0;
		level++;
		if(level > levels.length)
		{
			ScreenManager.getInstance().setCurrentScreen("End Screen");
			return;
		}
		this.setCurrentMap(levels[level-1].getOverWorld());
		player.setLocation(new Location(8, 296));
		if(level > highestLevel)
		{
			highestLevel = level;
		}
	}

	public void update()
	{
		super.update();
	}

	public void render()
	{
		super.render();
	}

	public static int getNumberOfLevels()
	{
		return numOfLevels;
	}

	public static int gethighestLevel()
	{
		return highestLevel;
	}

	public int getCurrentLevel()
	{
		return level;
	}

	public Location getPlayerLoc()
	{
		return player.getLocation();
	}

	public Entity getPlayer()
	{
		return player;
	}

	public boolean isinOverWorld()
	{
		return !ow;
	}

	public static int getNumberOfSwaps()
	{
		return numberOfSwaps;
	}

	public Level getLevel(int i)
	{
		return levels[i];
	}

	public Level getLevel()
	{
		return levels[level - 1];
	}
	
	public static boolean wasLevelSelected()
	{
		return levelselected;
	}
	
	public void setheighest(int i)
	{
		highestLevel = i;
	}
}
