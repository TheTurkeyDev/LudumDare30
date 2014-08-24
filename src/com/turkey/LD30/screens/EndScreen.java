package com.turkey.LD30.screens;

import com.turkey.LD30.game.Gameclass;
import com.turkey.LD30.resources.Resources;

import GameAPI.graphics.Background;
import GameAPI.screen.Screen;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Button;
import GameAPI.screen.screenObjects.Interactable;

public class EndScreen extends Screen
{
	private Background bgOne,bgTwo;

	private Button restartButton, mainmenuButton;

	private GameScreen gs;

	public EndScreen()
	{
		super("End Screen");

		bgOne = new Background(Resources.esbgOne);
		bgTwo = new Background(Resources.esbgTwo);

		restartButton = new Button(262, 400, 275, 75, Resources.retryButtonImage, "Retry Button");
		mainmenuButton = new Button(262, 500, 275, 75, Resources.mainmenuButtonImage, "MainMenu Button");

		super.addInteractable(restartButton);
		super.addInteractable(mainmenuButton);
	}

	public void loadScreen()
	{
		gs = (GameScreen) ScreenManager.getInstance().getScreen("Game Screen");
		Gameclass gc = (Gameclass)gs.getGame();
		if(gc.getCurrentLevel() > Gameclass.getNumberOfLevels())
		{
			super.setBackground(bgTwo);
		}
		else
		{
			super.setBackground(bgOne);
		}
	}

	public void onClicked(Interactable i)
	{
		if(i.getName().equalsIgnoreCase("Retry Button"))
		{

			if(Gameclass.wasLevelSelected())
			{
				int l = ((Gameclass)gs.getGame()).getCurrentLevel();
				gs.getGame().clearGame();
				((Gameclass)gs.getGame()).load(l);
			}
			else
			{
				gs.getGame().clearGame();
				((Gameclass)gs.getGame()).load(1);
			}
			ScreenManager.getInstance().setCurrentScreen(gs);
		}
		else if(i.getName().equalsIgnoreCase("MainMenu Button"))
		{
			gs.getGame().clearGame();
			((Gameclass)gs.getGame()).load(1);
			ScreenManager.getInstance().setCurrentScreen("Main Screen");
		}
	}


}
