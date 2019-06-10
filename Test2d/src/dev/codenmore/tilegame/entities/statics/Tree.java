package dev.codenmore.tilegame.entities.statics;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;

public class Tree extends StaticEntity 
{

	public Tree(Handler handler, float x, float y) 
	{
		super(handler, x, y,4*Tile.TILEWIDTH,4*Tile.TILEHEIGHT);
		
		bounds.x=width/4;
		bounds.width=width/2;
		bounds.y=2*height/3;
		bounds.height=height/4;
		this.health = 200;
	}

	@Override
	public void tick() 
	{
		
	}

	@Override
	public void render(Graphics g) 
	{
		if(active)
			g.drawImage(Assets.tree,(int)(x- handler.getGameCamera().getxOffset()),(int)(y- handler.getGameCamera().getyOffset()),width,height,null);
		else
			g.drawImage(Assets.dead_tree,(int)(x- handler.getGameCamera().getxOffset()),(int)(y- handler.getGameCamera().getyOffset()),width,height,null);
	}

	@Override
	public void die() 
	{
		
	}

}
