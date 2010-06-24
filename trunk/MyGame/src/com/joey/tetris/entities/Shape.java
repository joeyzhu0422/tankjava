package com.joey.tetris.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import com.joey.tetris.listener.ShapeListener;
import com.joey.tetris.util.Global;

public class Shape extends Point {

	public static final int ROTATE = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;

	private int[][] body;
	private int status;

	private ShapeListener listener;

	public Shape() {
		new Thread(new ShapeDriver()).start();
	}

	public void moveLeft() {
		System.out.println("Shape's moveLeft");
		x--;
	}

	public void moveRight() {
		System.out.println("Shape's moveRight");
		x++;
	}

	public void moveDown() {
		System.out.println("Shape's moveDown");
		y++;
	}

	public void rotate() {
		System.out.println("Shape's rotate");
		status = (status + 1) % body.length;
	}

	public void drawMe(Graphics g) {
		System.out.println("Shape's drawMe");

		g.setColor(Color.BLUE);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (this.getFlagByPoint(i, j)) {
					g.fill3DRect((this.x + i) * Global.CELL_SIZE, (this.y + j)
							* Global.CELL_SIZE, Global.CELL_SIZE,
							Global.CELL_SIZE, true);
				}
			}
		}
	}

	private boolean getFlagByPoint(int x, int y) {
		return body[status][y * 4 + x] == 1;
	}

	public boolean isMember(int x, int y, boolean rotate) {
		int tempStatus = status;

		if (rotate) {
			tempStatus = (status + 1) % body.length;
		}

		return body[tempStatus][y * 4 + x] == 1;
	}

	private class ShapeDriver implements Runnable {

		public void run() {
			while (listener.isShapeMoveDownable(Shape.this)) {
				moveDown();

				listener.shapeMoveDown(Shape.this);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void addShapeListener(ShapeListener l) {
		if (l != null) {
			this.listener = l;
		}
	}

	public void setBody(int[][] body) {
		this.body = body;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTop() {
		return y;
	}

	public int getLeft() {
		return x;
	}

}
