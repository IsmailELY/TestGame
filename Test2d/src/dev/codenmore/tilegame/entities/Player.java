package dev.codenmore.tilegame.entities;

import java.awt.Graphics;

import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {

	public Player(int x, int y, int health) {
		super(x, y, health);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.p_front,x,y,null);

	}

}
