package com.joey.tank.beans;

import java.awt.Graphics;

public class Bullet extends ActiviteElement {

	public void action() throws Exception {
		System.out.println("Bullet is action");
	}

	public void draw(Graphics g) throws Exception {
		System.out.println("Bullet draw");
	}

}
