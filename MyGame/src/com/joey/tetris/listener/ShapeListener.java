package com.joey.tetris.listener;

import com.joey.tetris.entities.Shape;

public interface ShapeListener {

	void shapeMoveDown(Shape shape);

	boolean isShapeMoveDownable(Shape shape);
}
