package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Ice32 extends Tile{

	public Ice32(int id) {
		super(Assets.ice[7], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
