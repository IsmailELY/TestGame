package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	//STATIC
	public static Tile[] tiles= new Tile[256];
	//grass
	public static Tile Grass11 = new Grass11(1);
	public static Tile Grass12 = new Grass12(2);
	public static Tile Grass13 = new Grass13(3);
	public static Tile Grass21 = new Grass21(4);
	public static Tile Grass22 = new Grass22(5);
	public static Tile Grass23 = new Grass23(6);
	public static Tile Grass31 = new Grass31(7);
	public static Tile Grass32 = new Grass32(8);
	public static Tile Grass33 = new Grass33(9);
	//ice
	public static Tile Ice11 = new Ice11(11);
	public static Tile Ice12 = new Ice12(12);
	public static Tile Ice13 = new Ice13(13);
	public static Tile Ice21 = new Ice21(14);
	public static Tile Ice22 = new Ice22(15);
	public static Tile Ice23 = new Ice23(16);
	public static Tile Ice31 = new Ice31(17);
	public static Tile Ice32 = new Ice32(18);
	public static Tile Ice33 = new Ice33(19);
	//sand
	public static Tile Sand11 = new Sand11(21);
	public static Tile Sand12 = new Sand12(22);
	public static Tile Sand13 = new Sand13(23);
	public static Tile Sand21 = new Sand21(24);
	public static Tile Sand22 = new Sand22(25);
	public static Tile Sand23 = new Sand23(26);
	public static Tile Sand31 = new Sand31(27);
	public static Tile Sand32 = new Sand32(28);
	public static Tile Sand33 = new Sand33(29);
	//magma
	public static Tile Magma11 = new Magma11(31);
	public static Tile Magma12 = new Magma12(32);
	public static Tile Magma13 = new Magma13(33);
	public static Tile Magma21 = new Magma21(34);
	public static Tile Magma22 = new Magma22(35);
	public static Tile Magma23 = new Magma23(36);
	public static Tile Magma31 = new Magma31(37);
	public static Tile Magma32 = new Magma32(38);
	public static Tile Magma33 = new Magma33(39);
	//rock
	public static Tile Rock11 = new Rock11(41);
	public static Tile Rock12 = new Rock12(42);
	public static Tile Rock13 = new Rock13(43);
	public static Tile Rock21 = new Rock21(44);
	public static Tile Rock22 = new Rock22(45);
	public static Tile Rock23 = new Rock23(46);
	public static Tile Rock31 = new Rock31(47);
	public static Tile Rock32 = new Rock32(48);
	public static Tile Rock33 = new Rock33(49);
	
	//CLASS
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
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
