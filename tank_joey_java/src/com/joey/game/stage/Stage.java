package com.joey.game.stage;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.loon.framework.game.simple.core.graphics.Screen;

import com.joey.game.sprite.Bullet;

public class Stage extends Screen {

	private Bullet bullet;
	
	public Stage() {
		this.init();
	}

	public void init() {
		bullet = new Bullet(null, "images/ball.gif", 40, 40, 0, 10);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(bullet.getOriginalImage(), 0, 0 , null);
	}

	@Override
	public void leftClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void middleClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKey(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyUp(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
