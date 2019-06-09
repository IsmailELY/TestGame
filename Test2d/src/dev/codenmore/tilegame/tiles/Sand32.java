package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Sand32 extends Tile{

	public Sand32(int id)
	{
		super(Assets.sand[7], id);
	}
	@Override
	public boolean isSolide()
	{
		return true;
	}
}
