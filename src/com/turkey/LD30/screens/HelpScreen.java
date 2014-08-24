package com.turkey.LD30.screens;

import GameAPI.graphics.Background;
import GameAPI.screen.Screen;
import GameAPI.screen.ScreenManager;
import GameAPI.screen.screenObjects.Button;
import GameAPI.screen.screenObjects.Interactable;

import com.turkey.LD30.resources.Resources;

public class HelpScreen extends Screen
{
	private Background bg;
	
	private Button mainmenuButton;
	
	public HelpScreen()
	{
		super("Help Screen");
		
		bg = new Background(Resources.hsbg);	
		super.setBackground(bg);
		
		mainmenuButton = new Button(262, 550, 275, 75, Resources.mainmenuButtonImage, "MainMenu Button");
		
		super.addInteractable(mainmenuButton);
	}
	
	public void onClicked(Interactable i)
	{
		if(i.getName().equalsIgnoreCase("MainMenu Button"))
		{
			ScreenManager.getInstance().setCurrentScreen("Main Screen");
		}
	}
	

}
