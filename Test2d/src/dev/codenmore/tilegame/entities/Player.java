package dev.codenmore.tilegame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {
	
	private boolean face = true;
	
	private Animation animDown,animUp,animLeft,animRight;
	private BufferedImage StopAnimation;
	
	public Player(Handler handler,float x, float y, int health) {
		super(handler,x, y,Creature.DEFAULT_WIDTH*2,DEFAULT_HEIGHT*2, health);
		this.bounds.y=3*height/4;
		this.bounds.height=height/32;
		this.bounds.x=width/4;
		this.bounds.width=1*width/4;
		
		animUp = new Animation(180, Assets.player_form[0]);
		animRight = new Animation(180, Assets.player_form[1]);
		animDown = new Animation(180, Assets.player_form[2]);
		animLeft = new Animation(180, Assets.player_form[3]);
		
		StopAnimation = animDown.StopFrame();	
	}

	@Override
	public void tick() 
	{
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		getInput();
		move();
		handler.getGameCamera().centerEntity(this);
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		if (handler.getKeyManager().up && (y+bounds.y)>0)
		{
			face = false;
			yMove = -speed;
		}	
		else if (handler.getKeyManager().down && (y+bounds.y+bounds.height)<=handler.getWorld().getHeight())
		{
			face = true;
			yMove = +speed;
		}	
		else if (handler.getKeyManager().left && (x+bounds.x)>0)
			xMove = -speed;
		else if (handler.getKeyManager().right && (x+bounds.x+bounds.width)<=handler.getWorld().getWidth())
			xMove = +speed;
	}

	private BufferedImage getCurrentAnimationFrame()
	{		
		if(xMove<0)
		{
			animRight.setIndex(0);
			animDown.setIndex(0);
			animUp.setIndex(0);
			StopAnimation=animLeft.StopFrame();
			return animLeft.getCurrentFrame();
		}
		else if(xMove>0)
		{
			animLeft.setIndex(0);
			animDown.setIndex(0);
			animUp.setIndex(0);
			StopAnimation=animRight.StopFrame();
			return animRight.getCurrentFrame();
		}
		if(yMove<0)
		{
			animDown.setIndex(0);
			animLeft.setIndex(0);
			animRight.setIndex(0);
			StopAnimation=animUp.StopFrame();
			return animUp.getCurrentFrame();
		}
		else if(yMove>0)
		{
			animLeft.setIndex(0);
			animRight.setIndex(0);
			animUp.setIndex(0);
			StopAnimation=animDown.StopFrame();
			return animDown.getCurrentFrame();
		}
		return StopAnimation;
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimationFrame(),(int)(x - handler.getGameCamera().getxOffset()),(int)(y- handler.getGameCamera().getyOffset()),width,height,null);
	}
	
}
