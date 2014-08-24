package com.turkey.LD30.levels;

import GameAPI.map.Map;

public class Level
{
	
	private Map overWorld;
	private Map underWorld;
	
	private int levelNum;
	
	private int lowestSawps = 0;
	
	public Level(Map ow, Map uw, int num)
	{
		overWorld = ow;
		underWorld = uw;
		levelNum = num;
	}
	
	public Map getOverWorld()
	{
		return overWorld;
	}
	
	public Map getUnderWorld()
	{
		return underWorld;
	}
	
	public int getLevelNumber()
	{
		return levelNum;
	}
	
	public void swapsUsed(int swaps)
	{
		if(lowestSawps == 0 || lowestSawps > swaps)
		{
			lowestSawps = swaps;
		}
	}
	
	public int bestSwapsAmmount()
	{
		return lowestSawps;
	}
}
