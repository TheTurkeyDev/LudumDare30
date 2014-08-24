package com.turkey.LD30.screens;

import java.awt.event.KeyEvent;

import GameAPI.game.Game;
import GameAPI.graphics.Font;
import GameAPI.graphics.ImageSheet;
import GameAPI.graphics.Text;
import GameAPI.listeners.ScreenKeyListener;
import GameAPI.screen.Screen;
import GameAPI.screen.screenObjects.Tile;
import GameAPI.screen.subscreen.SubScreen;

import com.turkey.LD30.entity.Player;
import com.turkey.LD30.game.Gameclass;
import com.turkey.LD30.resources.Resources;
import com.turkey.LD30.screens.subscreens.PauseSubScreen;

public class GameScreen extends Screen
{
	private Game game;

	private Text level, swaps, swapsBest;

	private Text start1, start2, go, swap, finish;

	private Font font;
	
	private boolean paused = false;
	private SubScreen pausedSS;

	private boolean delay;

	private int count = 0;

	public GameScreen()
	{
		super("Game Screen");

		game = new Gameclass();

		font = new Font(new ImageSheet(Resources.class, "/Fonts/font.png", 256, 96), 16);

		level = new Text(font.getStringImage("Level: " + ((Gameclass)game).getCurrentLevel()), 625, 0);
		swaps = new Text(font.getStringImage("Swaps: " + Gameclass.getNumberOfSwaps()), 0, 0);
		int best = ((Gameclass)game).getLevel().bestSwapsAmmount();
		if(best == 0)
			best = Gameclass.getNumberOfSwaps();
		swapsBest = new Text(font.getStringImage("Best: " + best), 0, 20);
		super.addText(level);
		super.addText(swaps);
		super.addText(swapsBest);

		start1 = new Text(font.getStringImage("This is the starting platform!"), 10, 175);
		start2 = new Text(font.getStringImage("You can switch between worlds on this spot."), 10, 200);

		go = new Text(font.getStringImage("Proceed to the end of the grass."), 50, 175);

		swap = new Text(font.getStringImage("Now hit the space bar to switch worlds!"), 50, 175);

		finish = new Text(font.getStringImage("Now go to the yellow tile to complete the puzzle!"), 10, 175);

		super.addText(start1);
		super.addText(start2);
		super.addText(go);
		super.addText(swap);
		super.addText(finish);
		
		pausedSS = new PauseSubScreen(this);
		super.addSubScreen(pausedSS);
		pausedSS.setVisible(false);
	}

	public void render()
	{
		game.render();
		this.pixels = game.getPixels();
		super.render();
	}

	public void update()
	{
		super.update();
		game.update();
		level.setText(font.getStringImage("Level: " + ((Gameclass)game).getCurrentLevel()));
		swaps.setText(font.getStringImage("Swaps: " + Gameclass.getNumberOfSwaps()));
		int best = ((Gameclass)game).getLevel().bestSwapsAmmount();
		if(best == 0)
			best = Gameclass.getNumberOfSwaps();
		swapsBest.setText(font.getStringImage("Best: " + best));
		Gameclass gc = (Gameclass) game;
		finish.hide();
		start1.hide();
		start2.hide();
		go.hide();
		swap.hide();
		if(gc.getCurrentLevel() == 1)
		{
			int loc = gc.getPlayerLoc().getX()/ Tile.SIZE;

			if(loc == 0)
			{
				start1.show();
				start2.show();
			}
			else if(loc > 0 && loc < 12)
			{
				go.show();
			}
			else if(loc > 11 && loc < 15)
			{
				swap.show();
			}
			else if(loc > 14)
			{
				finish.show();
			}
		}
		
		if(ScreenKeyListener.isKeyPressed(KeyEvent.VK_ESCAPE) && !delay)
		{
			Player p = (Player)((Gameclass)game).getPlayer();
			if(!paused)
			{
				p.stop();
				paused = true;
				pausedSS.setVisible(true);
			}
			else
			{
				p.start();
				paused = false;
				pausedSS.setVisible(false);
			}
			delay = true;
			count = 0;
		}
		if(count < 20)
		{
			count++;
		}
		else if(delay)
		{
			delay = false;
		}
	}

	public Game getGame()
	{
		return game;
	}
	
	public void unpause()
	{
		((Player)((Gameclass)game).getPlayer()).start();
		paused = false;
		pausedSS.setVisible(false);
	}
}
