package com.forkexec.pts.domain;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Class to store points data.
 */

public class PointsData {
	private AtomicInteger points;
	private int tag;

	public PointsData(AtomicInteger points, int tag) {
		this.points = points;
		this.tag = tag;
	}

	public AtomicInteger getPoints() {
		return points;
	}

	public int getTag() {
		return this.tag;
	}

	public void setPoints(int newBalance) {
		points = new AtomicInteger(newBalance);
	}

	public void setTag(int newTag) {
		tag = newTag;
	}

}