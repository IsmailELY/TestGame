package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

public class Gobelin extends Monsters 
{
	private Animation[] anim = new Animation [4];
	private BufferedImage StopAnimation;

	public Gobelin(Handler handler, float x, float y, int health) 
	{
		super(handler,x, y,Creature.DEFAULT_WIDTH*2,DEFAULT_HEIGHT*2, health);
		this.bounds.y=3*height/4;
		this.bounds.height=height/4;
		this.bounds.x=width/4;
		this.bounds.width=width/3+3;
		this.store_bounds = bounds;
		
		for (int i=0; i<4;i++)
		{
			anim[i] = new Animation(180, Assets.gobelin_form[i],Assets.gobelin_stop[i]);
		}
		
		StopAnimation = anim[body].StopFrame();		
	}

	@Override
	public void tick() 
	{
		//Animation
		for(Animation a : anim)
		{
			a.tick();
		}
		move();
	}

	@Override
	public void render(Graphics g) 
	{
		if(active)
		{
			bounds = store_bounds;
			g.drawImage(getCurrentAnimationFrame(),(int)(x - handler.getGameCamera().getxOffset()),(int)(y- handler.getGameCamera().getyOffset()),width,height,null);
		}
		else if(death<timer)
		{
			deathAnimation(g);
			this.bounds = new Rectangle();
			death++;
		}
		else if(death<15*timer)
			death++;
		else
		{
			death=0;
			active=true;
		}
	}

	private BufferedImage getCurrentAnimationFrame()
	{	
		if(xMove!=0 || yMove!=0)
		{
			if(xMove<0) 
				body=2; //left
			else if(xMove>0)
				body=3; //right
			if(yMove<0)
				body=1; //up
			else if(yMove>0)
				body=0; //down
			
			for(int i=0; i<4; i++)
			{
				if(i==body)
				{
					StopAnimation = anim[i].StopFrame();
					continue;
				}
				anim[i].setIndex(0);
			}
			return anim[body].getCurrentFrame();
		}
		return StopAnimation;
	}

	@Override
	public void die() 
	{
		
	}

	@Override
	void deathAnimation(Graphics g) 
	{
		g.drawImage(Assets.dead_gobelin[body],(int)(x - handler.getGameCamera().getxOffset()),(int)(y- handler.getGameCamera().getyOffset()),width,height,null);
	}
}
