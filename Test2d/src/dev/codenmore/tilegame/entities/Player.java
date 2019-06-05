package dev.codenmore.tilegame.entities;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {
	
	private Game game;
	
	public Player(Game game, int x, int y, int health) {
		super(x, y, health);
		this.game = game;
	}

	@Override
	public void tick() 
	{
		if(game.getKeyManager().up)
		{
			if (y>=0)
				y-=2;
		}
		else if (game.getKeyManager().down)
		{
			if (y<=game.height-Assets.p_height)
				y+=2;
		}
		else if (game.getKeyManager().left)
		{
			if (x>=0)
				x-=2;
		}
		else if (game.getKeyManager().right)
		{
			if (x<=game.width-Assets.p_width)
				x+=2;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.p_front,x,y,null);

	}
	

}
