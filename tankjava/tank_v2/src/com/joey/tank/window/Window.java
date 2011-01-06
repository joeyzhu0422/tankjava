package com.joey.tank.window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
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

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screensize.width - width) / 2;
		int y = (screensize.height - height) / 2;

		this.setBounds(x, y, width, height);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
				Thread.sleep(Constant.Scene.THREAD_SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (null != scene) {
				scene.action();
				this.repaint();
			}

		}

	}

	public void start() {

		try {
			Thread.sleep(Constant.Scene.THREAD_SLEEP_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.isRunFlg = true;
		this.scene.init();

		if (null != this.scene.getKeyListenerList()) {
			for (KeyListener listener : this.scene.getKeyListenerList()) {
				this.addKeyListener(listener);
			}
		}

		new Thread(this).start();

	}

	public void stop() {
		this.isRunFlg = false;
	}

	public void setScene(IScene scene) {

		if (null != this.scene && null != this.scene.getKeyListenerList()) {

			for (KeyListener listener : this.scene.getKeyListenerList()) {
				this.removeKeyListener(listener);
			}

		}

		this.scene = scene;
	}

}
