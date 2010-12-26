package com.joey.tank.listener;

import com.joey.tank.beans.ActiviteElement;

public interface MoveListener {

	/**
	 * 判断是否碰撞
	 * 
	 * @param element
	 *            活动物体
	 * @return boolean 如果返回true，则表示物体继续运动，反之亦然。
	 */
	public boolean isCollide(ActiviteElement element);

}
