package com.joey.tank.beans.obstacle;

import com.joey.tank.constant.Constant;

public class Nothing extends Obstacle {

	public Nothing(int x, int y) {

		super(x, y);
		this.color = Constant.Scene.SCENE_COLOR;
		this.isPass = true;
		this.isBulletPass = true;

	}

	public void bulletAction() {
		// TODO Auto-generated method stub

	}

}
