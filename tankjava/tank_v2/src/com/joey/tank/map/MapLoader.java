package com.joey.tank.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.joey.base.util.ArrayUtil;
import com.joey.base.util.ResouceUtil;
import com.joey.base.util.StringUtil;

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

			File map = ResouceUtil.getResouce("config/map/map" + gate + ".map");

			BufferedReader reader = new BufferedReader(new FileReader(map));

			while (reader.ready()) {
				String line = reader.readLine();

				String[] _obstacles = StringUtil.split(line, StringUtil.EMPTY);

				int[] obstacles = ArrayUtil.toInt(_obstacles);
			}

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
