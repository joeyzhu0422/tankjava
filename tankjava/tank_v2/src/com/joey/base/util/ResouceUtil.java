package com.joey.base.util;

import java.io.File;

public class ResouceUtil {

	public static File getResouce(String filePath) {

		String classPath = ResouceUtil.class.getClassLoader().getResource("")
				.getPath();

		File file = new File(classPath + filePath);

		return file;

	}
}
