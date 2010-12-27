package com.joey.tank.util;

import com.joey.tank.beans.MapElement;
import com.joey.tank.beans.obstacle.Nothing;
import com.joey.tank.constant.Constant;
import com.joey.tank.map.MapLoader;

public class MapUtil {

	public static int toXIndex(int realX) {

		return realX / Constant.Scene.CELL_LENGTH;

	}

	public static int toYIndex(int realY) {

		return (realY - Constant.Scene.TOP_HEIGHT) / Constant.Scene.CELL_LENGTH;

	}

	public static int toRealX(int x) {

		return x * Constant.Scene.CELL_LENGTH;

	}

	public static int toRealY(int y) {

		return y * Constant.Scene.CELL_LENGTH + Constant.Scene.TOP_HEIGHT;

	}

	public static void putMap(MapElement element) {

		int indexX = MapUtil.toXIndex(element.getX());
		int indexY = MapUtil.toYIndex(element.getY());

		int degreeHeight = element.getHeight() / Constant.Scene.CELL_LENGTH;

		while (--degreeHeight >= 0) {
			int degreeWidth = element.getWidth() / Constant.Scene.CELL_LENGTH;
			while (--degreeWidth >= 0) {
				MapLoader.getMap().getMapElements()[indexY + degreeHeight][indexX
						+ degreeWidth] = element;
			}
		}

	}

	public static void putNothing(MapElement element) {

		int indexX = MapUtil.toXIndex(element.getX());
		int indexY = MapUtil.toYIndex(element.getY());

		int degreeHeight = element.getHeight() / Constant.Scene.CELL_LENGTH;

		while (--degreeHeight >= 0) {
			int degreeWidth = element.getWidth() / Constant.Scene.CELL_LENGTH;
			while (--degreeWidth >= 0) {
				int y = indexY + degreeHeight;
				int x = indexX + degreeWidth;
				MapLoader.getMap().getMapElements()[y][x] = new Nothing(MapUtil
						.toRealX(x), MapUtil.toRealY(y));
			}
		}

	}

}
