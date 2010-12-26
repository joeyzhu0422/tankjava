package com.joey.tank.beans;

import java.awt.Graphics;

public class Bullet extends ActiviteElement {

	public void action() {
		System.out.println("Bullet is action");
	}

	public void draw(Graphics g) {
		System.out.println("Bullet draw");
	}

}
