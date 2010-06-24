package com.joey.tetris.game;

import javax.swing.JFrame;

import com.joey.tetris.controller.Controller;
import com.joey.tetris.entities.Ground;
import com.joey.tetris.entities.ShapeFactory;
import com.joey.tetris.view.GamePanel;

public class Game {

	public static void main(String[] args) {

		ShapeFactory shapeFactory = new ShapeFactory();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();

		Controller controller = new Controller(shapeFactory, ground, gamePanel);

		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(gamePanel.getSize().width + 10,
				gamePanel.getSize().height + 35);
		frame.add(gamePanel);

		frame.addKeyListener(controller);
		frame.setVisible(true);
		controller.newGame();
	}

}
