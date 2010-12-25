package com.joey.tank.map;

import java.awt.Graphics;

import com.joey.tank.beans.StaticElement;

public class Map {

	private int[][] models;

	private StaticElement[][] elements;

	public int[][] getModels() {
		return models;
	}

	public void setModels(int[][] models) {
		this.models = models;
	}

	public StaticElement[][] getElements() {
		return elements;
	}

	public void setElements(StaticElement[][] elements) {
		this.elements = elements;
	}

	public void draw(Graphics g) {
		
	}
}
