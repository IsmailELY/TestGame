package dev.codenmore.tilegame.entities;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {
	
	private Game game;
	private boolean face = true;
	
	public Player(Game game,float x, float y, int health) {
		super(x, y,Creature.DEFAULT_WIDTH,48, health);
		this.game = game;
	}

	@Override
	public void tick() 
	{
		getInput();
		move();
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		if (game.getKeyManager().up && y>=0)
		{
			face = false;
			yMove = -speed;
		}	
		else if (game.getKeyManager().down && y<=game.height-this.height)
		{
			face = true;
			yMove = +speed;
		}	
		else if (game.getKeyManager().left && x>=0)
			xMove = -speed;
		else if (game.getKeyManager().right && x<=game.width-this.width)
			xMove = +speed;
	}

	@Override
	public void render(Graphics g) {
		if (face)
			g.drawImage(Assets.p_front,(int)x,(int)y,width,height,null);
		else
			g.drawImage(Assets.p_back,(int)x,(int)y,width,height,null);
	}
	

}
