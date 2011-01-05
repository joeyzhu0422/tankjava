package com.joey.base.util;

import java.io.InputStream;

public class ResouceUtil {

	public static InputStream getResouce(String filePath) {

		return ResouceUtil.class.getClassLoader().getResourceAsStream(filePath);

	}
}
