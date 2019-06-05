package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class CliffTile extends Tile
{

	public CliffTile( int id) 
	{
		super(Assets.cliff, id);
	}
	
	@Override
	public boolean isSolide()
	{
		return true;
	}

}
