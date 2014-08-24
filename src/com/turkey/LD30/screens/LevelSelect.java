package com.turkey.LD30.screens;

import java.awt.event.KeyEvent;

import com.turkey.LD30.game.Gameclass;
import com.turkey.LD30.resources.Resources;

import GameAPI.graphics.Background;
import GameAPI.listeners.ScreenKeyListener;
import GameAPI.screen.Screen;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Button;
import GameAPI.screen.screenObjects.Interactable;

public class LevelSelect extends Screen
{

	private Background bg;

	private Button rtm;

	public LevelSelect()
	{
		super("Level Select Screen");

		bg = new Background(Resources.lsbg);

		super.setBackground(bg);

		rtm = new Button(265, 100, 275, 75, Resources.mainmenuButtonImage, "Main Menu Button");
	}


	public void loadScreen()
	{
		super.clearInteractables();
		super.addInteractable(rtm);
		int high = Gameclass.gethighestLevel();
		for(int y = 0; y < 5; y++)
		{
			for(int x = 0; x < 5; x++)
			{
				int pos = (5 * y + x);
				if(pos + 1 > high)
				{
					super.addInteractable(new Button(80 + (x * 144), 202 + (y * 90) , 64, 64, Resources.crossout, "Cross out " + pos));
				}
				super.addInteractable(new Button(80 + (x * 144), 202 + (y * 90) , 64, 64, null, "level select " + (pos + 1)));
			}
		}
	}

	public void onClicked(Interactable i)
	{
		String[] cont = i.getName().split(" ");
		if(cont[0].equalsIgnoreCase("level"))
		{
			int l = Integer.parseInt(cont[2]);
			if(l <= Gameclass.gethighestLevel())
			{
				GameScreen gs = (GameScreen) ScreenManager.getInstance().getScreen("Game Screen");
				((Gameclass)gs.getGame()).clearGame();
				((Gameclass)gs.getGame()).load(l);
				ScreenManager.getInstance().setCurrentScreen(gs);
			}
		}
		else if(i.getName().equalsIgnoreCase("Main Menu Button"))
		{
			ScreenManager.getInstance().setCurrentScreen("Main Screen");
		}
	}

	public void update()
	{
		if(ScreenKeyListener.isKeyPressed(KeyEvent.VK_SHIFT))
		{
			GameScreen gs = (GameScreen) ScreenManager.getInstance().getScreen("Game Screen");
			Gameclass gc = (Gameclass)gs.getGame();
			gc.setheighest(Gameclass.getNumberOfLevels());
			loadScreen();
		}
	}

}
