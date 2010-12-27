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

public class BulletMoveListenerImpl implements MoveListener {

	public boolean isCollide(ActiviteElement element) {
		System.out.println("Bullet Move Listener isCollide");

		Map map = MapLoader.getMap();

		int x = element.getX();
		int y = element.getY();

		// ’œ∞≠ŒÔºØ∫œ
		List<MapElement> obstacleList = new ArrayList<MapElement>(2);

		MapElement obstacle1 = null, obstacle2 = null;

		switch (element.getDirection()) {
		case Constant.ActiviteElement.DIRECTION_UP:

			System.out.println(MapUtil.toXIndex(x));
			System.out.println(y);
			obstacle1 = map.getMapElement(MapUtil.toXIndex(x), MapUtil
					.toYIndex(y));
			obstacle2 = map.getMapElement(MapUtil.toXIndex(x) + 1, MapUtil
					.toYIndex(y));

			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:

			obstacle1 = map.getMapElement(MapUtil.toXIndex(x), MapUtil
					.toYIndex(y));
			obstacle2 = map.getMapElement(MapUtil.toXIndex(x) + 1, MapUtil
					.toYIndex(y));

			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:

			obstacle1 = map.getMapElement(MapUtil.toXIndex(x), MapUtil
					.toYIndex(y));
			obstacle2 = map.getMapElement(MapUtil.toXIndex(x), MapUtil
					.toYIndex(y) + 1);

			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:

			obstacle1 = map.getMapElement(MapUtil.toXIndex(x), MapUtil
					.toYIndex(y));
			obstacle2 = map.getMapElement(MapUtil.toXIndex(x), MapUtil
					.toYIndex(y) + 1);

			break;
		}

		if (null == obstacle1 || null == obstacle2) {
			return false;
		}
		obstacleList.add(obstacle1);
		obstacleList.add(obstacle2);

		boolean isPass = true;

		for (MapElement obstacle : obstacleList) {

			if (!obstacle.isBulletPass()) {
				obstacle.bulletAction();
				if (isPass) {
					isPass = obstacle.isBulletPass();
				}
			}

		}

		return isPass;
	}
}
