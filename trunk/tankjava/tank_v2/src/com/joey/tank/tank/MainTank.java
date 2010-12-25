package com.joey.tank.beans.tank;

import java.awt.Color;

public class MainTank extends BaseAbstractTank {

	public MainTank() {
		this.color = Color.YELLOW;
		this.x = 10;
		this.y = 10;
		this.width = 30;
		this.height = 30;
	}

	public void action() throws Exception {
		System.out.println("Main Tank is action");
	}

}
