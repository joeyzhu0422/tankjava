package com.joey.base.util;

public class ArrayUtil {

	public static int[] toInt(String[] objs) {

		int[] ints = new int[objs.length];

		for (int i = 0; i < objs.length; i++) {
//			System.out.println("objs" + objs[i]);
			ints[i] = Integer.valueOf(objs[i]);
		}

		return ints;
	}

}
