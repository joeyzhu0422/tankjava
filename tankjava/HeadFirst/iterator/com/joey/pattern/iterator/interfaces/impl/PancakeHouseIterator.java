package com.joey.pattern.iterator.interfaces.impl;

import java.util.List;

import com.joey.pattern.iterator.entities.MenuItem;
import com.joey.pattern.iterator.interfaces.Iterator;

public class PancakeHouseIterator implements Iterator {

	private List<MenuItem> items;

	private int position = 0;

	public PancakeHouseIterator(List<MenuItem> items) {

		this.items = items;

	}

	public boolean hasNext() {
		return position < items.size() && items.get(position) != null;
	}

	public Object next() {
		return items.get(position++);
	}

}
