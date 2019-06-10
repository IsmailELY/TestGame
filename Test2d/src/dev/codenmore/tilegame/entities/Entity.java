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
	protected int health;
	protected boolean active= true;
	
	
	public Entity(Handler handler,float x,float y,int width, int height,int health)
	{
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.handler=handler;
		this.health = health;

		bounds = new Rectangle(0,0,width,height);
	}
	
	abstract public void tick();
	
	abstract public void render(Graphics g);

	public Rectangle getCollisionBounds(double xOffset,double yOffset)
	{
		return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y +yOffset), bounds.width, bounds.height);
	}
	
	public boolean checkEntityCollisions(double xOffset,double yOffset)
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
	
	abstract public void die();
	
	public void hurt(int damage)
	{
		this.health-=damage;
		if(health<=0)
		{
			active = false;
			die();
		}
	}
	
	//Getters n Setters
	public float getX() 
	{
		return x;
		
	}

	public void setX(float x) 
	{
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}
