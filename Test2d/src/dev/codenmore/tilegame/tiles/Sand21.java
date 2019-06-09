package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Sand21 extends Tile{

	public Sand21(int id)
	{
		super(Assets.sand[3], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
