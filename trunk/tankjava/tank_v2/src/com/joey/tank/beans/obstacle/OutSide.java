package com.joey.tank.beans.obstacle;

public class OutSide extends Obstacle {

	public OutSide(int x, int y) {
		super(x, y);
		this.isPass = false;
		this.isBulletPass = false;
	}

	@Override
	public void bulletAction() {
		// Do Nothing
	}

}
