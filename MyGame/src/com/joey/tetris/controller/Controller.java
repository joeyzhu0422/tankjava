package com.joey.tetris.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.joey.tetris.entities.Ground;
import com.joey.tetris.entities.Shape;
import com.joey.tetris.entities.ShapeFactory;
import com.joey.tetris.listener.ShapeListener;
import com.joey.tetris.view.GamePanel;

public class Controller extends KeyAdapter implements ShapeListener {

	private Shape shape;
	private ShapeFactory shapeFactory;
	private Ground ground;
	private GamePanel gamePanel;

	public Controller(ShapeFactory shapeFactory, Ground ground,
			GamePanel gamePanel) {
		this.shapeFactory = shapeFactory;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (ground.isMoveable(shape, Shape.ROTATE)) {
				shape.rotate();
			}
			break;
		case KeyEvent.VK_DOWN:
			if (this.isShapeMoveDownable(shape)) {
				shape.moveDown();
			}

			break;
		case KeyEvent.VK_LEFT:
			if (ground.isMoveable(shape, Shape.LEFT)) {
				shape.moveLeft();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (ground.isMoveable(shape, Shape.RIGHT)) {
				shape.moveRight();
			}
			break;

		}
		gamePanel.display(ground, shape);
	}

	@Override
	public void shapeMoveDown(Shape shape) {
		gamePanel.display(ground, shape);
	}

	public void newGame() {
		shape = shapeFactory.getShape(this);
	}

	@Override
	public synchronized boolean isShapeMoveDownable(Shape shape) {
		if (this.shape != shape) {
			return false;
		}

		if (ground.isMoveable(shape, shape.DOWN)) {
			return true;
		}

		ground.accept(this.shape);
		if (!ground.isFull()) {
			this.shape = shapeFactory.getShape(this);
		}

		return false;
	}
}
