package com.joey.tank.beans.obstacle;

import java.awt.Color;

import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;
import com.joey.tank.util.MapUtil;

public class Brick extends Obstacle {

	public Brick(int x, int y) {

		super(x, y);
		this.color = new Color(190, 80, 11);
		this.isPass = false;
		this.isBulletPass = false;

	}

	public void bulletAction() {

		System.out.println("Brick bullet action");

		Map map = MapLoader.getMap();

		int x = MapUtil.toXIndex(this.x);
		int y = MapUtil.toYIndex(this.y);

		map.getMapElements()[y][x] = new Nothing(this.x, this.y);

	}
}
