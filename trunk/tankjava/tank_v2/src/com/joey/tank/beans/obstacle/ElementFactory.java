package com.joey.tank.beans.obstacle;

import com.joey.tank.beans.MapElement;
import com.joey.tank.constant.Constant;

public class ElementFactory {

	private static MapElement HOME;

	public static MapElement createElement(int x, int y, int type) {

		MapElement mapElement = null;

		switch (type) {
		case Constant.Obstacle.TYPE_NOTHING:
			mapElement = new Nothing(x, y);
			break;
		case Constant.Obstacle.TYPE_BRICK:
			mapElement = new Brick(x, y);
			break;
		case Constant.Obstacle.TYPE_HOME:

			if (null == HOME) {
				HOME = new Home(x, y);
			}

			mapElement = HOME;
			break;
		default:
			throw new RuntimeException("[type: " + type + "] can not find");
		}

		System.out.println(mapElement);

		return mapElement;
	}

}
