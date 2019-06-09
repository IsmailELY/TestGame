package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Magma31 extends Tile{

	public Magma31(int id)
	{
		super(Assets.magma[6], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
