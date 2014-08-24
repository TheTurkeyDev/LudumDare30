package com.turkey.LD30.screens;

import GameAPI.graphics.Background;
import GameAPI.screen.Screen;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Button;
import GameAPI.screen.screenObjects.Interactable;

import com.turkey.LD30.resources.Resources;

public class MainScreen extends Screen
{
	private boolean bg = true;
	private int count = 0;
	private int delay = 20;

	private Background bgOne, bgTwo, bgThree;
	
	private Button startButton, helpButton, levelSelectButton;

	public MainScreen()
	{
		super("Main Screen");

		bgOne = new Background(Resources.msbgOne);
		bgTwo = new Background(Resources.msbgTwo);
		bgThree = new Background(Resources.msbgThree);
		
		startButton = new Button(262, 300, 275, 75, Resources.startButtonImage, "Start Button");
		helpButton = new Button(262, 400, 275, 75, Resources.helpButtonImage, "Help Button");
		levelSelectButton = new Button(262, 500, 275, 75, Resources.levelSelectButtonImage, "Level Select Button"); 
		
		super.addInteractable(startButton);
		super.addInteractable(helpButton);
		super.addInteractable(levelSelectButton);
	}

	public void update()
	{
		count++;
		if(count % delay == 0 && count < 180)
		{
			if(bg)
			{
				super.setBackground(bgOne);
				bg = false;
			}
			else
			{
				super.setBackground(bgTwo);
				bg = true;
			}
		}
		if(count%180 == 0)
		{
			if(count == 180)
			{
				super.setBackground(bgThree);
			}
			else if(count == 360)
			{
				count = 0;
			}
		}
	}
	
	public void onClicked(Interactable clicked)
	{
		if(clicked.getName().equalsIgnoreCase("Start Button"))
		{
			ScreenManager.getInstance().setCurrentScreen("Game Screen");
		}
		else if(clicked.getName().equalsIgnoreCase("Help Button"))
		{
			ScreenManager.getInstance().setCurrentScreen("Help Screen");
		}
		else if(clicked.getName().equalsIgnoreCase("Level Select Button"))
		{
			ScreenManager.getInstance().setCurrentScreen("Level Select Screen");
		}
	}

}
