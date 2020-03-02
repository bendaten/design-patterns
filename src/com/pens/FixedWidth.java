package com.pens;

/**
 * This implementation should be hidden from the client so the client may use it but not change it, therefore
 * requiring the client to use an adapter
 */
public class FixedWidth {

	private static final int WIDTH = 10;

	public String reformat(String text) {
		StringBuilder sb = new StringBuilder();
		for (int pos = 0; pos < text.length(); pos += WIDTH) {
			int to = Math.min(pos + WIDTH, text.length());
			sb.append(text, pos, to).append("\n");
		}
		return sb.toString();
	}
}
