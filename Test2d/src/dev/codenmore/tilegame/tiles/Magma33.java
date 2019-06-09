package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Magma33 extends Tile{

	public Magma33(int id)
	{
		super(Assets.magma[8], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
