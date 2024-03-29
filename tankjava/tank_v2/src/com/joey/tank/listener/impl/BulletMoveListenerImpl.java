package com.joey.tank.listener.impl;

import java.util.ArrayList;
import java.util.List;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.beans.Bullet;
import com.joey.tank.beans.IMapElement;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.MoveListener;
import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;
import com.joey.tank.util.MapUtil;

public class BulletMoveListenerImpl implements MoveListener {

	public boolean isCollide(ActiviteElement element) {
		// System.out.println("Bullet Move Listener isCollide");

		Map map = MapLoader.getMap();

		int x = element.getX();
		int y = element.getY();

		// �ϰ��Ｏ��
		List<IMapElement> obstacleList = new ArrayList<IMapElement>(2);

		IMapElement singleObstacle1 = null, singleObstacle2 = null;
		IMapElement multipleObstacle1 = null, multipleObstacle2 = null;

		switch (element.getDirection()) {
		case Constant.ActiviteElement.DIRECTION_UP:

			// System.out.println(MapUtil.toXIndex(x));
			// System.out.println(y);
			singleObstacle1 = map.getSingleLayerElement(MapUtil.toXIndex(x),
					MapUtil.toYIndex(y) - 1);
			singleObstacle2 = map.getSingleLayerElement(
					MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y) - 1);
			multipleObstacle1 = map.getMultipleLayerElement(
					MapUtil.toXIndex(x), MapUtil.toYIndex(y) - 1);
			multipleObstacle2 = map.getMultipleLayerElement(
					MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y) - 1);

			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:

			singleObstacle1 = map.getSingleLayerElement(MapUtil.toXIndex(x),
					MapUtil.toYIndex(y) + 1);
			singleObstacle2 = map.getSingleLayerElement(
					MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y) + 1);
			multipleObstacle1 = map.getMultipleLayerElement(
					MapUtil.toXIndex(x), MapUtil.toYIndex(y) + 1);
			multipleObstacle2 = map.getMultipleLayerElement(
					MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y) + 1);

			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:

			singleObstacle1 = map.getSingleLayerElement(
					MapUtil.toXIndex(x) - 1, MapUtil.toYIndex(y));
			singleObstacle2 = map.getSingleLayerElement(
					MapUtil.toXIndex(x) - 1, MapUtil.toYIndex(y) + 1);
			multipleObstacle1 = map.getMultipleLayerElement(
					MapUtil.toXIndex(x) - 1, MapUtil.toYIndex(y));
			multipleObstacle2 = map.getMultipleLayerElement(
					MapUtil.toXIndex(x) - 1, MapUtil.toYIndex(y) + 1);

			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:

			singleObstacle1 = map.getSingleLayerElement(
					MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y));
			singleObstacle2 = map.getSingleLayerElement(
					MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y) + 1);
			multipleObstacle1 = map.getMultipleLayerElement(
					MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y));
			multipleObstacle2 = map.getMultipleLayerElement(
					MapUtil.toXIndex(x) + 1, MapUtil.toYIndex(y) + 1);

			break;
		}

		if (null == singleObstacle1 || null == singleObstacle2) {
			return false;
		}
		obstacleList.add(singleObstacle1);
		obstacleList.add(singleObstacle2);
		obstacleList.add(multipleObstacle1);
		obstacleList.add(multipleObstacle2);

		boolean isPass = true;

		Bullet bullet = null;
		if (element instanceof Bullet) {
			bullet = (Bullet) element;
		} else {
			throw new RuntimeException(
					"In BulletMoveListener, element is not instance of Bullet");
		}

		for (IMapElement obstacle : obstacleList) {

			if (null != obstacle
					&& !obstacle.isBulletPass()
					&& !obstacle.getClass().getName().equals(
							bullet.getTank().getClass().getName())) {

				obstacle.bulletAction();
				if (isPass) {
					isPass = isPass && obstacle.isBulletPass();
				}
			}

		}

		return isPass;
	}
}
