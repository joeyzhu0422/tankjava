package com.joey.snake.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.joey.snake.entities.Food;
import com.joey.snake.entities.Ground;
import com.joey.snake.entities.Snake;
import com.joey.snake.util.Global;

public class GamePanel extends JPanel {

	private Snake snake;

	private Food food;

	private Ground ground;

	public void display(Snake snake, Food food, Ground ground) {
		System.out.println("GamePanel's display");
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		super.repaint();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		// ÷ÿ–¬œ‘ æ
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH * Global.CELL_SIZE, Global.HEIGHT
				* Global.CELL_SIZE);
		this.ground.drawMe();
		this.snake.drawMe(g);
		this.food.drawMe(g);
	}

}
