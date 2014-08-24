package com.turkey.LD30.Tiles;

import GameAPI.graphics.Image;
import GameAPI.screen.screenObjects.Tile;

public class VoidTile extends Tile
{

	public VoidTile(Image img, String n, int id, String hex)
	{
		super(img, n, id, hex);
	}
	
	public boolean solid()
	{
		return true;
	}
}
