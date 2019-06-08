package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Grass_2 extends Tile {

	public Grass_2( int id) 
	{
		super(Assets.grass_2, id);
	}
	
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
