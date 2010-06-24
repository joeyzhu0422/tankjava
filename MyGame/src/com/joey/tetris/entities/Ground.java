package com.joey.tetris.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.joey.tetris.util.Global;

public class Ground {

	private int[][] obstacles = new int[Global.WIDTH][Global.HEIGHT];

	public void accept(Shape shape) {
		System.out.println("Ground's accept");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (shape.isMember(i, j, false)) {
					obstacles[shape.getLeft() + i][shape.getTop() + j] = 1;
				}
			}
		}

		this.deleteFullLine();
	}

	private void deleteFullLine() {
		for (int j = Global.HEIGHT - 1; j > 0; j--) {
			boolean full = true;
			for (int i = 0; i < Global.WIDTH; i++) {
				if (obstacles[i][j] == 0) {
					full = false;
					break;
				}
			}

			if (full) {
				deleteLine(j);
			}
		}
	}

	private void deleteLine(int lineNum) {
		for (int j = lineNum; j > 0; j--) {
			for (int i = 0; i < Global.WIDTH; i++) {
				obstacles[i][j] = obstacles[i][j - 1];
			}
		}

		for (int i = 0; i < Global.WIDTH; i++) {
			obstacles[i][0] = 0;
		}
	}

	public void drawMe(Graphics g) {
		System.out.println("Ground;s drawMe");

		g.setColor(Color.DARK_GRAY);

		for (int i = 0; i < Global.WIDTH; i++) {
			for (int j = 0; j < Global.HEIGHT; j++) {
				if (obstacles[i][j] == 1) {
					g.fill3DRect(i * Global.CELL_SIZE, j * Global.CELL_SIZE,
							Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
		}

		for (int i = 0; i < Global.WIDTH; i++) {

		}
	}

	public boolean isMoveable(Shape shape, int action) {

		int left = shape.getLeft();
		int top = shape.getTop();

		switch (action) {
		case Shape.LEFT:
			left--;
			break;
		case Shape.RIGHT:
			left++;
			break;
		case Shape.DOWN:
			top++;
			break;
		default:
			break;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (shape.isMember(i, j, action == Shape.ROTATE)) {
					if (top + j >= Global.HEIGHT || left + i < 0
							|| left + i >= Global.WIDTH
							|| obstacles[left + i][top + j] == 1) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public boolean isFull() {
		for (int i = 0; i < Global.WIDTH; i++) {
			if (obstacles[i][0] == 1) {
				return true;
			}
		}

		return false;
	}
}
