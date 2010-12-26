package com.joey.tank.listener.impl;

import java.util.ArrayList;
import java.util.List;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.beans.obstacle.Obstacle;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.MoveListener;
import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;

public class TankMoveListenerImpl implements MoveListener {

	public boolean isCollide(ActiviteElement element) {
		System.out.println("Tank Move Listener isCollide");

		Map map = MapLoader.getMap();

		int x = element.getX();
		int y = element.getY();

		// 前方可能碰撞到的障碍物个数
		int collideNum = element.getWidth() / Constant.Scene.CELL_LENGTH;

		// 障碍物集合
		List<Obstacle> obstacleList = new ArrayList<Obstacle>(collideNum);

		switch (element.getDirection()) {
		case Constant.ActiviteElement.DIRECTION_UP:
			while (collideNum-- > 0) {
				System.out.println(x);
				System.out.println(y);
				Obstacle obstacle = map.getObstacle(x + collideNum, y - 1);
				if (null == obstacle) {
					return false;
				}
				obstacleList.add(obstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:
			while (collideNum-- > 0) {
				Obstacle obstacle = map.getObstacle(x + collideNum, y
						+ element.getHeight() / Constant.Scene.CELL_LENGTH);
				if (null == obstacle) {
					return false;
				}
				obstacleList.add(obstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:
			while (collideNum-- > 0) {
				Obstacle obstacle = map.getObstacle(x - 1, y + collideNum);
				if (null == obstacle) {
					return false;
				}
				obstacleList.add(obstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:
			while (collideNum-- > 0) {
				Obstacle obstacle = map.getObstacle(x + element.getWidth()
						/ Constant.Scene.CELL_LENGTH, y + collideNum);
				if (null == obstacle) {
					return false;
				}
				obstacleList.add(obstacle);
			}
			break;
		}

		for (Obstacle obstacle : obstacleList) {

			if (!obstacle.isPass()) {
				return false;
			}

		}

		return true;
	}
}
