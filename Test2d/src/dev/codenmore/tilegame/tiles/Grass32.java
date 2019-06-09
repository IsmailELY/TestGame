package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Grass32 extends Tile{

	public Grass32( int id) 
	{
		super(Assets.grass[7], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
