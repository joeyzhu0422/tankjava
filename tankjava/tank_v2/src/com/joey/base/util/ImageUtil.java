package com.joey.base.util;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static Image getImage(String filePath) {

		try {
			InputStream inputStream = ResouceUtil.class.getClassLoader()
					.getResourceAsStream(filePath);

			return ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
