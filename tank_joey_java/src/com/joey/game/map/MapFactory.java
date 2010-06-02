package com.joey.game.map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.ImageIcon;

import org.loon.framework.game.simple.utils.GraphicsUtils;

import com.joey.game.base.utils.ArraysUtil;

public class MapFactory {

	private static int[][] currentMap;

	private static final String[] baffles = { "images/wall.gif",
			"images/ston.gif", "images/steel.gif", "images/sea.gif" };

	private static Image[] baffleImages;

	private static Image homeImage;

	final static private ClassLoader classLoader = Thread.currentThread()
			.getContextClassLoader();

	static {
		init();
	}

	private static void init() {
		try {
			String classpath = ClassLoader.getSystemResource("").toString()
					.replace("file:", "");

			BufferedReader reader = new BufferedReader(new FileReader(new File(
					classpath + "map/map1.map")));

			currentMap = new int[24][];

			int col = 0;

			while (col <= 23) {
				currentMap[col] = ArraysUtil
						.toInt(reader.readLine().split(","));
				col++;
			}

			baffleImages = new Image[4];

			for (int i = 0; i < baffleImages.length; i++) {
				baffleImages[i] = GraphicsUtils.loadFileImage(classpath
						+ baffles[i]);
			}

			homeImage = GraphicsUtils.loadFileImage(classpath
					+ "images/home.gif");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int[][] getCurrentMap() {
		return currentMap;
	}

	public static Image[] getBaffleImages() {
		return baffleImages;
	}

	public static Image getHomeImage() {
		return homeImage;
	}

}
