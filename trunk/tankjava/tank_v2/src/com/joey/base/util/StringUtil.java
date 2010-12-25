package com.joey.base.util;

public class StringUtil {

	public static final String COMMA = ",";

	public static final String EMPTY = "";

	public static String[] split(String str, String regex) {
		// TODO
		return str.split(regex);
	}

	public static String[] split(String str, int cellSize) {
		// TODO
		int _strsLength = (int) Math.ceil(str.length() * 1.0 / cellSize);

		String[] _strs = new String[_strsLength];

		int _startIndex = 0;
		for (int i = 0; i < _strs.length; i++) {
			_strs[i] = str.substring(_startIndex, _startIndex + cellSize > str
					.length() ? str.length() : _startIndex + cellSize);
			_startIndex = _startIndex + cellSize;
		}

		return _strs;
	}

}
