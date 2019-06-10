package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;

import dev.codenmore.tilegame.utils.*;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.creatures.Gobelin;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.statics.Tree;
import dev.codenmore.tilegame.tiles.Tile;

public class World 
{
	private int width,height;
	private int[][] tiles;
	private Handler handler;
	//Entities
	private EntityManager entityManager;
	
	public World(Handler handler,String path)
	{
		entityManager= new EntityManager(handler,new Player(handler, 0,0,100));
		entityManager.addEntity(new Tree(handler, 200, 300));
		entityManager.addEntity(new Tree(handler, 800, 150));
		entityManager.addEntity(new Gobelin(handler,700,300,200));
		
		loadWorld(path);
		this.handler=handler;
	}
	
	
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens=file.split("\\s+");
		
		this.width = Utils.parseInt(tokens[0]);
		this.height = Utils.parseInt(tokens[1]);
		entityManager.getPlayer().setX(Utils.parseFloat(tokens[2])*32);
		entityManager.getPlayer().setY(Utils.parseFloat(tokens[3])*32);
		
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
		if (x<0 || y<0 || x>=width || y>=height)
			return Tile.Grass22;
		
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.Rock22;
		return t;
	}
	
	public void tick()
	{
		entityManager.tick();
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
		entityManager.render(g);
	}
	
	//Getters
	public int getWidth() {
		return width*Tile.TILEWIDTH;
	}
	
	public int getHeight() {
		return height*Tile.TILEHEIGHT;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
