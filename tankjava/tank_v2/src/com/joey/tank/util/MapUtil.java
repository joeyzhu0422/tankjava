package com.joey.tank.util;

import com.joey.tank.beans.IMapElement;
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

	public static void putToMultipleLayer(IMapElement element) {

		int indexX = MapUtil.toXIndex(element.getX());
		int indexY = MapUtil.toYIndex(element.getY());

		int degreeHeight = element.getHeight() / Constant.Scene.CELL_LENGTH;

		while (--degreeHeight >= 0) {
			int degreeWidth = element.getWidth() / Constant.Scene.CELL_LENGTH;
			while (--degreeWidth >= 0) {
				MapLoader.getMap().getMapElements(Constant.Map.MULTIPLE_LAYER)[indexY + degreeHeight][indexX
						+ degreeWidth] = element;
			}
		}

	}

	public static void putNothingToMultipleLayer(IMapElement element) {

		int indexX = MapUtil.toXIndex(element.getX());
		int indexY = MapUtil.toYIndex(element.getY());

		int degreeHeight = element.getHeight() / Constant.Scene.CELL_LENGTH;

		while (--degreeHeight >= 0) {
			int degreeWidth = element.getWidth() / Constant.Scene.CELL_LENGTH;
			while (--degreeWidth >= 0) {
				int y = indexY + degreeHeight;
				int x = indexX + degreeWidth;
				MapLoader.getMap().getMapElements(Constant.Map.MULTIPLE_LAYER)[y][x] = null;
			}
		}

	}

}
