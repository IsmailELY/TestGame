package dev.codenmore.tilegame.entities;

public abstract class Creature extends Entity 
{
	public static final int DEFAULT_HEALTH = 10, DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;
	public static final float DEFAULT_SPEED = 3.0f;
	
	
	protected int health;
	protected float speed;
	protected float xMove,yMove;
	
	public Creature(float x, float y,int width, int height,int health) 
	{
		super(x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move()
	{
		x+=xMove;
		y+=yMove;
	}

	//Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
