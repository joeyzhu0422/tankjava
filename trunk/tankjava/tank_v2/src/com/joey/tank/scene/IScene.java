package com.joey.tank.scene;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.List;

public interface IScene {

	public void init();

	public void action();

	public void draw(Graphics g, int width, int height);

	public List<KeyListener> getKeyListenerList();

	public boolean isRun();

}
