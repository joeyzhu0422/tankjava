package com.joey.base.util;

import java.awt.Image;
import java.awt.Toolkit;

public class ImageUtil {

	public static Image getImage(String filePath) {

		String classPath = ResouceUtil.class.getClassLoader().getResource("")
				.getPath();

		return Toolkit.getDefaultToolkit().getImage(classPath + filePath);
	}
}
