package com.joey.snake.game;

import javax.swing.JFrame;

import com.joey.snake.controller.Controller;
import com.joey.snake.entities.Food;
import com.joey.snake.entities.Ground;
import com.joey.snake.entities.Snake;
import com.joey.snake.util.Global;
import com.joey.snake.view.GamePanel;

public class Game {

	public static void main(String[] args) {

		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();

		Controller controller = new Controller(snake, food, ground, gamePanel);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Global.WIDTH * Global.CELL_SIZE + 10, Global.HEIGHT
				* Global.CELL_SIZE + 35);
		gamePanel.setSize(Global.WIDTH * Global.CELL_SIZE, Global.HEIGHT
				* Global.CELL_SIZE);
		frame.add(gamePanel);

		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		
		frame.addKeyListener(controller);

		frame.setVisible(true);
		controller.newGame();
	}
}
