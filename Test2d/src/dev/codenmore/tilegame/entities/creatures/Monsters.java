package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import dev.codenmore.tilegame.Handler;

abstract public class Monsters extends Creature 
{
	protected int step,timer,death;
	protected boolean stop = true;
	protected Rectangle store_bounds;
	public static final int DEFAULT_TIMER = 100;
	
	public Monsters(Handler handler, float x, float y, int width, int height, int health) 
	{
		super(handler, x, y, width, height, health);
		this.store_bounds = null;
		this.step=0;
		this.death=0;
		this.timer=DEFAULT_TIMER;
		this.speed = DEFAULT_SPEED/3;
	}
	
	public void aleatoryMove()
	{
		Random random=new Random();
		int var=(random.nextInt(4)-2);
		
		if(Math.abs(var)!=1)
			yMove = ((int)(random.nextFloat()*3.8-1.9))*speed;
		else
			xMove = ((int)(random.nextFloat()*3.8-1.9))*speed;
	}
	
	public void move()
	{
		if(active)
		{
			super.move();
			
			if(step>timer)
			{
				step=0;
				if(stop)
				{
					xMove=0;
					yMove=0;
					stop=false;
				}
				else
				{
					aleatoryMove();
					stop=true;
				}
				return;
			}
			step++;
		}
	}
	
	abstract void deathAnimation(Graphics g);
	
}
