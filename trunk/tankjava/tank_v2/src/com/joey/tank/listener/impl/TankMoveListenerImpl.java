package com.joey.tank.listener.impl;

import java.util.ArrayList;
import java.util.List;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.beans.MapElement;
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

		// 前方可能碰撞到的障碍物个数
		int collideNum = element.getWidth() / Constant.Scene.CELL_LENGTH;

		// 障碍物集合
		List<MapElement> obstacleList = new ArrayList<MapElement>(collideNum);

		switch (element.getDirection()) {
		case Constant.ActiviteElement.DIRECTION_UP:
			while (--collideNum >= 0) {
				System.out.println(MapUtil.toXIndex(x));
				System.out.println(MapUtil.toYIndex(y));
				MapElement singleObstacle = map.getSingleLayerElement(MapUtil
						.toXIndex(x)
						+ collideNum, MapUtil.toYIndex(y) - 1);
				MapElement multipleObstacle = map.getMultipleLayerElement(MapUtil
						.toXIndex(x)
						+ collideNum, MapUtil.toYIndex(y) - 1);
				if (null == singleObstacle) {
					return false;
				}
				obstacleList.add(singleObstacle);
				obstacleList.add(multipleObstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:
			while (--collideNum >= 0) {
				MapElement singleObstacle = map.getSingleLayerElement(MapUtil
						.toXIndex(x)
						+ collideNum, MapUtil.toYIndex(y) + element.getHeight()
						/ Constant.Scene.CELL_LENGTH);
				MapElement multipleObstacle = map.getMultipleLayerElement(MapUtil
						.toXIndex(x)
						+ collideNum, MapUtil.toYIndex(y) + element.getHeight()
						/ Constant.Scene.CELL_LENGTH);
				if (null == singleObstacle) {
					return false;
				}
				obstacleList.add(singleObstacle);
				obstacleList.add(multipleObstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:
			while (--collideNum >= 0) {
				MapElement singleObstacle = map.getSingleLayerElement(MapUtil
						.toXIndex(x) - 1, MapUtil.toYIndex(y) + collideNum);
				MapElement multipleObstacle = map.getMultipleLayerElement(MapUtil
						.toXIndex(x) - 1, MapUtil.toYIndex(y) + collideNum);
				if (null == singleObstacle) {
					return false;
				}
				obstacleList.add(singleObstacle);
				obstacleList.add(multipleObstacle);
			}
			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:
			while (--collideNum >= 0) {
				MapElement singleObstacle = map.getSingleLayerElement(MapUtil
						.toXIndex(x)
						+ element.getWidth() / Constant.Scene.CELL_LENGTH,
						MapUtil.toYIndex(y) + collideNum);
				MapElement multipleObstacle = map.getMultipleLayerElement(MapUtil
						.toXIndex(x)
						+ element.getWidth() / Constant.Scene.CELL_LENGTH,
						MapUtil.toYIndex(y) + collideNum);
				if (null == singleObstacle) {
					return false;
				}
				obstacleList.add(singleObstacle);
				obstacleList.add(multipleObstacle);
			}
			break;
		}

		for (MapElement obstacle : obstacleList) {

			if (!obstacle.isPass()) {
				return false;
			}

		}

		return true;
	}
}
