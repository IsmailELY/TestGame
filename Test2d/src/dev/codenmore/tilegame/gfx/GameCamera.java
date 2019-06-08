package dev.codenmore.tilegame.gfx;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.Entity;

public class GameCamera 
{
	private float xOffset,yOffset;
	private Game game;
	
	public float getxOffset() {
		return xOffset;
	}
	
	public void move(float xAmt,float yAmt)
	{
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	public void centerEntity(Entity e)
	{
		xOffset = e.getX() - game.getWidth()/2 + e.getWidth()/2;
		yOffset = e.getY() - game.getHeight()/2 + e.getHeight()/2;
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

	public GameCamera(Game game,float xOffset,float yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.game=game;
	}
}
