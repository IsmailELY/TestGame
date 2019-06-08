package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class LakeTile extends Tile
{

	public LakeTile(int id) 
	{
		super(Assets.lake, id);
	}
		
	@Override
	public boolean isSolide()
	{
		return true;
	}

}