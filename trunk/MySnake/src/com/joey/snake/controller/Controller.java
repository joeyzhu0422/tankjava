package com.joey.snake.controller;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.joey.snake.entities.Food;
import com.joey.snake.entities.Ground;
import com.joey.snake.entities.Snake;
import com.joey.snake.listener.SnakeListener;
import com.joey.snake.util.Global;
import com.joey.snake.view.GamePanel;

public class Controller extends KeyAdapter implements SnakeListener {

	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;

	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(Snake.RIGTH);
			break;
		default:
			break;
		}
	}

	@Override
	public void snakeMoved(Snake snake) {

		if (food.isSnakeEatFood(snake)) {
			snake.eatFood();
			food.newFood(getPoint());
		}

		gamePanel.display(snake, food, ground);
	}

	public Point getPoint() {
		Random random = new Random();

		int x = random.nextInt(Global.WIDTH);
		int y = random.nextInt(Global.HEIGHT);

		return new Point(x, y);
	}

	public void newGame() {
		snake.start();
		food.newFood(getPoint());
	}
}
