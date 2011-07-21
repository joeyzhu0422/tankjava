package info.cloverapp.game.pig.move.listener.impl;

import info.cloverapp.game.pig.beans.ActiviteElement;
import info.cloverapp.game.pig.move.listener.MoveListener;

public class ArrowMoveListenerImpl implements MoveListener{

	@Override
	public boolean isCollide(ActiviteElement element) {
		return true;
	}

}
