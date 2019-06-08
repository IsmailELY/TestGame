package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;

import dev.codenmore.tilegame.utils.*;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.tiles.Tile;

public class World 
{
	private int width,height;
	private float SpawnX,SpawnY;
	private int[][] tiles;
	private Handler handler;
	
	public int getWidth() {
		return width*Tile.TILEWIDTH;
	}

	public int getHeight() {
		return height*Tile.TILEHEIGHT;
	}

	public float getSpawnX() 
	{
		return SpawnX;
	}

	public float getSpawnY() 
	{
		return SpawnY;
	}
	
	public World(Handler handler,String path)
	{
		loadWorld(path);
		this.handler=handler;
	}
	
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens=file.split("\\s+");
		
		this.width = Utils.parseInt(tokens[0]);
		this.height = Utils.parseInt(tokens[1]);
		this.SpawnX = Utils.parseFloat(tokens[2]);
		this.SpawnY = Utils.parseFloat(tokens[3]);
		
		tiles = new int[width][height];
		for (int y=0; y<height; y++)
		{
			for (int x=0; x<width; x++)
			{
				tiles[x][y] = Utils.parseInt(tokens[4+x+y*width]);
			}
		}
	}
	
	public Tile getTile(int x,int y)
	{
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.cliffTile;
		return t;
	}
	
	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		int xStart=Math.max(0,(int)handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int yStart=Math.max(0,(int)handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
		int xEnd=Math.min(width,(handler.getWidth()+(int)handler.getGameCamera().getxOffset())/Tile.TILEWIDTH+2);
		int yEnd=Math.min(height,(handler.getHeight()+(int)handler.getGameCamera().getyOffset())/Tile.TILEHEIGHT+2);
		
		for (int y=yStart; y<yEnd; y++)
		{
			for (int x=xStart; x<xEnd; x++)
			{
				getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int)( y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
}
