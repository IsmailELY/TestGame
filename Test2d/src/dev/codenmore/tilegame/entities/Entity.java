package dev.codenmore.tilegame.entities;

import java.awt.Graphics;

public abstract class Entity 
{
	protected int x,y;
	
	public Entity(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	abstract public void tick();
	
	abstract public void render(Graphics g);
	
}
