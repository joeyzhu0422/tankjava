package com.joey.tank.beans.obstacle;

import com.joey.tank.constant.Constant;

public class ObstacleFactory {

	public static Obstacle createObstacle(int x, int y, int type) {

		Obstacle obstacle = null;

		switch (type) {
		case Constant.Obstacle.TYPE_NOTHING:
			obstacle = new Nothing(x, y);
			break;
		case Constant.Obstacle.TYPE_BRICK:
			obstacle = new Brick(x, y);
			break;
		default:
			throw new RuntimeException("[type: " + type + "] can not find");
		}

		System.out.println(obstacle);
		
		return obstacle;
	}

}
