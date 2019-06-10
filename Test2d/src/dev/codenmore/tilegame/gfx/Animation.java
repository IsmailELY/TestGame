package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation 
{
	private int speed,index;
	private long lastTime,timer;
	private BufferedImage[] frames;
	private BufferedImage StopAnimation;
	private boolean animated = false;

	public BufferedImage StopFrame() 
	{
		return StopAnimation;
	}
	
	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed=speed;
		this.frames=frames;
		index=0;
		lastTime = System.currentTimeMillis();
		timer=0;
		StopAnimation=null;
	}
	
	public Animation(int speed, BufferedImage[] frames, BufferedImage StopAnimation)
	{
		this.speed=speed;
		this.frames=frames;
		index=0;
		lastTime = System.currentTimeMillis();
		timer=0;
		this.StopAnimation=StopAnimation;
	}
	
	public void tick()
	{
		timer+=System.currentTimeMillis()-lastTime;
		lastTime=System.currentTimeMillis();
		
		if(timer>speed)
		{
			index++;
			timer=0;
			if(index>=frames.length-1)
			{
				index=0;
				animated=true;
			}
		}
	}
	
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
	
	public void setIndex(int index) 
	{
		this.index = index;
	}
	
	public boolean isAnimated() 
	{
		return this.animated;
	}
}
