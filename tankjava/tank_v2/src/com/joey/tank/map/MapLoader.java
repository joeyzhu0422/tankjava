package com.joey.tank.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

	public static boolean loadNextMap() {

	
			try {
				System.out.println("MapLoader loading ...");

				InputStream inputStream = ResouceUtil.getResouce("config/map/map"
						+ gate + ".map");
				
				if (null == inputStream) {
					return false;
				}

				BufferedReader reader = new BufferedReader(new InputStreamReader(
						inputStream));

				int[][] obstacless = new int[(Constant.Scene.HEIGHT
						- Constant.Scene.TOP_HEIGHT - Constant.Scene.DOWN_HEIGTH)
						/ Constant.Scene.CELL_LENGTH][Constant.Scene.WIDTH
						/ Constant.Scene.CELL_LENGTH];

				int lineNum = 0;

				String line = null;

				int i = 1;
				while ((line = reader.readLine()) != null && !"".equals(line)) {

					System.out.println("line " + (i++) + ":" + line);

					String[] _obstacles = StringUtil.split(line, 1);

					int[] obstacles = ArrayUtil.toInt(_obstacles);

					obstacless[lineNum++] = obstacles;
				}
				
				map = new Map(obstacless);

				gate++;
				
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} 
		
	}

	public static int getCurrentGate() {
		return gate - 1;
	}

}
