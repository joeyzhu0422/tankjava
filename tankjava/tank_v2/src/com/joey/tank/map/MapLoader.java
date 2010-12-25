package com.joey.tank.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.joey.base.util.ArrayUtil;
import com.joey.base.util.ResouceUtil;
import com.joey.base.util.StringUtil;
import com.joey.tank.constant.Constant;

public class MapLoader {

	private static Map map;

	private static Object lock = new Object();

	private static int gate = 1;

	public static Map getMap() {

		if (null == map) {

			synchronized (lock) {

				if (null == map) {

					MapLoader.loadNextMap();

				}

			}

		}

		return map;
	}

	public static void loadNextMap() {

		try {
			System.out.println("MapLoader loading ...");

			File mapFile = ResouceUtil.getResouce("config/map/map" + gate + ".map");

			BufferedReader reader = new BufferedReader(new FileReader(mapFile));

			int[][] obstacless = new int[Constant.Scene.WIDTH
					/ Constant.Scene.CELL_LENGTH][];

			int lineNum = 0;

			while (reader.ready()) {
				String line = reader.readLine();

				String[] _obstacles = StringUtil.split(line, 1);

				int[] obstacles = ArrayUtil.toInt(_obstacles);

				obstacless[lineNum++] = obstacles;
			}

			map = new Map();
			
			map.setModels(obstacless);

			gate++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		MapLoader.loadNextMap();
	}
}
