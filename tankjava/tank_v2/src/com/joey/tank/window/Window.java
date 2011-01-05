package com.joey.tank.window;

import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.joey.tank.constant.Constant;
import com.joey.tank.scene.IScene;

public class Window extends JFrame implements Runnable {

	private static final long serialVersionUID = 7690460916782653492L;

	protected int width = Constant.Scene.WIDTH;

	protected int height = Constant.Scene.HEIGHT;

	protected IScene scene;

	protected boolean isRunFlg;

	public Window() {
		this.setBounds(0, 0, width, height);

		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {

		if (null != scene) {
			scene.draw(g, width, height);
		}

	}

	public void run() {

		while (isRunFlg && scene.isRun()) {

			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			scene.action();

			this.repaint();

		}

	}

	public void start() {
		
		this.isRunFlg = true;
		this.scene.init();

		for (KeyListener listener : this.scene.getKeyListenerList()) {
			this.addKeyListener(listener);
		}

		new Thread(this).start();

	}

	public void stop() {
		this.isRunFlg = false;
	}

	public void setScene(IScene scene) {

		if (null != this.scene) {

			for (KeyListener listener : this.scene.getKeyListenerList()) {
				this.removeKeyListener(listener);
			}

		}

		this.scene = scene;
	}

}
