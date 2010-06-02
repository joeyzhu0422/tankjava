package com.joey.game.sprite;

public class SpriteFactory {

	public static Tank createMainTank() {
		return new Tank("images/tank.gif", 40, 40, 9, 22, 1);
	}

	public static Tank createSubTank() {
		return new Tank("images/tank.gif", 40, 40, 20, 22, 1);
	}
}
