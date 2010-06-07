package com.joey.game.sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.joey.game.sprite.Bullet.Explode;

public class SpriteContainer {

	public static Tank mainTank = SpriteFactory.createMainTank();
	
	public static ETank eTank = SpriteFactory.createETank();

	public static List<Bullet> fireList = new ArrayList<Bullet>();
	
	public static Queue<Explode> exploedQueue = new LinkedBlockingQueue<Explode>();
}
