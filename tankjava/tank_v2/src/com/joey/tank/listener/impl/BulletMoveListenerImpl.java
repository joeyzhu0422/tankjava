package com.joey.tank.listener.impl;

import java.util.ArrayList;
import java.util.List;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.beans.Bullet;
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

		Bullet bullet = null;
		if (element instanceof Bullet) {
			bullet = (Bullet) element;
		} else {
			throw new RuntimeException(
					"In BulletMoveListener, element is not instanceof Bullet");
		}

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
					.toYIndex(y) - 1);
			obstacle2 = map.getMapElement(MapUtil.toXIndex(x) + 1, MapUtil
					.toYIndex(y) - 1);

			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:

			obstacle1 = map
					.getMapElement(MapUtil.toXIndex(x), MapUtil.toYIndex(y)
							+ bullet.getTank().getHeight()
							/ Constant.Scene.CELL_LENGTH);
			obstacle2 = map
					.getMapElement(MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y)
							+ bullet.getTank().getHeight()
							/ Constant.Scene.CELL_LENGTH);

			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:

			obstacle1 = map.getMapElement(MapUtil.toXIndex(x) - 1, MapUtil
					.toYIndex(y));
			obstacle2 = map.getMapElement(MapUtil.toXIndex(x) - 1, MapUtil
					.toYIndex(y) + 1);

			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:

			obstacle1 = map.getMapElement(MapUtil.toXIndex(x)
					+ bullet.getTank().getWidth() / Constant.Scene.CELL_LENGTH,
					MapUtil.toYIndex(y));
			obstacle2 = map.getMapElement(MapUtil.toXIndex(x)
					+ bullet.getTank().getWidth() / Constant.Scene.CELL_LENGTH
					+ 1, MapUtil.toYIndex(y));

			break;
		}

		if (null == obstacle1 || null == obstacle2) {
			return false;
		}
		obstacleList.add(obstacle1);
		obstacleList.add(obstacle2);

		for (MapElement obstacle : obstacleList) {

			if (!obstacle.isBulletPass()) {
				return false;
			}

		}

		return true;
	}
}
