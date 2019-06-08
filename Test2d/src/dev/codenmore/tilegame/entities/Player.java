package dev.codenmore.tilegame.entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {
	
	private boolean face = true;
	
	public Player(Handler handler,float x, float y, int health) {
		super(handler,x, y,Creature.DEFAULT_WIDTH,57, health);
		this.bounds.y=3*height/4;
		this.bounds.height=height/4;
		this.bounds.x=2;
		this.bounds.width=width-3;
		
	}

	@Override
	public void tick() 
	{
		getInput();
		move();
		handler.getGameCamera().centerEntity(this);
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		if (handler.getKeyManager().up && y>=0)
		{
			face = false;
			yMove = -speed;
		}	
		else if (handler.getKeyManager().down && y<=handler.getWorld().getHeight()-this.height)
		{
			face = true;
			yMove = +speed;
		}	
		else if (handler.getKeyManager().left && x>=0)
			xMove = -speed;
		else if (handler.getKeyManager().right && x<=handler.getWorld().getWidth()-this.width)
			xMove = +speed;
	}

	@Override
	public void render(Graphics g) 
	{
		if (face)
			g.drawImage(Assets.p_front,(int)(x - handler.getGameCamera().getxOffset()),(int)(y- handler.getGameCamera().getyOffset()),width,57,null);
		else
			g.drawImage(Assets.p_back,(int)(x - handler.getGameCamera().getxOffset()),(int)(y- handler.getGameCamera().getyOffset()),width,57,null);
	}
	
}
