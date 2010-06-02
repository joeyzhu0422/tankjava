package com.joey.game.base.utils;

public class ArraysUtil {

	public static int[] toInt(String[] array) {
		if (null == array || array.length == 0) {
			return new int[0];
		}

		int[] intArray = new int[array.length];

		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(array[i]);
		}

		return intArray;
	}
}
