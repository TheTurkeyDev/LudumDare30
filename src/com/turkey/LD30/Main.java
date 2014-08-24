package com.turkey.LD30;

import javax.swing.JFrame;

import GameAPI.main.GameAPI;
import GameAPI.screen.Screen;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Tile;

import com.turkey.LD30.resources.Resources;
import com.turkey.LD30.screens.EndScreen;
import com.turkey.LD30.screens.GameScreen;
import com.turkey.LD30.screens.HelpScreen;
import com.turkey.LD30.screens.LevelSelect;
import com.turkey.LD30.screens.MainScreen;

public class Main extends JFrame
{	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		new Main().start();
	}
	
	public void start()
	{
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(800, 640);
		super.setLocationRelativeTo(null);
		GameAPI api = new GameAPI("Ludum Dare 30", 800, 640, 0, this);
		
		loadResources();
		loadScreens();
		
		super.add(api);
		super.setVisible(true);
		api.start();
		api.renderMapOnce();
	}

	private void loadResources()
	{
		Tile.setTileSize(32);
		new Resources().loadResources();
	}
	
	private void loadScreens()
	{
		ScreenManager sm = ScreenManager.getInstance();
		
		Screen mainScreen = new MainScreen();
		Screen gameScreen = new GameScreen();
		Screen endScreen = new EndScreen();
		Screen helpScreen = new HelpScreen();
		Screen levelSelectScreen = new LevelSelect();
		
		sm.addScreen(mainScreen);
		sm.addScreen(gameScreen);
		sm.addScreen(endScreen);
		sm.addScreen(helpScreen);
		sm.addScreen(levelSelectScreen);
		
		sm.setCurrentScreen(mainScreen);
	}
	
	
}
