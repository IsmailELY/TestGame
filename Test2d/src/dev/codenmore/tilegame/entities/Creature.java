package dev.codenmore.tilegame.entities;

public abstract class Creature extends Entity 
{
	protected int health;
	
	public Creature(int x, int y,int health) 
	{
		super(x, y);
		this.health = health;
	}
}
