package dev.codenmore.tilegame.entities;

import java.awt.Graphics;

public abstract class Entity 
{
	protected int height,width;
	protected float x,y;
	
	public Entity(float x,float y,int width, int height)
	{
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
	
	abstract public void tick();
	
	abstract public void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
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
