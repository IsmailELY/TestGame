package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Grass31 extends Tile{

	public Grass31( int id) 
	{
		super(Assets.grass[6], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
