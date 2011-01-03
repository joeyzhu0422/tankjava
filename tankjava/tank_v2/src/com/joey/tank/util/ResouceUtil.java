package com.joey.tank.util;

import java.awt.Image;

import com.joey.base.util.ImageUtil;

public class ResouceUtil {

	private static Image menuImage;

	public static Image getMenuImage() {

		if (null == menuImage) {

			menuImage = ImageUtil.getImage("config/img/menu.jpg");

		}

		return menuImage;

	}

}
