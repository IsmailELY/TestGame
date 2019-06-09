package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Grass33 extends Tile{

	public Grass33( int id) 
	{
		super(Assets.grass[8], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
