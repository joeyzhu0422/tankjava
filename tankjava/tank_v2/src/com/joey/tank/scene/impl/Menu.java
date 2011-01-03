package com.joey.tank.scene.impl;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.joey.tank.constant.Constant;
import com.joey.tank.listener.impl.MenuKeyListenerImpl;
import com.joey.tank.scene.IScene;
import com.joey.tank.util.ResouceUtil;
import com.joey.tank.window.Window;

public class Menu implements IScene {

	protected BufferedImage bufferScene;

	protected Window window;

	protected List<KeyListener> keyListenerList;

	protected Object lock = new Object();

	public Menu(Window window) {

		this.window = window;

	}

	public void draw(Graphics g, int width, int height) {

		bufferScene = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// step.1 双缓冲区设置
		Graphics bufferG = bufferScene.getGraphics();

		Image menuImage = ResouceUtil.getMenuImage();

		bufferG.drawImage(menuImage, 0, Constant.Scene.TOP_HEIGHT, null);

		bufferG.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 12));

		bufferG.drawString("aaa", 50, 300);

		// step.6 双缓冲区放置到面板
		g.drawImage(bufferScene, 0, 0, width, height, null);

	}

	@Override
	public List<KeyListener> getKeyListenerList() {

		if (null == keyListenerList) {

			synchronized (lock) {

				if (null == keyListenerList) {

					keyListenerList = new ArrayList<KeyListener>();
					keyListenerList.add(new MenuKeyListenerImpl(window));

				}

			}
		}

		return keyListenerList;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reDo() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isRun() {
		return true;
	}

}
