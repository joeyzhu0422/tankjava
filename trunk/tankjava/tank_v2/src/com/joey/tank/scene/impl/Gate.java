package com.joey.tank.scene.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.joey.tank.ai.IAiManager;
import com.joey.tank.ai.impl.AiManager;
import com.joey.tank.beans.Bullet;
import com.joey.tank.beans.tank.EnemyTank;
import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.impl.MainTankKeyListenerImpl;
import com.joey.tank.listener.impl.SubTankKeyListenerImpl;
import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;
import com.joey.tank.scene.IScene;
import com.joey.tank.util.MapUtil;

public class Gate implements IScene {

	protected Map map;

	protected BufferedImage bufferScene;

	protected List<KeyListener> keyListenerList;

	protected Object lock = new Object();

	protected int players;

	protected IAiManager aiManager;

	protected boolean isRun = true;

	public Gate(int players) {
		this.players = players;
	}

	public void draw(Graphics g, int width, int height) {

		bufferScene = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// step.1 ��ʼ��Ԫ��
		map.init();

		// step.2 ˫����������
		Graphics bufferG = bufferScene.getGraphics();

		// step.3 Ϳ�ϱ���
		bufferG.setColor(Constant.Scene.SCENE_COLOR);
		bufferG.fillRect(0, 0, width, height);

		// step.4 ��ͼ����
		map.draw(bufferG);

		// step.4-1 mainTank�ӵ�����
		if (players >= 1 && TankFactory.getMainTank() != null) {
			for (Bullet bullet : TankFactory.getMainTank()
					.getFiredBulletQueue()) {
				bullet.draw(bufferG);
			}
		}

		// step.4-2 subTank�ӵ�����
		if (players >= 2 && TankFactory.getSubTank() != null) {
			for (Bullet bullet : TankFactory.getSubTank().getFiredBulletQueue()) {
				bullet.draw(bufferG);
			}
		}

		// step.4-3 ��̹���ӵ�����
		for (EnemyTank enemyTank : TankFactory.getCurrentEnemyTankList()) {
			for (Bullet bullet : enemyTank.getFiredBulletQueue()) {
				bullet.draw(bufferG);
			}
		}

		// step.5 ��̹��������ʾ
		Queue<EnemyTank> reserveEnemyTankQueue = TankFactory
				.geteReserveEnemyTankQueue();

		for (int i = 0; i < reserveEnemyTankQueue.size(); i++) {

			int x = Constant.Scene.WIDTH - Constant.Scene.RIGHT_WIDTH
					+ Constant.Scene.CELL_LENGTH * (i % 2);
			int y = Constant.Scene.TOP_HEIGHT + Constant.Scene.CELL_LENGTH
					* (i / 2) + (i / 2) * 5;

			this.drawSignEnemyTank(bufferG, x, y);

		}

		// step.6 ���ƹؿ���
		this.drawGate(bufferG);

		// step.6 ˫���������õ����
		g.drawImage(bufferScene, 0, 0, width, height, null);
	}

	public void init() {

		// step.1 ������ͼ
		map = MapLoader.getMap();

		// step.2 ������̹��
		if (players >= 1) {
			MapUtil.putToMultipleLayer(TankFactory.getMainTank());
		}

		// step.3 ���ø�̹��
		if (players >= 2) {
			MapUtil.putToMultipleLayer(TankFactory.getSubTank());
		}

		// step.4 ����ai������
		aiManager = new AiManager();
	}

	// ���Ƶ�̹��������־
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

					if (players >= 1) {
						keyListenerList.add(new MainTankKeyListenerImpl());
					}

					if (players >= 2) {
						keyListenerList.add(new SubTankKeyListenerImpl());
					}

				}

			}
		}

		return keyListenerList;
	}

	@Override
	public void action() {

		List<EnemyTank> currentEnemyTankList = TankFactory
				.getCurrentEnemyTankList();

		for (EnemyTank enemyTank : currentEnemyTankList) {
			MapUtil.putToMultipleLayer(enemyTank);
		}

		if (currentEnemyTankList.size() == 0) {
			this.isRun = false;
		}

		aiManager.action();
	}

	public boolean isRun() {
		return isRun;
	}

}
