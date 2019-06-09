package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Sand31 extends Tile{

	public Sand31(int id)
	{
		super(Assets.sand[6], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
