package com.joey.tank.listener;

import com.joey.tank.beans.ActiviteElement;

public interface MoveListener {

	/**
	 * �ж��Ƿ���ײ
	 * 
	 * @param element
	 *            �����
	 * @return boolean �������true�����ʾ��������˶�����֮��Ȼ��
	 * @throws Exception
	 */
	public boolean isCollide(ActiviteElement element) throws Exception;

}
