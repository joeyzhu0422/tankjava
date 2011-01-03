package com.joey.tank.scene.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.joey.tank.beans.Bullet;
import com.joey.tank.beans.tank.EnemyTank;
import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.impl.MainTankKeyListenerImpl;
import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;
import com.joey.tank.scene.IScene;
import com.joey.tank.util.MapUtil;

public class Gate implements IScene {

	protected Map map;

	protected BufferedImage bufferScene;

	protected List<KeyListener> keyListenerList;

	protected Object lock = new Object();

	protected boolean isRun = true;

	public void draw(Graphics g, int width, int height) {

		bufferScene = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

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

		// step.5 敌坦克数量表示
		Queue<EnemyTank> reserveEnemyTankQueue = TankFactory
				.geteReserveEnemyTankQueue();

		for (int i = 0; i < reserveEnemyTankQueue.size(); i++) {

			int x = Constant.Scene.WIDTH - Constant.Scene.RIGHT_WIDTH
					+ Constant.Scene.CELL_LENGTH * (i % 2);
			int y = Constant.Scene.TOP_HEIGHT + Constant.Scene.CELL_LENGTH
					* (i / 2) + (i / 2) * 5;

			this.drawSignEnemyTank(bufferG, x, y);

		}

		// step.6 绘制关卡数
		this.drawGate(bufferG);

		// step.6 双缓冲区放置到面板
		g.drawImage(bufferScene, 0, 0, width, height, null);
	}

	public void init() {

		// step.1 创建地图
		map = MapLoader.getMap();

		// step.2 放置主坦克
		MapUtil.putToMultipleLayer(TankFactory.getMainTank());

	}

	// 绘制敌坦克数量标志
	private void drawSignEnemyTank(Graphics g, int x, int y) {

		int width = 15;
		int height = 15;

		g.setColor(Color.WHITE);

		int barrelWidth = 0, barrelHeight = 0, barrelX = 0, barrelY = 0;

		barrelWidth = width / 10;
		barrelHeight = height / 3;
		barrelX = x + width / 2 - barrelWidth / 2;
		barrelY = y + height;

		g.fill3DRect(x, y, width, height, true);
		g.fill3DRect(barrelX, barrelY, barrelWidth, barrelHeight, true);
	}

	private void drawGate(Graphics g) {

		g.setColor(Color.BLACK);

		String gate = String.valueOf(MapLoader.getCurrentGate());
		int x = Constant.Scene.WIDTH - Constant.Scene.RIGHT_WIDTH;
		int y = Constant.Scene.HEIGHT - Constant.Scene.DOWN_HEIGTH
				- Constant.Scene.TOP_HEIGHT;

		g.drawString(gate, x, y);

	}

	@Override
	public List<KeyListener> getKeyListenerList() {

		if (null == keyListenerList) {

			synchronized (lock) {

				if (null == keyListenerList) {

					keyListenerList = new ArrayList<KeyListener>();
					keyListenerList.add(new MainTankKeyListenerImpl(TankFactory
							.getMainTank()));

				}

			}
		}

		return keyListenerList;
	}

	@Override
	public void reDo() {

		List<EnemyTank> currentEnemyTankList = TankFactory
				.getCurrentEnemyTankList();

		for (EnemyTank enemyTank : currentEnemyTankList) {
			MapUtil.putToMultipleLayer(enemyTank);
		}

		if (currentEnemyTankList.size() == 0) {
			this.isRun = false;
		}
	}

	public boolean isRun() {
		return isRun;
	}

}
