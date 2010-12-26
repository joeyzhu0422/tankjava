package com.joey.tank.listener.impl;

import java.util.ArrayList;
import java.util.List;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.beans.obstacle.Obstacle;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.MoveListener;
import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;
import com.joey.tank.util.MapUtil;

public class TankMoveListenerImpl implements MoveListener {

	public boolean isCollide(ActiviteElement element) {
		System.out.println("Tank Move Listener isCollide");

		Map map = MapLoader.getMap();

		int x = element.getX();
		int y = element.getY();

		// ǰ��������ײ�����ϰ������
		int collideNum = element.getWidth() / Constant.Scene.CELL_LENGTH;

		// �ϰ��Ｏ��
		List<Obstacle> obstacleList = new ArrayList<Obstacle>(collideNum);

		switch (element.getDirection()) {
		case Constant.ActiviteElement.DIRECTION_UP:
			while (collideNum-- > 0) {
				System.out.println(MapUtil.toXIndex(x));
				System.out.println(y);
				Obstacle obstacle = map.getObstacle(MapUtil.toXIndex(x)
						+ collideNum, MapUtil.toYIndex(y) - 1);
				if (null == obstacle) {
					return false;
				}
				obstacleList.add(obstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:
			while (collideNum-- > 0) {
				Obstacle obstacle = map.getObstacle(MapUtil.toXIndex(x)
						+ collideNum, MapUtil.toYIndex(y) + element.getHeight()
						/ Constant.Scene.CELL_LENGTH);
				if (null == obstacle) {
					return false;
				}
				obstacleList.add(obstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:
			while (collideNum-- > 0) {
				Obstacle obstacle = map.getObstacle(MapUtil.toXIndex(x) - 1, MapUtil.toYIndex(y)
						+ collideNum);
				if (null == obstacle) {
					return false;
				}
				obstacleList.add(obstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:
			while (collideNum-- > 0) {
				Obstacle obstacle = map.getObstacle(MapUtil.toXIndex(x)
						+ element.getWidth() / Constant.Scene.CELL_LENGTH,
						MapUtil.toYIndex(y)
						+ collideNum);
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
