package com.joey.tank.scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;

import com.joey.tank.beans.Bullet;
import com.joey.tank.beans.tank.EnemyTank;
import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.impl.MainTankKeyListenerImpl;
import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;
import com.joey.tank.util.MapUtil;

public class Scene extends JFrame implements Runnable {

	private static final long serialVersionUID = 3312071826547989755L;

	private Map map;

	private int width = Constant.Scene.WIDTH;

	private int height = Constant.Scene.HEIGHT;

	private BufferedImage bufferScene;

	public Scene() {

		this.setBounds(0, 0, width, height);

		// step.1 初始化元素
		this.initElements();

		new Thread(this).start();

		this.setVisible(true);
	}

	private void initElements() {

		bufferScene = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// step.1 创建地图
		map = MapLoader.getMap();

		// step.2 放置主坦克
		MapUtil.putToMultipleLayer(TankFactory.getMainTank());

		// step.3 set key listener to scene
		this.addKeyListener(new MainTankKeyListenerImpl(TankFactory
				.getMainTank()));

	}

	public void paint(Graphics g) {

		// step.1 初始化元素
		map.init();

		// step.2 双缓冲区设置
		Graphics bufferG = bufferScene.getGraphics();

		// step.3 涂上背景
		bufferG.setColor(Constant.Scene.SCENE_COLOR);
		bufferG.fillRect(0, 0, width, height);

		// step.4 地图绘制
		map.draw(bufferG);

		// step.4-1 mainTank子弹绘制
		for (Bullet bullet : TankFactory.getMainTank().getFiredBulletQueue()) {
			bullet.draw(bufferG);
		}

		// step.5 双缓冲区放置到面板
		g.drawImage(bufferScene, 0, 0, width, height, null);
	}

	public void run() {

		while (true) {

			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			List<EnemyTank> currentEnemyTankList = TankFactory
					.getCurrentEnemyTankList();

			for (EnemyTank enemyTank : currentEnemyTankList) {
				MapUtil.putToMultipleLayer(enemyTank);
			}

			this.repaint();
		}

	}

}
