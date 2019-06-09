package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Sand33 extends Tile{

	public Sand33(int id)
	{
		super(Assets.sand[8], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
