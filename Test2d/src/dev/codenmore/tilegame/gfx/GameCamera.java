package dev.codenmore.tilegame.gfx;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;

public class GameCamera 
{
	private float xOffset,yOffset;
	private Handler handler;
	
	public float getxOffset() {
		return xOffset;
	}
	
	public void move(float xAmt,float yAmt)
	{
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public void checkBlankSpace()
	{
		if(xOffset<0)
		{
			xOffset=0;
		}
		else if(xOffset>handler.getWorld().getWidth()-handler.getWidth())
		{
			xOffset=handler.getWorld().getWidth()-handler.getWidth();
		}
		
		if(yOffset<0)
		{
			yOffset=0;
		}
		else if(yOffset>handler.getWorld().getHeight()-handler.getHeight())
		{
			yOffset=handler.getWorld().getHeight()-handler.getHeight();
		}
	}
	public void centerEntity(Entity e)
	{
		xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
		checkBlankSpace();
	}
	//GETTERS SETTERS
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public GameCamera(Handler handler,float xOffset,float yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.handler=handler;
	}
}
