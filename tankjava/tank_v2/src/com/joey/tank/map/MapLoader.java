package com.joey.tank.map;

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
		// TODO
		System.out.println("MapLoader loading ...");

		gate++;
	}

}
