package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation 
{
	private int speed,index;
	private long lastTime,timer;
	private BufferedImage[] frames;

	public void setIndex(int index) {
		this.index = index;
	}

	public BufferedImage StopFrame() 
	{
		return frames[frames.length-1];
	}
	
	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed=speed;
		this.frames=frames;
		index=0;
		lastTime = System.currentTimeMillis();
		timer=0;
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
				index=0;
		}
	}
	
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
}
