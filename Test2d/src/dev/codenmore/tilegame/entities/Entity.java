package dev.codenmore.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.codenmore.tilegame.Handler;

public abstract class Entity 
{
	protected int height,width;
	protected float x,y;
	protected Handler handler;
	protected Rectangle bounds;
	
	public Entity(Handler handler,float x,float y,int width, int height)
	{
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.handler=handler;
		
		bounds = new Rectangle(0,0,width,height);
	}
	
	abstract public void tick();
	
	abstract public void render(Graphics g);

	public Rectangle getCollisionBounds(float xOffset,float yOffset)
	{
		return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y +yOffset), bounds.width, bounds.height);
	}
	
	public boolean checkEntityCollisions(float xOffset,float yOffset)
	{
		for(Entity e: handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this))
				continue;
			
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
			{
				return true;
			}
		}
		return false;
	}
	
	//Getters n Setters
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
}
