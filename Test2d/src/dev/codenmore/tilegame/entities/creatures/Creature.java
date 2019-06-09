package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tiles.Tile;

public abstract class Creature extends Entity 
{
	public static final int DEFAULT_HEALTH = 10, DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 66;
	public static final float DEFAULT_SPEED = 3.0f;
	
	
	protected int health;
	protected float speed;
	protected float xMove,yMove;
	
	public Creature(Handler handler,float x, float y,int width, int height,int health) 
	{
		super(handler,x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move()
	{
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}

	public void moveX()
	{
		if(xMove>0) //move right
		{
			int tx = (int)(x + bounds.x + xMove + bounds.width)/Tile.TILEWIDTH;
			if(!CollisionWithTile(tx, (int)(y+bounds.y)/Tile.TILEHEIGHT) && !CollisionWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
				x+=xMove;
			else
			{
				x=tx*Tile.TILEWIDTH-bounds.x-bounds.width-1;
			}
		}
		else if(xMove<0) //move left	
		{
			int tx = (int)(x + bounds.x + xMove )/Tile.TILEWIDTH;
			if(!CollisionWithTile(tx, (int)(y+bounds.y)/Tile.TILEHEIGHT) && !CollisionWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
				x+=xMove;
			else
			{
				x=tx*Tile.TILEWIDTH+Tile.TILEWIDTH-bounds.x+1;
			}
		}
		
	}
	
	public void moveY()
	{
		if (yMove<0)
		{
			int ty = (int)(y + bounds.y + yMove )/Tile.TILEHEIGHT;
			if(!CollisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty) && !CollisionWithTile((int)(x+bounds.x + bounds.width)/Tile.TILEWIDTH,ty))
				y+=yMove;
			else
			{
				y=ty*Tile.TILEHEIGHT+Tile.TILEHEIGHT-bounds.y+1;
			}
		}
		else if(yMove>0)
		{
			int ty = (int)(y + bounds.y + yMove + bounds.height)/Tile.TILEHEIGHT;
			if(!CollisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty) && !CollisionWithTile((int)(x+bounds.x + bounds.width)/Tile.TILEWIDTH,ty))
				y+=yMove;
			else
			{
				y=ty*Tile.TILEHEIGHT-bounds.y-bounds.height-1;
			}
		}
	}
	
	protected boolean CollisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolide();
	}
	//Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) 
	{
		this.health = health;
	}

	public float getSpeed() 
	{
		return speed;
	}

	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}
}
