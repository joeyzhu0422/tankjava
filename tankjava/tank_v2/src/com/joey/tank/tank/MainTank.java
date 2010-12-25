package com.joey.tank.beans.tank;

import java.awt.Color;

import com.joey.tank.constant.Constant;

public class MainTank extends BaseAbstractTank {

	public MainTank() {
		this.color = Color.YELLOW;
		this.x = Constant.Tank.MainTank.ORIGINAL_X;
		this.y = Constant.Tank.MainTank.ORIGINAL_Y;
		this.width = 30;
		this.height = 30;
	}

	public void action() throws Exception {
		System.out.println("Main Tank is action");
	}

}
