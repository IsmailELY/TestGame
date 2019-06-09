package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Ice21 extends Tile{

	public Ice21(int id) {
		super(Assets.ice[3], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
