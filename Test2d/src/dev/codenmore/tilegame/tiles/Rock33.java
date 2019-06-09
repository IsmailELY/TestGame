package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Rock33 extends Tile{

	public Rock33(int id)
	{
		super(Assets.rock[8], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
