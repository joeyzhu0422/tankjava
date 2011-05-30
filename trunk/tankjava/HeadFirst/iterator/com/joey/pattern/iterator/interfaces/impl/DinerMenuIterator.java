package com.joey.pattern.iterator.interfaces.impl;

import com.joey.pattern.iterator.entities.MenuItem;
import com.joey.pattern.iterator.interfaces.Iterator;

public class DinerMenuIterator implements Iterator {

	private MenuItem[] items;

	private int position = 0;

	public DinerMenuIterator(MenuItem[] items) {
		this.items = items;
	}

	public boolean hasNext() {
		return position < items.length && items[position] != null;
	}

	public Object next() {
		return items[position++];
	}

}
