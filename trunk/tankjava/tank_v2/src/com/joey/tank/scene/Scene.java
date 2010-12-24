package com.joey.tank.scene;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;

import com.joey.tank.beans.EnemyTank;
import com.joey.tank.beans.MainTank;
import com.joey.tank.beans.SubTank;
import com.joey.tank.map.Map;
import com.joey.tank.map.MapLoader;

public class Scene extends JFrame implements Runnable{

	private static final long serialVersionUID = 3312071826547989755L;

	private MainTank mainTank;

	private SubTank subTank;

	private List<EnemyTank> enemyTankList;

	private Map map;
	
	private int width = 500;
	
	private int height = 500;

	public Scene() {

		this.setBounds(0, 0, width, height);
		
		// step.1 初始化元素
		this.initElements();
		
		new Thread(this).start();

		this.setVisible(true);
	}
	
	private void initElements() {
		
		// step.1 创建地图
		map = MapLoader.getMap();
		
		// step.2 创建主坦克
		mainTank = new MainTank();
		
	}
	
	public void paint(Graphics g) {
		
		// step.1 涂上背景
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		// step.2 绘制tank
		mainTank.draw(g);
		
	}
	
	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Scene repaint...");
			
			this.repaint();
		}
		
	}


	/** setter and getter */
	public MainTank getMainTank() {
		return mainTank;
	}

	public void setMainTank(MainTank mainTank) {
		this.mainTank = mainTank;
	}

	public SubTank getSubTank() {
		return subTank;
	}

	public void setSubTank(SubTank subTank) {
		this.subTank = subTank;
	}

	public List<EnemyTank> getEnemyTankList() {
		return enemyTankList;
	}

	public void setEnemyTankList(List<EnemyTank> enemyTankList) {
		this.enemyTankList = enemyTankList;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}


}
