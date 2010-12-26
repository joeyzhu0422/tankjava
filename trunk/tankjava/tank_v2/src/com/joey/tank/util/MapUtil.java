package com.joey.tank.util;

import com.joey.tank.constant.Constant;

public class MapUtil {

	public static int toXIndex(int realX) {

		return realX / Constant.Scene.CELL_LENGTH;

	}

	public static int toYIndex(int realY) {

		return (realY - Constant.Scene.TOP_HEIGHT) / Constant.Scene.CELL_LENGTH;

	}

}
