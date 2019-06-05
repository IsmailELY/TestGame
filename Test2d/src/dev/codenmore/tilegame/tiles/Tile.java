package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	//STATIC
	public static Tile[] tiles= new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile cliffTile = new CliffTile(1);
	public static Tile sandTile = new SandTile(2);
	
	//CLASS
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture,int id)
	{
		this.texture=texture;
		this.id=id;
		
		tiles[id] = this;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g,int x, int y)
	{
		g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
	}
	
	public int getid()
	{
		return this.id;
	}
	
	public boolean isSolide()
	{
		return false;
	}
}
