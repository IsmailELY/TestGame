package dev.codenmore.tilegame;

public class Launcher 
{
	public static void main(String [] args)
	{
		Game game = new Game("game title", 680, 400);
		game.start();
	}
}
