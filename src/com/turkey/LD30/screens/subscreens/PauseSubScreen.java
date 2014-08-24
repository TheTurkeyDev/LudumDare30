package com.turkey.LD30.screens.subscreens;

import GameAPI.graphics.Background;
import GameAPI.main.GameAPI;
import GameAPI.screen.Screen;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Button;
import GameAPI.screen.screenObjects.Interactable;
import GameAPI.screen.subscreen.SubScreen;

import com.turkey.LD30.game.Gameclass;
import com.turkey.LD30.resources.Resources;
import com.turkey.LD30.screens.GameScreen;

public class PauseSubScreen extends SubScreen
{

	public PauseSubScreen(Screen p)
	{
		super((GameAPI.width/2) - 200, (GameAPI.height/2) - 200, "Pause Menu", p, new Background(Resources.pauseSubScreenImage));
		
		super.addIneteractable(new Button( 62, 100, 275, 75, Resources.continueButtonImage, "Continue Button"));
		super.addIneteractable(new Button( 62, 200, 275, 75, Resources.restartButtonImage, "Restart Button"));
		super.addIneteractable(new Button( 62, 300, 275, 75, Resources.mainmenuButtonImage, "MainMenu Button"));
	}
	
	public void onClicked(Interactable i)
	{
		if(i.getName().equalsIgnoreCase("Continue Button"))
		{
			((GameScreen)super.parent).unpause();
		}
		else if(i.getName().equalsIgnoreCase("Restart Button"))
		{
			Gameclass gc = (Gameclass)((GameScreen)super.parent).getGame();
			int cl = gc.getCurrentLevel();
			gc.clearGame();
			gc.load(cl);
			((GameScreen)super.parent).unpause();
		}
		else if(i.getName().equalsIgnoreCase("MainMenu Button"))
		{
			Gameclass gc = (Gameclass)((GameScreen)super.parent).getGame();
			gc.clearGame();
			gc.load(1);
			((GameScreen)super.parent).unpause();
			ScreenManager.getInstance().setCurrentScreen("Main Screen");
		}
	}

}
