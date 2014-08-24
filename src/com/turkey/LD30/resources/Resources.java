package com.turkey.LD30.resources;

import GameAPI.graphics.Image;
import GameAPI.graphics.ImageSheet;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Tile;

import com.turkey.LD30.Tiles.FinishTile;
import com.turkey.LD30.Tiles.GroundTile;
import com.turkey.LD30.Tiles.LavaTile;
import com.turkey.LD30.Tiles.SkyTile;
import com.turkey.LD30.Tiles.StartTile;
import com.turkey.LD30.Tiles.VoidTile;
import com.turkey.LD30.game.Gameclass;

public class Resources
{
	
	private ImageSheet entities;
	private ImageSheet entitiestwo;
	private ImageSheet tilesheet;
	private ImageSheet buttonSheet;
	
	public static Image[] owImages;
	public static Image[] uwImages;
	
	public static Image msbgOne, msbgTwo, msbgThree, esbgOne, esbgTwo, hsbg, lsbg;
	public static Image startButtonImage, helpButtonImage, retryButtonImage, mainmenuButtonImage, levelSelectButtonImage, continueButtonImage, restartButtonImage;
	public static Image pauseSubScreenImage;
	public static Image voidImage, groundImage, hardenRockImage, lavaImage, skyImage, finishmage, startImage;
	
	public static Image playerES, playerEOne, playerETwo;
	public static Image playerWS, playerWOne, playerWTwo;
	public static Image playerNS, playerNOne, playerNTwo;
	public static Image playerSS, playerSOne, playerSTwo;
	public static Image playerTwoN, playerTwoE, playerTwoS, playerTwoW;
	
	public static Image crossout;
	
	public static Tile voidTile, groundTile, hardenRockTile, lavaTile, skyTile, finishTile, startTile;
	
	
	public void loadResources()
	{
		owImages = new Image[Gameclass.getNumberOfLevels()];
		uwImages = new Image[Gameclass.getNumberOfLevels()];
		
		entities = new ImageSheet(Resources.class, "/Images/Entities.png", 80, 80);
		entitiestwo = new ImageSheet(Resources.class, "/Images/Entities2.png", 80, 80);
		tilesheet = new ImageSheet(Resources.class, "/Images/Tiles.png", 320, 320);
		buttonSheet = new ImageSheet(Resources.class, "/Images/buttonsheet.png", 275, 750);
		
		for(int i = 0; i < owImages.length; i++)
		{
			owImages[i] = new Image(new ImageSheet(Resources.class, "/Levels/Level" + (i+1) + "/OverWorld.png", 25, 20), 0,0, 25, 20);
			uwImages[i] = new Image(new ImageSheet(Resources.class, "/Levels/Level" + (i+1) + "/UnderWorld.png", 25, 20), 0,0, 25, 20);
		}
		
		msbgOne = new Image(new ImageSheet(Resources.class, "/Images/MainScreen1.png", 800, 640), 0,0, 800, 640);
		msbgTwo = new Image(new ImageSheet(Resources.class, "/Images/MainScreen2.png", 800, 640), 0,0, 800, 640);
		msbgThree = new Image(new ImageSheet(Resources.class, "/Images/MainScreen3.png", 800, 640), 0,0, 800, 640);
		esbgOne = new Image(new ImageSheet(Resources.class, "/Images/EndScreen.png", 800, 640), 0,0, 800, 640);
		esbgTwo = new Image(new ImageSheet(Resources.class, "/Images/EndScreen2.png", 800, 640), 0,0, 800, 640);
		hsbg = new Image(new ImageSheet(Resources.class, "/Images/HelpScreen.png", 800, 640), 0,0, 800, 640);
		lsbg = new Image(new ImageSheet(Resources.class, "/Images/LevelSelect.png", 800, 640), 0,0, 800, 640);
		
		pauseSubScreenImage = new Image(new ImageSheet(Resources.class, "/Images/PauseMenu.png", 400, 400), 0,0, 400, 400);
		
		startButtonImage = new Image(buttonSheet, 0, 0, 275, 75);
		helpButtonImage = new Image(buttonSheet, 0, 75, 275, 75);
		retryButtonImage = new Image(buttonSheet, 0, 150, 275, 75);
		mainmenuButtonImage = new Image(buttonSheet, 0, 225, 275, 75);
		levelSelectButtonImage = new Image(buttonSheet, 0, 300, 275, 75);
		continueButtonImage = new Image(buttonSheet, 0, 375, 275, 75);
		restartButtonImage = new Image(buttonSheet, 0, 450, 275, 75);
		
		voidImage = new Image(tilesheet, 0, 0, 32, 32);
		groundImage = new Image(tilesheet, 32, 0, 32, 32);
		hardenRockImage = new Image(tilesheet, 64, 0, 32, 32);
		lavaImage = new Image(tilesheet, 96, 0, 32, 32);
		skyImage = new Image(tilesheet, 128, 0, 32, 32);
		finishmage = new Image(tilesheet, 160, 0, 32, 32);
		startImage = new Image(tilesheet, 192, 0, 32, 32);
		
		crossout = new Image(tilesheet, 0, 32, 64, 64);
		
		playerES = new Image(entities, 0, 0, 16, 16);
		playerEOne = new Image(entities, 16, 0, 16, 16);
		playerETwo = new Image(entities, 32, 0, 16, 16);
		playerWS = new Image(entities, 0, 16, 16, 16);
		playerWOne = new Image(entities, 16, 16, 16, 16);
		playerWTwo = new Image(entities, 32, 16, 16, 16);
		playerSS = new Image(entities, 0, 32, 16, 16);
		playerSOne = new Image(entities, 16, 32, 16, 16);
		playerSTwo = new Image(entities, 32, 32, 16, 16);
		playerNS = new Image(entities, 0, 48, 16, 16);
		playerNOne = new Image(entities, 16, 48, 16, 16);
		playerNTwo = new Image(entities, 32, 48, 16, 16);
		
		playerTwoE = new Image(entitiestwo, 0, 0, 16, 16);
		playerTwoS = new Image(entitiestwo, 0, 16, 16, 16);
		playerTwoW = new Image(entitiestwo, 0, 32, 16, 16);
		playerTwoN = new Image(entitiestwo, 0, 48, 16, 16);
		
		voidTile = new VoidTile(voidImage, "Void Tile", 0, "000000");
		groundTile = new GroundTile(groundImage, "Ground Tile", 1, "007f0e");
		hardenRockTile = new GroundTile(hardenRockImage, "Harden Rock Tile", 2, "404040");
		lavaTile = new LavaTile(lavaImage, "Lava Tile", 3, "FF6A00");
		skyTile = new SkyTile(skyImage, "Sky Tile", 4, "0094FF");
		finishTile = new FinishTile(finishmage, "Finish Tile", 5, "FFFA00");
		startTile = new StartTile(startImage, "Start Tile", 6, "FF1500");
		
		ScreenManager sm = ScreenManager.getInstance();
		sm.addTile(voidTile);
		sm.addTile(groundTile);
		sm.addTile(hardenRockTile);
		sm.addTile(lavaTile);
		sm.addTile(skyTile);
		sm.addTile(finishTile);
		sm.addTile(startTile);
	}
}
