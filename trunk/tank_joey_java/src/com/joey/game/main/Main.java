package com.joey.game.main;

import org.loon.framework.game.simple.GameScene;
import org.loon.framework.game.simple.core.graphics.Deploy;

import com.joey.game.stage.Stage;

public class Main {

	public static void main(String[] args) {
		
		GameScene frame = new GameScene("坦克大战", 650, 480);
		
		// 设定游戏控制器
		Deploy deploy = frame.getDeploy();
		
		deploy.setScreen(new Stage());
		
		// 显示fps
		deploy.setShowFPS(true);
		
		// 允许的最大刷新率
		deploy.setFPS(100);
		deploy.mainLoop();
		
		frame.showFrame();
		
		
		
		
		
	}
	
}
