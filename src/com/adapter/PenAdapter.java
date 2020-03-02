package com.adapter;

import com.pens.FixedWidth;

/**
 * This adapter uses a 3rd party class that we have no access to. Since we want to have a class that implements the
 * interface Pen we use this adapter.
 */
public class PenAdapter implements Pen {

	FixedWidth pen = new FixedWidth();

	@Override
	public String write(String text) {
		return pen.reformat(text);
	}
}
