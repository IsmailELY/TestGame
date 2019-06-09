package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Ice31 extends Tile{

	public Ice31(int id) {
		super(Assets.ice[6], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
