package com.joey.tetris.entities;

import java.util.Random;

import com.joey.tetris.listener.ShapeListener;

public class ShapeFactory {

	public int[][][] shapes = new int[][][] { 
		{
			{ 1, 0, 0, 0, 
			  1, 1, 1, 0,
              0, 0, 0, 0, 
              0, 0, 0, 0 },
			{ 1, 1, 0, 0,
              1, 0, 0, 0, 
              1, 0, 0, 0, 
              0, 0, 0, 0 },
			{ 1, 1, 1, 0,
              0, 0, 1, 0,
              0, 0, 0, 0,
              0, 0, 0, 0 },
			{ 0, 1, 0, 0, 
              0, 1, 0, 0, 
              1, 1, 0, 0,
              0, 0, 0, 0 }
         },
         {
 			{ 1, 1, 0, 0, 
 			  1, 1, 0, 0,
              0, 0, 0, 0, 
              0, 0, 0, 0 },
 			{ 1, 1, 0, 0,
              1, 1, 0, 0, 
              0, 0, 0, 0, 
              0, 0, 0, 0 },
 			{ 1, 1, 0, 0,
              1, 1, 0, 0,
              0, 0, 0, 0,
              0, 0, 0, 0 },
 			{ 1, 1, 0, 0, 
              1, 1, 0, 0, 
              0, 0, 0, 0,
              0, 0, 0, 0 }
          },
          {
   			{ 0, 1, 0, 0, 
   			  1, 1, 0, 0,
              0, 1, 0, 0, 
              0, 0, 0, 0 },
   			{ 1, 1, 1, 0,
              0, 1, 0, 0, 
              0, 0, 0, 0, 
              0, 0, 0, 0 },
   			{ 0, 1, 0, 0,
              0, 1, 1, 0,
              0, 1, 0, 0,
              0, 0, 0, 0 },
   			{ 0, 1, 0, 0, 
              1, 1, 1, 0, 
              0, 0, 0, 0,
              0, 0, 0, 0 }
         },
         {
			{ 1, 0, 0, 0, 
			  1, 0, 0, 0,
			  1, 0, 0, 0, 
			  1, 0, 0, 0 },
			{ 1, 1, 1, 1,
			  0, 0, 0, 0, 
			  0, 0, 0, 0, 
			  0, 0, 0, 0 },
			{ 1, 0, 0, 0, 
			  1, 0, 0, 0,
			  1, 0, 0, 0, 
			  1, 0, 0, 0 },
			{ 1, 1, 1, 1,
			  0, 0, 0, 0, 
			  0, 0, 0, 0, 
			  0, 0, 0, 0 }
          }

	};

	public Shape getShape(ShapeListener listener) {
		System.out.println("ShapeFactory's getShape");
		Shape shape = new Shape();
		shape.addShapeListener(listener);

		int type = new Random().nextInt(shapes.length);

		shape.setBody(shapes[type]);
		shape.setStatus(0);
		
		return shape;
	}
}
