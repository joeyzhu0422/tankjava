package com.joey.tank.scene;

import javax.swing.JFrame;

import com.joey.tank.constant.Constant;

public class BaseFrame extends JFrame {

	private static final long serialVersionUID = -6672905839180159198L;

	protected int width = Constant.Scene.WIDTH;

	protected int height = Constant.Scene.HEIGHT;

	public BaseFrame() {

		this.setBounds(0, 0, width, height);

	}

}
